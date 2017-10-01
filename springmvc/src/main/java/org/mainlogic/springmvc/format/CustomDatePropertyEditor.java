package org.mainlogic.springmvc.format;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDatePropertyEditor extends PropertyEditorSupport {

	private SimpleDateFormat dateFormat;
	
	public CustomDatePropertyEditor() {
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
 	}
	
    public String getAsText() {
        return (this.getValue() != null && this.getValue() instanceof Date)
                ? dateFormat.format(this.getValue())
                : null;
    }
    
    public void setAsText(String text) throws java.lang.IllegalArgumentException {
        if (this.getValue() instanceof Date) {
            try {
				setValue(dateFormat.parse(text));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return;
        }
        throw new java.lang.IllegalArgumentException(text);
    }
}
