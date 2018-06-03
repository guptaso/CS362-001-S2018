
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{
  Appt appt0 = new Appt(1, 30, 20, 4, 2018, "Homework", "Study Day", "person@gmail.com");
  Appt appt1 = new Appt(1, 30, 20, 4, 2018, "Homework", "Study Day", "person@gmail.com");
  Appt invalidAppt = new Appt(-1, -1, -1, -1, -1, "Nothing", "Empty Day", "person@gmail.com");
  GregorianCalendar apt5 = new GregorianCalendar(2018, 4, 20, 11, 49, 00);
  GregorianCalendar apt6 = new GregorianCalendar(2018, 2, 20, 11, 49, 00);


  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	DataHandler dh0 = new DataHandler();
	assertTrue(dh0.saveAppt(appt0));
	assertTrue(dh0.deleteAppt(appt0));
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	DataHandler dh1 = new DataHandler("fileName", false);
	assertTrue(dh1.save());
	assertTrue(dh1.saveAppt(appt0));
	assertTrue(dh1.deleteAppt(appt0));
  }

  @Test(timeout = 4000) 
  public void test02() throws Throwable {
	DataHandler dh2 = new DataHandler("filename0");
        GregorianCalendar apt1 = new GregorianCalendar(2018, 4, 20, 11, 49, 00);
        GregorianCalendar apt2 = new GregorianCalendar(2018, 2, 20, 11, 49, 00);
	dh2.getApptRange(apt2, apt1);
  }
	
  @Test(timeout = 4000) 
  public void test03() throws Throwable {
	DataHandler dh3 = new DataHandler("filename1");
  	int [] num = {1,2};
	appt1.setRecurrence(num, 1, 1, 1);
	assertTrue(dh3.saveAppt(appt0));
	assertTrue(dh3.saveAppt(appt1));
  }

  @Test(timeout = 4000) 
  public void test04() throws Throwable {
	DataHandler dh4 = new DataHandler("filename2");
	assertTrue(dh4.saveAppt(appt0));
	assertTrue(dh4.saveAppt(appt1));
	dh4.getApptRange(apt6, apt5);
  }

  @Test(timeout = 4000) 
  public void test05() throws Throwable {
	DataHandler dh5 = new DataHandler("filename3");
	int[] numArr = {};
	appt0.setRecurrence(numArr, appt0.RECUR_BY_WEEKLY, 2, 1);
	assertTrue(dh5.saveAppt(appt0));
	assertTrue(dh5.saveAppt(appt1));
	dh5.getApptRange(apt6, apt5);
  
}
  
  @Test(timeout = 4000)
  public void test06() throws Throwable {
	DataHandler dh6 = new DataHandler("filename4");
	int[] numArr = {1};
	appt0.setRecurrence(numArr, appt0.RECUR_BY_YEARLY, 2, 2);
	assertTrue(dh6.saveAppt(appt0));
	dh6.getApptRange(apt6, apt5);
  }

  @Test(timeout = 4000) 
  public void test07() throws Throwable {
	DataHandler dh7 = new DataHandler("filename5");
	invalidAppt.setValid();
	assertFalse(dh7.saveAppt(invalidAppt));
	assertTrue(dh7.save());
	assertFalse(dh7.deleteAppt(invalidAppt));
  }

  @Test(timeout = 4000)
  public void test08() throws Throwable {
	DataHandler dh8 = new DataHandler("filename6");
	int[] numArr = {90};
	appt0.setRecurrence(numArr, 9, 9, 9);
	assertTrue(dh8.saveAppt(appt0));
	dh8.getApptRange(apt6, apt5);
  }

  @Test(timeout = 4000)
  public void test09() throws Throwable {
	DataHandler dh9 = new DataHandler("filename7");
	appt0.setXmlElement(null);
	dh9.deleteAppt(appt0);
	int[] numArr = {1,2,3,2,3};
	appt0.setRecurrence(numArr, appt0.RECUR_BY_WEEKLY, 3, 3);
	assertTrue(dh9.saveAppt(appt0));
	dh9.getApptRange(apt6, apt5);
	//assertTrue(dh9.isValid());
  }

  @Test(timeout = 4000)
  public void test10() throws Throwable {
	DataHandler dh10 = new DataHandler("filename8");
	Appt appt90 = new Appt(1, 30, 20, 4, 2018, "Homework", "Study Day", "person@gmail.com");
	assertTrue(dh10.saveAppt(appt90));
	assertTrue(appt90.getValid());
	try {
		dh10.getApptRange(apt5, apt6);
	}
	catch(Exception e){
	}
   
  }

  @Test(timeout = 4000) 
  public void test11() throws Throwable {
	DataHandler data = new DataHandler("filename9", true);
	Appt appoint = new Appt(0, 0, 0, 0, 0, null, null, null);
	assertFalse(data.deleteAppt(appoint));
	Appt appoint2 = new Appt(1, 1, 1, 1,1, "some", "some", "some");
	data.saveAppt(appoint2);
	Appt appoint3 = new Appt(1, 1, 1, 1,1, "some", "some", "some");
	data.saveAppt(appoint3);
	assertTrue(data.deleteAppt(appoint3));
	assertEquals(appoint3.getXmlElement(), null);
	assertTrue(data.save());
  }
  
  @Test(timeout = 4000)
  public void test12() throws Exception {
	DataHandler data = new DataHandler("filname10");
	boolean thrown = false;
	try {
		data.save();
	} catch (Exception e) {
		thrown = true;
	}
	assertFalse(thrown);

  }


}
