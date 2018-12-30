package com.bceden.concurrent.lock;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		ts.getTime();
//		System.out.println(t.before(new Date("2017-03")));
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		
		
		   Calendar c = Calendar.getInstance();//获得一个日历的实例   
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	        Date date = null;   
	        try{   
	            date = sdf.parse("2017-03-01");//初始日期   
	        }catch(Exception e){  

	        }   
	        c.setTime(date);//设置日历时间   
//	        String strDate = sdf.format(c.getTime()));//的到你想要得6个月后的日期   
	        System.out.println(cal.before(c));
	}

}
