/**
 * This Java Code tests the strength of a Password based on its LENGTH property.
 * This program can only check a password's strength based on the function of length. This will be effective against brute-force attacks only.
 * Author: (Debdrik Debnath)
**/

import java.util.Scanner;
import java.util.InputMismatchException;

public class PasswordStrengthChecker
{
	public static void reExecution()
	{
		try
		{
			System.out.println("\n\nTo stop, enter 0 or a non-numeric value.");
			System.out.println("To run the program again, enter a non-zero numeric value less than 9223372036854775807.\n");
			long Yes$No; 
			Scanner reexecutionObj = new Scanner(System.in);
			Yes$No = reexecutionObj.nextLong();
			if (Yes$No == 0)
			{
				System.out.println("Exiting the program . . . ");
				System.exit(0);
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Exiting the program . . . ");
			System.exit(0);
		}
	}
	// First put your entire code in an infinite while loop.
	// Then call this method right at the end of the while loop (not after it)
	
	public static void repeatUser(String inpt) { System.out.println("Entered Password\t: " + inpt + "\nNo. of Characters\t: " + inpt.length()); }
	// This method is called to print what the user entered for "genuine verification purposes" and not to just annoy the user.

	public static void printCrackStats(String time) { System.out.println("It will take about " + time + " to crack with brute-force."); }
	// This method is called to print the time it will take to hack the pasword using brute-force on an average computer.

	public static void adviceNew(String advice) { System.out.println(advice); }
	// This method is called to give the user some personalised advice (based on the strength of their passwords).

	public static void adviceDefault() { System.out.println("If are sure that you can remember it, try adding a few characters."); }
	// This method is called to give the user an optional default advice.

	public static void main(String[] args)
	{
		Scanner myObj = new Scanner(System.in);
		String Pass;
		
		while (true)
		{
			System.out.println ("\n\n\nPlease enter a Password. Then your password will be assessed on its strength.");
			System.out.println ("NOTE: This program can only check your password's strength based on the function of length. This will be effective against brute-force attacks but not against proper guesses based on complexity and unpredictability.");
			System.out.println ("i.e. The passwords 'PASSWORD123' and 'il@fxb^%*hg7' will be considered equally strong ... but it obviously isn't the case!\n");
			Pass = myObj.nextLine();
			     
			switch (Pass.length()) // Providing an output based on the password (input) length.
			{
				case 0:
					repeatUser(Pass);
					printCrackStats("0 amount of time");
					adviceNew("Please report the site/application/program that allowed you to use this password.");
					adviceDefault();
					System.out.println();
					break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					repeatUser(Pass);
					printCrackStats("5 seconds");
					adviceNew("Try adding a few more characters.");
					System.out.println();
					break;
				case 7:
					repeatUser(Pass);
					printCrackStats("6 minutes");
					adviceDefault();
					System.out.println();
					break;
				case 8:
					repeatUser(Pass);
					printCrackStats("8 hours");
					adviceNew("This is strong enough for a casual password; a password of a service that doesn't deserve so much cybersecurity.\nBut, this isn't strong enough for important passwords.");
					adviceDefault();
					System.out.println();
					break;
				case 9:
					repeatUser(Pass);
					printCrackStats("3 weeks");
					adviceNew("This is strong enough for even an important password; a password of a service that deserves much cybersecurity.\nBut, this isn't strong enough for very important passwords; passwords used for commercial purposes.");
					adviceDefault();
					System.out.println();
					break;
				case 10:
				case 11:
					repeatUser(Pass);
					printCrackStats("400 years");
					adviceNew("This is strong enough for even very important passwords; passwords used for commercial purposes.");
					System.out.println();
					break;
				default:
					repeatUser(Pass);
					printCrackStats("millions of years");
					adviceNew("Still, remembering this password will be difficult for most people and writing it down will be a security risk.");
					System.out.println();
					break;
			}
			reExecution();
		}
	}
}