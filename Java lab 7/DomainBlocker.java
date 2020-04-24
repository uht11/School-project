import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A URL domain blocker.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class DomainBlocker
{
	private TreeSet<String> blockedSet;
	
	/**
	 * Sets up the domain blocker by reading in the blocked domain names from
	 * a file and storing them in a TreeSet.
	 * @throws FileNotFoundException
	 */
	public DomainBlocker() throws FileNotFoundException
	{
		blockedSet = new TreeSet<String>();
		
		File inputFile = new File("test.txt");
		Scanner scan = new Scanner(inputFile);
		
		while (scan.hasNextLine())
		{
         String input = scan.nextLine();
         String[] parts = input.split(",");        // String array helps us seperate each string into parts
         String tName    = parts[0]; 
			blockedSet.add(tName.toLowerCase());
		}
	}
	
	/**
	 * Checks to see if the specified domain has been blocked.
	 * 
	 * @param domain the domain to be checked
	 * @return true if the domain is blocked and false otherwise
	 */
	public boolean domainIsBlocked(String domain)
	{
      domain = domain.toLowerCase();
		return blockedSet.contains(domain);
	}
}
