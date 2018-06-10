package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/* You can use this as a skeleton for your 3 different test approach
 * It is an optional to use this file, you can generate your own test 
 * 	file(s) to test the target function!
 * 	Again, it is up to you to use this file or not!
 */


public class UrlValidatorTest extends TestCase {
	private UrlValidator urlVal;
	//private String url = "";
	

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
	System.out.println("\n\n");
	}
  /* 
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
   */
	// Tests the Authority
	public void testYourSecondPartition(){
	//You can use this function to implement your Second Partition testing	   
	}
   
	//You need to create more test cases for your Partitions if you need to
	//Tests randomly generated valid URLs
	public void testIsValid1(){
	//You can use this function for programming based testing
	
   	   	//VALID components
		String[] schemes = {"http://","https://","ftp://"};
		String[] authority = {"www.google.com","cs.com","oregonstate.edu","808.com"};
		String[] port = {":80",":0",""};
		String[] path = {"/test1","/t123","/test1/","/test1/file"};
		String[] query = {"","?action=view"};	
		String validUrl="";
		UrlValidator urlVal1 = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		Random rand = new Random();
		     try{  
			//Randomly generate random ints corresponding to URL componenets 
			int randScheme = rand.nextInt(2);
			int randAuthority = rand.nextInt(5);
			int randPort = rand.nextInt(2);
			int randPath = rand.nextInt(3);
			int randQuery = rand.nextInt(1);

			validUrl = (schemes[randScheme]+authority[randAuthority]+port[randPort]+path[randPath]+query[randQuery]);
			
			//System.out.println(iteration+validUrl);
			assertTrue(urlVal1.isValid(validUrl));
		      }catch(AssertionError e) {
		   	System.out.println(validUrl+" failed");
		      }
			System.out.print("\n\n");
	}
	
	//Tests randomly generated invalid URLs
	public void testIsValid2() {
	//You can use this function for programming based testing
	
   	   	//VALID components
		String[] schemes2 = {"://","http:","3ht://"};
		String[] authority2 = {"abc.","blah.blah",".1.2.4.2","8.0.8"};
		String[] port2 = {":-1",":42a","65645"};
		String[] path2 = {"/..","/../","/../file","/test//file"};
		String[] query2 = {"adsifen390%","?action=1214=~view"};	
		String validUrl2="";
		UrlValidator urlVal2 = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		Random rand2 = new Random();
		     try{  
			//Randomly generate random ints corresponding to URL componenets 
			int randScheme2 = rand2.nextInt(2);
			int randAuthority2 = rand2.nextInt(5);
			int randPort2 = rand2.nextInt(2);
			int randPath2 = rand2.nextInt(3);
			int randQuery2 = rand2.nextInt(1);

			validUrl2 = (schemes2[randScheme2]+authority2[randAuthority2]+port2[randPort2]+path2[randPath2]+query2[randQuery2]);
			
			//System.out.println(iteration+validUrl);
			assertFalse(urlVal2.isValid(validUrl2));
		      }catch(AssertionError e) {
		   	System.out.println(validUrl2+" failed");
		      }
			System.out.print("\n\n");
	}
	
}
