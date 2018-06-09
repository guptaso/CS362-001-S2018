
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest00()
   {
//You can use this function to implement your manual testing	   
      	   String[] schemes = {"http","https"};
   	   UrlValidator urlValidator = new UrlValidator(schemes);
	   
//	   assertFalse(urlValidator.isValid(""));
  // 	   assertFalse(urlValidator.isValid(":// www.google.com:80/test1?action=view"));
	   assertFalse(urlValidator.isValid(":/www.cs.com"));
	   
//	   assertTrue(urlValidator.isValid("https://google.com:80/test1?action=view"));
//	   assertTrue(urlValidator.isValid("http://www.yahoo.com"));
//	   assertTrue(urlValidator.isValid("http://www.google.com:80/test1?action=view"))
	   
	  //*NO FAILURES:
//	   assertFalse(urlValidator.isValid("https://google.com:80/test1?action=view"));
//	   assertFalse(urlValidator.isValid("http://www.yahoo.com"));
//	   assertFalse(urlValidator.isValid("http://www.google.com:80/test1?action=view"));
   	   
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
