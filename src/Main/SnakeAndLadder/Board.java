package Main.SnakeAndLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Board {
    private List<jumper> snakes;
    private List<jumper> ladders;
    private Dice dice;
    private Queue<Player> players;
    private Map<String, Integer> PlayersCurrentPosition;
    int boardSize;

    public Board(List<jumper> snakes, List<jumper> ladders, Dice dice, Queue<Player> players, Map<String, Integer> playersCurrentPosition, int boardSize) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.dice = dice;
        this.players = players;
        PlayersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

    void startGame(){
        while(players.size() > 0){
            boolean snakeBite = false;
            boolean ladder = false;
            Player player = players.poll();
            int currentPos = PlayersCurrentPosition.get(player.getName());
            int diceVal = dice.rollDice();
            int nextPos = currentPos+diceVal;
            if(nextPos > boardSize){
                players.offer(player);
            }
            else if(nextPos == boardSize){
                System.out.println(player.getName() + " has won the game");
                return;
            }
            else{
                for (int i = 0; i < snakes.size(); i++) {
                    if(snakes.get(i).getStartPos() == nextPos){
                        System.out.println(player.getName() + " is got bitten by snake and curren position is :"+ snakes.get(i).getEndPos());
                        PlayersCurrentPosition.put(player.getName(), snakes.get(i).getEndPos());
                        currentPos = snakes.get(i).getEndPos();
                        snakeBite = true;
                        players.offer(player);
                        break;
                    }
                }

                for (int i = 0; i < ladders.size(); i++) {
                    if(ladders.get(i).getStartPos() == nextPos){
                        System.out.println(player.getName() + " is climbing up the ladder and curren position is :"+ ladders.get(i).getEndPos());
                        PlayersCurrentPosition.put(player.getName(), ladders.get(i).getEndPos());
                        ladder = true;
                        players.offer(player);
                        break;
                    }
                }

                if(!snakeBite && !ladder){
                    PlayersCurrentPosition.put(player.getName(), nextPos);
                    System.out.println(player.getName() + "is at position :"+ nextPos);
                    players.offer(player);
                }

            }
        }
    }
}
