package com.epam.botor.domain;

public enum ForceSide {

    LIGHT, DARK;

	public static ForceSide getRandomSide() {
		return Math.random() > 0.5 ? LIGHT : DARK;
	}

}
