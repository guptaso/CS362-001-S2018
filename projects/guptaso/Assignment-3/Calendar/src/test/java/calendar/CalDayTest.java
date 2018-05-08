/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
public class CalDayTest{
  Appt appt1 = new Appt(1, 30, 20, 4, 2018, "HW", "HW Day", "p@gmai.com");
  Appt appt2 = new Appt(2, 29, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
  Appt appt3 = new Appt(13, 29, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
  Appt appt4 = new Appt(20, 5, 2018, "OT", "OT", "OT@gmail.com");
  Appt appt5 = new Appt(0, 2, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
  Appt appt6 = new Appt(23, 2, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
  Appt appt7 = new Appt(12, 29, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
  Appt appt8 = new Appt(12, 10, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
  Appt invalidAppt = new Appt (-1, -1, -1, -1, -1, null, null, null);

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	//CalDay day0 = null;
//	GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
	GregorianCalendar cal = new GregorianCalendar(2018, 4, 20, 11, 49, 00);
	CalDay day0 = new CalDay(cal);
	assertEquals(20, day0.getDay());
	assertEquals(2018, day0.getYear());
	day0.addAppt(appt1);
	day0.addAppt(invalidAppt);
	day0.addAppt(appt2);
	assertTrue(day0.isValid());
	
	
  }
  
  @Test(timeout = 4000) 
  public void test01() throws Throwable {
	GregorianCalendar cal1 = new GregorianCalendar(2018, 4, 20, 11, 49, 00);
	CalDay day1 = new CalDay(cal1);
	day1.addAppt(appt1);
	day1.toString();
	assertEquals("\t --- 6/20/2018 --- \n --- -------- Appointments ------------ --- \n\t4/20/2018 at 1:30am ,HW, HW Day\n \n",day1.toString());
	
  }

  @Test(timeout = 4000) 
  public void test02() throws Throwable {
	GregorianCalendar cal2 = new GregorianCalendar(2018, 4, 20, 11, 49, 00);
	CalDay day2 = new CalDay(cal2);
	day2.addAppt(appt2);
	assertEquals("5-20-2018 \n\t2:29AM OT OT Day ",day2.getFullInfomrationApp(day2));
}

  @Test(timeout = 4000) 
  public void test03() throws Throwable {
	GregorianCalendar cal3 = new GregorianCalendar(2018, 4, 20, 19, 49, 00);
	CalDay day3 = new CalDay(cal3);
	day3.addAppt(appt3);
	assertEquals("5-20-2018 \n\t1:29PM OT OT Day ",day3.getFullInfomrationApp(day3));
  }

  @Test(timeout = 4000)
  public void test04() throws Throwable {
	GregorianCalendar cal4 = new GregorianCalendar(2018, 4, 20, 19, 49, 00);
	CalDay day4 = new CalDay(cal4);
	day4.addAppt(appt4);
	assertEquals("5-20-2018 \n\tOT OT ",day4.getFullInfomrationApp(day4));
  }

  @Test(timeout = 4000) 
  public void test05() throws Throwable {
	GregorianCalendar cal5 = new GregorianCalendar(2018, 4, 20, 19, 49, 00);
	CalDay day5 = new CalDay(cal5);
	day5.addAppt(appt5);
	assertEquals("5-20-2018 \n\t12:02AM OT OT Day ",day5.getFullInfomrationApp(day5));
	assertEquals(1, day5.getSizeAppts());
  }
 
  @Test(timeout = 4000) 
  public void test06() throws Throwable {
	GregorianCalendar cal6 = new GregorianCalendar(2018, 4, 21, 11, 49, 00);
	CalDay day6 = new CalDay(cal6);
	Appt appt9 = new Appt(-1, -1, -1, -1, -1, "Nothing", "Empty Day", "person@gmail.com");
	appt9.setValid();
	day6.addAppt(appt9);
  }	


  @Test(timeout = 4000) 
  public void test07() throws Throwable {
	GregorianCalendar cal6 = new GregorianCalendar(2018, 4, 21, 11, 49, 00);
	CalDay day6 = new CalDay(cal6);
	day6.addAppt(appt7);
	appt7.setValid();
	assertEquals("5-21-2018 \n\t0:29AM OT OT Day ",day6.getFullInfomrationApp(day6));
	java.util.LinkedList <calendar.Appt> appt8;
	appt8=day6.getAppts();
	assertTrue(appt7.getValid());
  }	

  @Test(timeout = 4000) 
  public void test08() throws Throwable {
	GregorianCalendar cal6 = new GregorianCalendar(2018, 4, 21, 11, 49, 00);
	LinkedList<Appt> a = new LinkedList<Appt>();
	
	CalDay day6 = new CalDay(cal6);
	assertEquals(day6.getAppts(), a);
	assertEquals(day6.getAppts().size(),0);
	day6.addAppt(appt8);
	appt8.setValid();
	assertEquals("5-21-2018 \n\t0:10AM OT OT Day ",day6.getFullInfomrationApp(day6));
  	Appt appt9 = new Appt(18, 30, 20, 4, 2018, "HW", "HW Day", "p@gmai.com");
	appt9.setValid();
	day6.addAppt(appt9);
	//assertEquals(day6.addAppt(appt9), day6.getAppts());
  }	

  @Test(timeout = 4000) 
  public void test09() throws Throwable {
	CalDay day6 = new CalDay();
	assertFalse(day6.isValid());
	assertEquals(day6.iterator(), null);
  	Appt appt12 = new Appt(2, 29, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
	assertEquals(day6.iterator(), null);
	//Appt appt9 = new Appt(null,null,null,null,null,null,null,null);
  }
 
  @Test(timeout = 4000) 
  public void test10() throws Throwable {
	GregorianCalendar cal6 = new GregorianCalendar();
	CalDay day = new CalDay(cal6);
  	Appt appt12 = new Appt(2, 29, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
	Appt appt13 = new Appt(13, 29, 19, 3, 2019, "OT", "OT Day", "g@gmail.com");
	Appt appt14 = new Appt(20, 5, 2018, "OT", "OT", "OT@gmail.com");
	java.util.LinkedList <calendar.Appt> appt30;
	day.addAppt(appt12);
	day.addAppt(appt13);
	day.addAppt(appt14);
	appt30 = day.getAppts();
	String convert;
	int size;
	size = day.getSizeAppts();
	assertTrue(appt12.getValid());
	assertEquals(3, size);
	convert = day.toString();
//	assertEquals(convert, " ");
  }
}
