package com.techlabs.forloop;

import java.util.Random;
import java.util.Scanner;

public class PigTailDiceGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		// calculating final score and total number of turns
		int[] sumAndTotalTurns = calculateSum(random, sc);

		// Total score of player
		System.out.println("Total score : " + sumAndTotalTurns[0]);
		System.out.println("You finished in " + sumAndTotalTurns[1] + " turns!");
		System.out.println("Game over!");

		sc.close();
	}
	private static int[] calculateSum(Random random, Scanner sc) {
		int sum = 0;
		int totalTurns = 0;
		while (sum < 20) {
			totalTurns++;
			System.out.println("TURN : " + totalTurns);
			System.out.println("Roll or Hold:");
			String action = sc.nextLine();
			int scoreForTurn = calclateScoreForTurn(action, random, sc);
			System.out.println("Score for the turn : " + scoreForTurn);
			sum += scoreForTurn;
			System.out.println();
		}
		return new int[] { sum, totalTurns };
	}
	private static int calclateScoreForTurn(String action, Random random, Scanner sc) {
		int scoreForTurn = 0;
		while (action.equalsIgnoreCase("Roll")) {
			int dice = random.nextInt(6) + 1;
			System.out.println("Dice : " + dice);

			if (dice == 1) {
				scoreForTurn = 0;
				System.out.println("Turn over!");
				break;
			}

			scoreForTurn += dice;
			System.out.println("Roll or Hold");
			action = sc.nextLine();
		}
		return scoreForTurn;
	}
}
