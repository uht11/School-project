//Uzzul Hussain
//CS 114 - 002
//Problem 3
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Domain checking driver.
 * 
 */
public class DomainChecker
{
	/**
	 * Repeatedly reads a domain interactively from the user and checks to
	 * see if that domain has been blocked.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		DomainBlocker blocker = new DomainBlocker();
		Scanner scan = new Scanner(System.in);

		String domain;

		do
		{
			System.out.print("Enter a domain (DONE to quit): ");
			domain = scan.nextLine();

			if (!domain.equalsIgnoreCase("DONE"))
			{
				if (blocker.domainIsBlocked(domain))
					System.out.println("That staff exists.");
				else
					System.out.println("That staff not found.");
			}
		} while (!domain.equalsIgnoreCase("DONE"));
	}
}
