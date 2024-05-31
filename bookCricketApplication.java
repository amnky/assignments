package com.amnky.assignments;

import java.util.Random;
import java.util.Scanner;

public class bookCricketApplication {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String array[]=new String[2];
		for(int i=0;i<2;i++) {
			System.out.println("Enter Name of Player "+(i+1)+":");
			array[i]=scanner.nextLine();
		}
		
		System.out.println("Enter number of pages in book: ");
		 
		int pages=scanner.nextInt();
		Random random=new Random();
		int turn=0,pageNumberGenerated,totalScore=0,score=0;
		int i=0,player1Score=0,player2Score=0;int player1Turns = 0,player2Turns=0;
		char k;
		while(i<2) {
			System.out.println(array[i]+" Starts playing");
			totalScore=0;
			score=0;
			turn=0;
			
			for(int j = 0;j<pages;j++) {
				if((int)i==1 && totalScore>player1Score) {
              	  break;
                }
				else {
			turn++;
			System.out.println("Enter y/n: ");
			k=scanner.next().charAt(0);
			          if(k=='y') {
			        	       
			                   pageNumberGenerated=random.nextInt(300)+1;
			                   if((pageNumberGenerated%7)!=0) {
			                	   
			                	   System.out.println("Turn: "+turn);
			        	           System.out.println("PageNumberGenerated: "+pageNumberGenerated);
			        	           score=(pageNumberGenerated%7);
			        	           System.out.println("Score: "+score);
			        	           totalScore+=score;
			        	           System.out.println("TotalScore: "+totalScore);
			                	   
			        	  }
			                   
			                   
			                  else if((pageNumberGenerated%7)==0){
			                	   System.out.println("Turn: "+turn);
			        	           System.out.println("Score: "+pageNumberGenerated);
			        	           System.out.println(array[i]+"TotalScore: "+totalScore);
			        	           break;
			}
			                  else if((int)i==1 && totalScore>player1Score) {
			                	  break;
			                  }
			           
			}
			          else if(k=='n') {
			        	  System.out.println(array[i]+"TotalScore: "+totalScore);
			        	  break;
			          }
			}
			if(i==0) {
				player1Score=totalScore;
			    player1Turns=turn;
			}
			else if(i==1) {
				player2Score=totalScore;
				player2Turns=turn;
			}
			}
			i++;
		}
    // first player score
		System.out.println(array[0]+" Total score: "+player1Score);
    // second player score
		System.out.println(array[1]+" Total score: "+player2Score);
		if(player1Score>player2Score) {
			System.out.println(array[0]+" wins");
		}
		else if(player1Score==player2Score){
			if(player1Turns<player2Turns) {
				System.out.println(array[0]+" wins");
			}
			else {
				System.out.println(array[1]+" wins");
			}
		}
		else {
			System.out.println(array[1]+" wins");
		}
		
		

	}

}
