package Main.SnakeAndLadder;

public class Dice {
    private int NumberOfDice;

    Dice(int numberOfDice) {
        NumberOfDice = numberOfDice;
    }

    int rollDice(){
        return ((int) (Math.random()*(6*NumberOfDice - 1*NumberOfDice))) + 1;
    }

}
