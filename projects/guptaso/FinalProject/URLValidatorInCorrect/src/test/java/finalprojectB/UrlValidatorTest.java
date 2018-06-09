package finalprojectB;

import junit.framework.TestCase;

/* You can use this as a skeleton for your 3 different test approach
 * It is an optional to use this file, you can generate your own test 
 * 	file(s) to test the target function!
 * 	Again, it is up to you to use this file or not!
 */


public class UrlValidatorTest extends TestCase {
	private UrlValidator urlVal;
	private String url = "";

	public UrlValidatorTest(String testName) {
		super(testName);
		urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	}
	
	public void testManualTest() {
	//You can use this function to implement your manual testing	   

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
	} catch (Exception e) {
		System.out.println("TEST FAILED"); 
 	}
	}
   
	// Tests the scheme   - TESTS NOT PASSING
	public void testYourFirstPartition() {
		//You can use this function to implement your First Partition testing 
		String validUrl[] = {"http", "https", "ftp" };
		String invalidUrl[] = {"HTTP", "HTTPS", "FTP", "testurl", "hTtps"};
		String restUrl = "://www.google.com/";
	
		UrlValidator urlVal1 = new UrlValidator();

		// tests the valid URL, should be valid
		System.out.println("Next 3 tests should be true\n");
		for (int i = 0; i < 3; i++) {
			String testString = (""+validUrl[i]+restUrl);
			try{
				assertTrue(urlVal1.isValid(testString));
			} catch (AssertionError e) {
				System.out.println(testString + " failed");
			}
		
		}
	}
   
	// Tests the Authority
	public void testYourSecondPartition(){
	//You can use this function to implement your Second Partition testing	   
	}
   
	//You need to create more test cases for your Partitions if you need to
	public void testIsValid() {
	//You can use this function for programming based testing

	}
}
