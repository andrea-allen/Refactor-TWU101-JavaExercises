package com.thoughtworks.tw101.exercises.exercise8;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class guessingGame {
    private int randomNumber;
    private Scanner scanner;
    public boolean gameOver;
    private ArrayList<Integer> guesses;

    guessingGame() {
        randomNumber = getRandomNumber();
        scanner = new Scanner(System.in);
        gameOver = false;
        guesses = new ArrayList<Integer>();
    }

    public void play(){
        Guess guess = new Guess(); //this could be a new instance of class guess
        guess.setCorrectAnswer(randomNumber);
        while (!gameOver){
            int newGuess = recieveGuess();
            guess.setGuessValue(newGuess);  //guess.number is set to a new recieve guess
            guess.check(); //guess should check itself
            this.gameOver=guess.isCorrect;
        }
        scanner.close();
        printGuesses();
    }


    private int getRandomNumber() {
        Random r = new Random();
        int random = r.nextInt(99);
        random += 1;
        return random;
    }

    private int recieveGuess() {
        System.out.println("Please enter a valid positive integer");
        boolean validInput = false;
        int potentialGuess = 0;
        do {
            try {
                potentialGuess = Integer.parseInt(scanner.next());
                if (isWithinValidRange(potentialGuess)){
                    guesses.add(potentialGuess);
                    validInput = true;
                }
                else{
                    System.out.println("The number entered is not within 1-100. Try again.");
                }
            }
            catch (NumberFormatException e) {
                System.err.println(new NumberFormatException("Input entered is not a valid integer. Try again."));
            }

        } while (!validInput);

        return potentialGuess;
    }



    private boolean isWithinValidRange(int potentialGuess) {
        if (potentialGuess > 0 && potentialGuess < 100) {
            return true;
        }
        else{
            return false;
        }
    }


    private void printGuesses(){
        System.out.println("Here are your guesses:");
        for (int i = 0; i < guesses.size() ; i++) {
            System.out.println("guess #" + i + " was: " + guesses.get(i));
        }
    }
}

