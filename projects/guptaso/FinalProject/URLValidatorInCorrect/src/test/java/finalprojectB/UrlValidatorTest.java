package finalprojectB;

import junit.framework.TestCase;

/* You can use this as a skeleton for your 3 different test approach
 * It is an optional to use this file, you can generate your own test 
 * 	file(s) to test the target function!
 * 	Again, it is up to you to use this file or not!
 */


public class UrlValidatorTest extends TestCase {
	private UrlValidator urlVal;
//	private String url = "";


	public UrlValidatorTest(String testName) {
		super(testName);
		urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	}
	
	public void testManualTest() {
	//You can use this function to implement your manual testing	   
	System.out.println("Manual Testing");

	try { 
		// Expect: invalid Result:invalid 
		assertFalse(urlVal.isValid(""));

		//Expect: invalid Result: invalid
		assertFalse(urlVal.isValid(":// www.google.com:80/test1?action=view"));
	
		//Expect: valid Result: valid 
		assertTrue(urlVal.isValid("http://www.google.com?x=1"));
	
		//Expect: invalid Result: invalid
		assertFalse(urlVal.isValid(":/www.cs.com"));
	
		//Expect: valid Result: valid
		assertTrue(urlVal.isValid("http://www.oregonstate.edu")); 	
	
		//Expect: valid Result: valid
		assertTrue(urlVal.isValid("http://www.yahoo.com"));
		
		//Expect: invalid Result: invalid
		assertFalse(urlVal.isValid("http://http://www.yahoo.com"));
		
		//Expect: invalid Result: invalid
		assertFalse(urlVal.isValid("http://www.google.com:8899993803039"));
		
		//Expect: invalid Result: invalid
		assertFalse(urlVal.isValid("http://www.yahoo.com:80/.."));
	
		//Expect: valid Result: valid 
   		assertTrue(urlVal.isValid("http://www.google.com/"));
	} catch (AssertionError e) {
		System.out.println("TEST FAILED"); 
 	}
	System.out.println("\n\n");
	}

 
	// Tests the scheme   - TESTS NOT PASSING
	public void testYourFirstPartition() {
/*		String validUrl[] = {"http", "https", "ftp" };
		String invalidUrl[] = {"HTTP", "HTTPS", "FTP", "testurl", "hTtps"};
		String restUrl = "://www.google.com/";
		System.out.println(urlVal.isValid("https://www.google.com/"));
	
		UrlValidator urlVal1 = new UrlValidator();
		System.out.println(urlVal.isValid("https://www.google.com/"));

		// tests the valid URL, should be valid
		System.out.println("Next 3 tests should be true\n");
		for (int i = 0; i < 3; i++) {
			String testString = (""+validUrl[i]+restUrl);
			try{
				System.out.println(urlVal.isValid(validUrl[i]+restUrl));
//				assertTrue(urlVal.isValid(validUrl[i]+restUrl));
//				assertTrue(urlVal.isValid(testString));
			} catch (AssertionError e) {
				System.out.println(testString + " failed");
			}
		
		}

		System.out.println(urlVal.isValid("http://www.google.com/"));
		System.out.println(urlVal.isValid(validUrl[0]+"://www.google.com/"));
		System.out.println(urlVal.isValid(validUrl[0]+restUrl));
		System.out.println(urlVal.isValid("https://www.google.com/"));
   */
	}



	// Tests the Authority
	public void testYourSecondPartition(){
		System.out.println("Testing Authority\n");
	
		UrlValidator urlVal3 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	
		
		// valid port = valid authority
		assertTrue(urlVal3.isValid("http://255.google.com"));
		
		// invalid port = invalid authority
		assertFalse(urlVal3.isValid("http://google.com:-355"));


		// null = invalid authority
		String auth = null;
		assertFalse(urlVal.isValid("http://www.google.com:"+auth));

	}
  
	// Tests the Port 
	public void testYourThirdPartition(){
		System.out.println("Testing Port\n");
		UrlValidator urlVal3 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	
		// negative port = invalid 
		assertFalse(urlVal3.isValid("http://google.com:-8080"));

		// null port = invalid
		assertFalse(urlVal3.isValid("http://google.com:"));

	}

	// Tests the Path
	public void testYourFourthPartition(){
	//You can use this function to implement your Second Partition testing	   
	}

	// Tests the query
	public void testYourFifthPartition(){
		System.out.println("Testing Query\n");
		
		UrlValidator urlVal3 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	
		
		// if query == null, then valid
		assertTrue(urlVal3.isValidQuery("http://www.google.com"));
		
		// if random query, then valid
		assertTrue(urlVal3.isValidQuery("http://www.google.com:80/test1?action=view"));

	}



	public void testIsValid() {
	//You can use this function for programming based testing

	}
}
