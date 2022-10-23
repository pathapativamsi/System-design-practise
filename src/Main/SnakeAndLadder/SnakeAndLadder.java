package Main.SnakeAndLadder;

import java.util.*;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player player1 = new Player("vamsi",1);
        Player player2 = new Player("sathwi",2);
        Queue players = new LinkedList();
        players.offer(player1);
        players.offer(player2);
        jumper snake1 = new jumper(10,2);
        jumper snake2 = new jumper(99,12);
        List<jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        jumper ladder1 = new jumper(5,25);
        jumper ladder2 = new jumper(40,89);
        List<jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        Map<String,Integer> position = new HashMap<>();
        position.put("vamsi",0);
        position.put("sathwi",0);
        Board b = new Board(snakes,ladders,dice,players,position,100);
        b.startGame();
    }
}
