package com.epam.botor.converters;

import org.springframework.core.convert.converter.Converter;

import com.epam.botor.domain.EnergyWeapon;
import com.epam.botor.domain.LightSabre;

public class EnergyWeaponConverter implements Converter<String, EnergyWeapon> {

	@Override
	public EnergyWeapon convert(String source) {
		String[] textParts = source.split(",");

		String name = textParts[0];
		int damage = Integer.parseInt(textParts[1].trim());

		return new LightSabre(name, damage);

	}
}
