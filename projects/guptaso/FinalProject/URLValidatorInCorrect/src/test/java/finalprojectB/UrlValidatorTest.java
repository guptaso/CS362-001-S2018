
package finalprojectB;

import junit.framework.TestCase;
//import java.util.Random;
//import java.util.calendar;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

	private UrlValidator urlVal;
	private String url = "";
		
   public UrlValidatorTest(String testName) {
      super(testName);
   	urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   

   	//Expect: invalid Result:invalid 
   	System.out.println(urlVal.isValid(""));

	//Expect: invalid Result: invalid
	System.out.println(urlVal.isValid(":// www.google.com:80/test1?action=view"));

	//Expect: valid Result: valid 
   	System.out.println(urlVal.isValid("http://www.google.com?x=1"));

	//Expect: invalid Result: invalid
	System.out.println(urlVal.isValid(":/www.cs.com"));

	//Expect: valid Result: valid
  	System.out.println(urlVal.isValid("http://www.oregonstate.edu")); 	

	//Expect: valid Result: valid
	System.out.println(urlVal.isValid("http://www.yahoo.com"));
	
	//Expect: invalid Result: invalid
	System.out.println(urlVal.isValid("http://http://www.yahoo.com"));
	
	//Expect: invalid Result: invalid
	System.out.println(urlVal.isValid("http://www.google.com:8899993803039"));	
	
	//Expect: invalid Result: invalid
	System.out.println(urlVal.isValid("http://www.yahoo.com:80/.."));

	//Expect: valid Result: valid 
   	System.out.println(urlVal.isValid("http://www.google.com/"));

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
