package com.amnky.assignments;

import java.util.Scanner;

public class waterbill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of units used");
		int numOfUnits = sc.nextInt();
		int meter_charge = 75;
		int charge;
		if(numOfUnits <=100) {
			charge = numOfUnits * 5;
		}
		else {
			if(numOfUnits<=250) {
				charge = numOfUnits * 10;
			}
			else {
				charge = numOfUnits * 20;
			}
		}
		
		int total_water_bill = charge + meter_charge;
		System.out.println("Tota water bill : " + total_water_bill);
		sc.close();
	}

}
