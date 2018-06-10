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

 
	// Tests the scheme   
	public void testYourFirstPartition() {
		System.out.println("Testing Scheme\n");
		UrlValidator urlVal3 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	
		// null scheme == invalid
		assertFalse(urlVal3.isValidScheme(null));

//		asser
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
		System.out.println("Testing Path\n");
		UrlValidator urlVal3 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		UrlValidator urlVal4 = new UrlValidator(null, null, UrlValidator.ALLOW_2_SLASHES);
		// A path is not valid if there is no path
		assertFalse(urlVal3.isValidPath(null));

		// A path is not valid if there are 2 slashes, w/out a flag set
		assertFalse(urlVal3.isValidPath("//www.google//"));
		
		// Invalid because no single slash indicating where to go
		assertFalse(urlVal3.isValidPath("google"));
		assertFalse(urlVal3.isValidPath("search"));
	
		// An example of a valid path
		assertTrue(urlVal3.isValidPath("/search"));
		
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
			int randAuthority = rand.nextInt(3);
			int randPort = rand.nextInt(2);
			int randPath = rand.nextInt(3);
			int randQuery = rand.nextInt(1);

			validUrl = (schemes[randScheme]+authority[randAuthority]+port[randPort]+path[randPath]+query[randQuery]);
			
			//System.out.println(iteration+validUrl);
			assertTrue(urlVal1.isValid(validUrl));
		      }catch(AssertionError e) {
		   	//System.out.println(validUrl+" failed");
		   	System.out.println(" failed");
		      }
			System.out.print("\n\n");
	}
	
	//Tests randomly generated invalid URLs
	public void testIsValid2() {	
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
			int randAuthority2 = rand2.nextInt(3);
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
