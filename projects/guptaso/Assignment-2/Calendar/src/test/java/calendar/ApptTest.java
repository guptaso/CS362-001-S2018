/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2016, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      //assertEquals(null, appt0.getRecurDays());
      assertEquals("\t14/9/2016 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
      assertTrue(appt0.hasTimeSet());
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());
      
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	Appt appt1 = new Appt(20, 4, 2018, null, null, null);
	assertTrue(appt1.isOn(20, 4, 2018));
	assertFalse(appt1.hasTimeSet());
}

@Test(timeout = 4000) 
	public void test02() throws Throwable {
		Appt appt2 = new Appt(0, 30, 9, 24, 2018, "Nothing", "Empty Day", "person@gmail.com");
		String string2 = appt2.toString();
		assertEquals("\t24/9/2018 at 12:30am ,Nothing, Empty Day\n", string2);	
		appt2.getXmlElement();
}
@Test(timeout = 4000) 
	public void test03() throws Throwable {
	Appt appt3 = new Appt(0, 30, 1, 2, 2000, "Nothing", "Empty Day", "person@gmail.com");
	int [] num = null;
	appt3.setRecurrence(num, 1, 1, 1);
	assertTrue(appt3.isRecurring());
	assertTrue(appt3.getValid());
	appt3.setValid();
}

@Test(timeout = 4000)
	public void test04() throws Throwable {
	Appt appt4 = new Appt(70,1,2, 3, -1, null, null, null);
	appt4.setValid();
}

@Test(timeout = 4000)
	public void test05() throws Throwable {
	Appt appt5 = new Appt(3, -1, 1, 2, 2018, null, null, null);
	appt5.setValid();
}

@Test(timeout = 4000) 
	public void test06() throws Throwable {
	Appt appt6 = new Appt(3, 3, 1, 2, -3, null, null, null);
	appt6.setValid();
}

@Test(timeout = 4000) 
	public void test07() throws Throwable {
	Appt appt7 = new Appt(3, 3, 0, 2, 2018, null, null, null);
	appt7.setValid();
}
@Test(timeout = 4000) 
	public void test08() throws Throwable {
	Appt appt8 = new Appt(2, 2, 2, 2, 2004, "Nothing", "Empty Day", "person@gmail.com");
	appt8.setValid();
}
@Test(timeout = 4000) 
	public void test09() throws Throwable {
	Appt appt9 = new Appt(0, 30, 1, 2, 1000, "Nothing", "Empty Day", "person@gmail.com");
	appt9.setValid();
}

@Test(timeout = 4000) 
	public void test10() throws Throwable {
	Appt appt9 = new Appt(-1, -1, -1, -1, -1, "Nothing", "Empty Day", "person@gmail.com");
	appt9.setValid();
	assertFalse(appt9.getValid());
}


}
