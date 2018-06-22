import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution{
	
	private static int MAX_LINES = 100;
	
	public static void main(String[] args){
		int printableCharacters = (int ) Math.pow(10, 4);
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		if (testCases > MAX_LINES) {
			System.out.println("Maximum of lines is 100!");
		}
		
        while (testCases>0 ) {
            String line = in.nextLine();
            
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
            	String text = m.group(2);
            	int legthLine = text.length();
            	
            	if (legthLine > printableCharacters) {
            		System.out.println(text.substring(0, printableCharacters ) + "....Maximum printable exceeded");
				}else
					System.out.println(text);
 
            	matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
            testCases--;
        }
    
	}
}

	