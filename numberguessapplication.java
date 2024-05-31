package com.techlabs.whileloop;

import java.util.Scanner;

public class NumberGuessApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean playGame = true;
		
		while(playGame) {
			int randomNumber = (int) (Math.random()*100);
			int attempts = 0;
			System.out.println("Guess the number");
			
			while(attempts < 5) {
				int guessedNumber = sc.nextInt();
				if(guessedNumber==randomNumber) {
					System.out.println("You won in attempts : "+ (attempts+1));
					break;
				}
				else if(guessedNumber>randomNumber) {
					System.out.println("Sorry too high");
				}
				else {
					System.out.println("Sorry too low");
				}
				attempts++;
			}
			
			if (attempts == 5) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }
			
			System.out.println("Do you wish to play the game again ? Yes or No");
			String response = sc.next();
			
			if(!response.equalsIgnoreCase("Yes")) {
				playGame = false;
			}
			
		}
		sc.close();
	}

}
