package com.epam.botor;

import com.epam.botor.domain.Jedi;
import com.epam.botor.domain.LightSabre;

/**
 * Jedi Application
 *
 */
public class App {
	public static void main(String[] args) {

		LightSabre lightSabre = new LightSabre("LightSabre", 100);
		Jedi jedi = new Jedi(lightSabre);

		System.out.println(jedi.fight());

	}
}
