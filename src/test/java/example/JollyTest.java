package example;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.junit.Test;

import de.jollyday.HolidayManager;
import de.jollyday.ManagerParameter;
import de.jollyday.parameter.UrlManagerParameter;

public class JollyTest {

	HolidayManager hm;

	public JollyTest() throws MalformedURLException {
		Properties props = new Properties();
		URL url = (new java.io.File("src/main/resources/holidays.xml")).toURI().toURL();
		ManagerParameter mp = new UrlManagerParameter(url, props);
		hm = HolidayManager.getInstance(mp);
	}

	@Test
	public void goodFridayMustBeHoliday() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse("2015-04-3"));
		assertTrue(hm.isHoliday(cal));
	}

	@Test
	public void goodThursdayMustBeHoliday() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse("2015-04-2"));
		assertTrue(hm.isHoliday(cal));
	}
}
