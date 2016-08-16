package com.epam.botor.propertyeditors;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class MyStringTrimmerEditor extends StringTrimmerEditor {

	public MyStringTrimmerEditor() {
		super(true);
	}

}
