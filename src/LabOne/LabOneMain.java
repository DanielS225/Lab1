package LabOne;

import java.util.Scanner;

public class LabOneMain {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);//new scanner for text input
		
		System.out.println("Years working until retirement:");
		int t = input.nextInt();//years until retirement
		
		double r = 0;;//declares variable with incorrect value to avoid error
		boolean done = false;
		while (done == false) {
			System.out.println("Interest rate before retirement (as percentage, 0% < rate <= 20%):");
			r = input.nextDouble();//annual interest rate
			if (r <= 20 && r > 0) {
				done = true;
			}
			else {
				System.out.println("Invalid entry, please follow parameters");
			}
		}
		
		System.out.println("Years in retirement:");
		double t2 = input.nextDouble();//how many years do you expect to live in retirement
		
		System.out.println("How much money do you expect from SS each month?");
		double SSI = input.nextDouble();//SSI monthly payments in retirement
		
		System.out.println("Money needed monthly in retirement:");
		double needed = input.nextDouble();//expected income during retirement
		
		double diff = needed - SSI;
		
		double r2 = 0;//declares variable with incorrect value to avoid error
		done = false;
		while (done == false) {
			System.out.println("Retirement interest rate (as percentage, 0% < rate <= 3%):");
			r2 = input.nextDouble();//interest while retired
			if (r2 <=3 && r2 > 0) {
				done = true;
			}
			else {
				System.out.println("Invalid entry, please follow parameters");
			}
		}
		
		double M = 0;//money is zero, counting backwards
		
		/*for (int x = 1; x <= t2; x++) {//calculates money needed for retirement by reversing interest/withdrawal process
			for (int y = 1; y <= 12;y++) {//based on given number of years and a monthly compounding of interest
				M = M + diff;//adds withdrawals (difference between income and SSI)
				M = M/(1+r2/1200);//subtracts the interest the account would make
			}
		}*/
		
		M = diff*((1-Math.pow((1+(r2/1200)), -12*t2))/(r2/1200));
		
		System.out.println("You will need $" + M + " saved by retirement.");
		
		double money = M/(((Math.pow((1+r/1200),(12*t)))-1)/(r/1200));//monthly deposit needed each month before retirement
		System.out.println("You will have to deposit $" + money + " per month before retirement.");
		input.close();
	}
}
