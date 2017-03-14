package first_java;

import java.util.Calendar;
import static java.util.Calendar.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class CalendarDate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		calendar.roll(MONTH, 1);
		System.out.println(calendar.get(MONTH)+"月"+calendar.get(DAY_OF_MONTH)+"日");

		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss",Locale.CHINA);
		System.out.println(formatter.format(date));
		
		date = new SimpleDateFormat("yyyy-MM-dd").parse( "2013-4-23" );
		calendar.setTime(date);
		System.out.println(calendar.getDisplayName(DAY_OF_WEEK, SHORT, Locale.CHINA));
		
		
		//以下是java8
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime now2=LocalDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(now2);
		

		
		LocalDateTime d1 = LocalDateTime.of(2015, 12,31,23,59,58);
		LocalDateTime d2= LocalDateTime.parse("2015-12-31T23:59:58");
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime d3=LocalDateTime.parse("2015/12/31 23:59:58",formatter2);
		System.out.println(formatter2.format(d3));
		System.out.println(d3);
		
//		Date now3=new Date();
//		System.out.println(formatter2.format(now3));  format这里不能处理Date类
		
		System.out.println("###############");
	        System.out.println(d3.getYear());
	        System.out.println(d3.getMonth()); //这不是整数，而是枚举
	        System.out.println(d3.getDayOfYear());
	        System.out.println(d3.getDayOfMonth());
	        System.out.println(d3.getDayOfWeek());
	        System.out.println(d3.getHour());
	        System.out.println(d3.getMinute());
	        System.out.println(d3.getSecond());
	        System.out.println(d3.getNano()); 
	        
	        LocalDateTime d7 = d3.minusDays(1);
	        LocalDateTime d8 = d3.plusHours(1).plusMinutes(30);
			System.out.println(d7);
			System.out.println(d8);
	}

}
