package Week1_day1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author  Jonathan Frey
 */
public class Exercise2 {
    static int guess=0;
    static Scanner myObj = new Scanner(System.in);

    static int inputUser(){
        System.out.println("Please enter a number between 1 and 100:");
        guess =  myObj.nextInt();
        return guess;
    }

    public static void main(String[] args) {

        //generate random int
        Random rand = new Random();
        int answer = rand.nextInt(100);

        //print answer for testing
        System.out.println(answer);

        //take user input
        int userGuess =  inputUser();

        //give user 5 chances
        int tries = 4;
        while(guess<answer-10 || guess>answer+10){
            System.out.println("Wrong guess try again: " + tries + " tries left");
            userGuess = inputUser();
            tries--;
            if(tries == 0){
                System.out.println("Sorry. The answer was: " + answer);
                System.exit(0);
            }
        }
        System.out.println("You've won. The answer is " + answer);
        System.exit(0);





    }
}
