package com.epam.botor.converters;

import org.springframework.core.convert.converter.Converter;

import com.epam.botor.domain.LightSabre;

public class LightSabreConverter implements Converter<String, LightSabre> {

	@Override
	public LightSabre convert(String source) {
		String[] textParts = source.split(",");

		String name = textParts[0];
		int damage = Integer.parseInt(textParts[1].trim());

		return new LightSabre(name, damage);

	}
}
