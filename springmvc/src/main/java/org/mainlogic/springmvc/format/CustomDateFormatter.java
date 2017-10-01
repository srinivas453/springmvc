package org.mainlogic.springmvc.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CustomDateFormatter implements Formatter<Date> {
	
	private SimpleDateFormat dateFormat;
	
	public CustomDateFormatter() {
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
	}

	@Override
	public String print(Date date, Locale locale) {
		
		return dateFormat.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		
		return dateFormat.parse(text);
	}

}
