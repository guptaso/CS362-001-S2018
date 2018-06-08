
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	url = "";
	System.out.println(urlValidatorInCorrect.isValid(url));
	
	url = ":// www.google.com:80/test1?action=view";
	System.out.println(urlValidatorInCorrect.isValid(url));

	url = " http://www.google.com:80/test1?action=view";
	System.out.println(urlValidatorInCorrect.isValid(url));

	url = "www.cs.com";
	System.out.println(urlValidatorInCorrect.isValid(url));

	url = " https://www.google.com:80/test1?action=view";
	System.out.println(urlValidatorInCorrect.isValid(url));

	url = "http://www.yahoo.com";	
	System.out.println(urlValidatorInCorrect.isValid(url));
   
	System.out.println("EXPECTED\n:");

   	//Expect: invalid Result: 
   	System.out.println(urlValidatorInCorrect.isValid(""));
	//Expect: invalid Result: 
	System.out.println(urlValidatorInCorrect.isValid(":// www.google.com:80/test1?action=view"));
   	//Expect: valid Result: 
	System.out.println(urlValidatorInCorrect.isValid(" http://www.google.com:80/test1?action=view"));
   	//Expect: invalid Result: 
	System.out.println(urlValidatorInCorrect.isValid("www.cs.com"));
   	//Expect: valid Result: 
	System.out.println(urlValidatorInCorrect.isValid(" https://www.google.com:80/test1?action=view"));
   	//Expect: valid Result: 
	System.out.println(urlValidatorInCorrect.isValid("http://www.yahoo.com"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
