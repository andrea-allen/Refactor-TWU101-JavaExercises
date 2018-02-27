package com.thoughtworks.tw101.exercises.exercise8;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//on fail make sure to close scanner

//Added new comment to test version control -andrea
//More comments
//Adding a third new line to keep testing

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
        int guess;
        while (!gameOver){
            askForGuess();
            guess = recieveGuess();
            check(guess);
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
        boolean validInput = false;
        int potentialGuess;
        int guess = 0; //not ideal
        do {
            try {
                potentialGuess = Integer.parseInt(scanner.next());
                if (isWithinValidRange(potentialGuess)){
                    guess = potentialGuess;
                    guesses.add(guess);
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

        return guess;
    }

    private void check(int guess){
        if (guess == randomNumber) {
            System.out.println("you guessed right! you win!");
            gameOver = true;
            return;
        }
        if (guess>randomNumber){
            System.out.println("you guessed too high!");
        }
        else{
            System.out.println("you guessed too low!");
        }
    }

    private boolean isWithinValidRange(int potentialGuess) {
        if (potentialGuess > 0 && potentialGuess < 100) {
            return true;
        }
        else{
            return false;
        }
    }

    private void askForGuess() {
        System.out.println("Please enter a valid positive integer");
    }


    private void printGuesses(){
        System.out.println("Here are your guesses:");
        for (int i = 0; i < guesses.size() ; i++) {
            System.out.println("guess #" + i + " was: " + guesses.get(i));
        }
    }
}

