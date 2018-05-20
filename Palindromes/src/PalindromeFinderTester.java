
/**
 * Use the PalindromeFinder class
 * Only considers letters - numbers, whitespace, and punctuation will be ignored.
 * @author mvail
 * @author Matt T 
 */
public class PalindromeFinderTester 
{
	/**
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		String palindrome1 = "kayak";
		String palindrome2 = "I saw I was I";
		String palindrome3 = "Racecar";
		String palindrome4 = "Go hang a salami, I'm a lasagna hog.";
		String notAPalindrome = "abracadabra";
		String emptyString = "";

		System.out.println("Testing PalindromeFinder");
		System.out.println();
		
		PalindromeFinder pFinder1 = new PalindromeFinder(palindrome1);
		validateIsPalindrome(pFinder1, palindrome1, true); 
		
		PalindromeFinder pFinder2 = new PalindromeFinder(palindrome2);
		validateIsPalindrome(pFinder2, palindrome2, true); 
		
		PalindromeFinder pFinder3 = new PalindromeFinder(palindrome3);
		validateIsPalindrome(pFinder3, palindrome3, true); 
		
		PalindromeFinder pFinder4 = new PalindromeFinder(palindrome4);
		validateIsPalindrome(pFinder4, palindrome4, true); 

		PalindromeFinder pFinder5 = new PalindromeFinder(notAPalindrome);
		validateIsPalindrome(pFinder5, notAPalindrome, false); 
		
		PalindromeFinder pFinder6 = new PalindromeFinder(emptyString);
		validateIsPalindrome(pFinder6, emptyString, true); 
	}
	
	/**
	 * @param finder PalindromeFinder to test
	 * @param originalString String being tested
	 * @param expectedResult boolean expected return value 
	 */
	private static void validateIsPalindrome(PalindromeFinder finder, String originalString, boolean expectedResult) 
	{
		boolean result = finder.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): \n\texpected = %b, result = %b\t\t%s\n\n",
				originalString, expectedResult, result, (expectedResult==result?"PASS":"***FAIL***"));		
	}
}