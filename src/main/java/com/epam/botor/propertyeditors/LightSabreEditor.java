package com.epam.botor.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.epam.botor.domain.LightSabre;

public class LightSabreEditor extends PropertyEditorSupport {

	@Override
    public void setAsText(final String text) {

        String[] textParts = text.split(",");

        String name = textParts[0];
        int damage = Integer.parseInt(textParts[1].trim());

        LightSabre result = new LightSabre(name, damage);

        setValue(result);
    }
}