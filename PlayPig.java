package com.amnky.assignments;

import java.util.Random;
import java.util.Scanner;

public class PlayPig {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = 20, randomNumber;
        int score = 0;
        int final_score = 0;
        int turns = 1;
        int i;
        for (i = 1;; i++) {
            System.out.println("Enter r/h");
            char turn = scanner.next().charAt(0);
            if (turn == 'r') {
                System.out.println("Turn " + turns);
                int d = 1;
                d++;
                randomNumber = random.nextInt(6) + 1;
                System.out.println("Die " + randomNumber);
                if (randomNumber == 1) {
                    score = 0;
                    turns += 1;
                } 
                else {
                    score += randomNumber;
                    System.out.println("score: " + score);
                }
            } 
            else if (turn == 'h') {
                turns += 1;
                final_score += score;
                score = 0;
                System.out.println("final score : " + final_score);
                
                if (final_score > 20) {
                    System.out.println("You won");
                    System.out.println("No.of turns : " + turns);
                    break;
                }
            }
        }
    }
}
