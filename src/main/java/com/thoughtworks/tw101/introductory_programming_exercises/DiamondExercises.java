package com.thoughtworks.tw101.introductory_programming_exercises;


public class DiamondExercises {
    public static void main(String[] args) {
        drawAnIsoscelesTriangle(3);
        drawADiamond(8);
        drawADiamondWithYourName(3);
    }

//    Isosceles Triangle
//    Given a number n, print a centered triangle. Example for n=3:
//              *
//             ***
//            *****
//

    private static void drawAnIsoscelesTriangle(int n) {
        StringBuffer[] triangle = getIsoscelesTriangle(n);
        for (int i = 0; i <triangle.length ; i++) {
            System.out.println(triangle[i]);
        }
    }

    private static void drawAnUpsideDownTriangle(int n) {
        StringBuffer[] triangle = getIsoscelesTriangle(n);
        for (int i = (triangle.length) - 2; i>=0; i--) {
            System.out.println(triangle[i]);
        }

    }

//    Diamond
//    Given a number n, print a centered diamond. Example for n=3:
//              *
//             ***
//            *****
//             ***
//              *

    private static void drawADiamond(int n) {

        drawAnIsoscelesTriangle(n);

        drawAnUpsideDownTriangle(n);

    }


    //    Diamond with Name
//    Given a number n, print a centered diamond with your name in place of the middle line. Example for n=3:
//
//             *
//            ***
//           Bill
//            ***
//             *
    private static void drawADiamondWithYourName(int n) {


        drawAnIsoscelesTriangle(n-1);

        System.out.println("shlok");

        drawAnUpsideDownTriangle(n);



    }

    private static StringBuffer[] getIsoscelesTriangle(int n) {
        StringBuffer[] triangle = new StringBuffer[n];
        for (int i = 0; i<n ; i++) {
            int numSpaces = n-i-1;
            int numStars = (2*i)+1;

            StringBuffer currRow = new StringBuffer();
            addEmptySpaces(numSpaces,currRow);
            addStars(numStars,currRow);
            triangle[i] = currRow;
        }
        return triangle;
    }


    private static void addEmptySpaces(int spaces, StringBuffer currRow){
        for (int j = 0; j < spaces ; j++) {
            currRow.append(" "); 
        }
    }

    private static void addStars(int numStars, StringBuffer currRow) {
        for (int i = 0; i < numStars ; i++) {
            currRow.append("*");
        }
    }
}
