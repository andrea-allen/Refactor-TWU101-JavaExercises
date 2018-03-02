package com.thoughtworks.tw101.exercises.exercise8;

public class Guess {


    int guessValue;
    int correctAnswer;
    boolean isCorrect;


    public Guess(){
        this.guessValue=-1;
        this.isCorrect=false;

    }


    public void setCorrectAnswer(int answer){
        this.correctAnswer=answer;
    }


    public void check(){
        if (this.guessValue == this.correctAnswer) {
            System.out.println("you guessed right! you win!");
            isCorrect = true;
            return;
        }
        if (this.guessValue>this.correctAnswer){
            System.out.println("you guessed too high!");
        }
        else{
            System.out.println("you guessed too low!");
        }
    }


    public void setGuessValue(int guess){
        this.guessValue=guess;
    }
}
