package me.drawethree;

import OSPRNG.UniformDiscreteRNG;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class Priklad4 {
	public static void main(String[] args) {

		final int pocetKrokov = 1000;
		final int pocetRep = 100000;


		/**
		 * Zadanie 1
		 */

		UniformDiscreteRNG genKrok = new UniformDiscreteRNG(0,1);

		System.out.println("Zadanie 1");
		System.out.println("Odhad: " + Math.sqrt(((2*pocetKrokov)/Math.PI)));

		int total = 0;

		for (int j = 0; j < pocetRep;j++) {
			int pozicia = 0;

			for (int i = 0; i < pocetKrokov; i++) {
				int krok = genKrok.sample() == 0 ? -1 : 1;
				pozicia += krok;
			}

			total+=Math.abs(pozicia);
		}

		System.out.println("Vysledok:" + (double)total/pocetRep);


		/**
		 * Zadanie 2
		 */

		genKrok = new UniformDiscreteRNG(0,3);

		System.out.println("Zadanie 2");
		System.out.println("Odhad: " + Math.sqrt(((4*pocetKrokov)/Math.PI)));

		total = 0;

		for (int j = 0; j < pocetRep;j++) {
			int poziciaX = 0;
			int poziciaY = 0;

			for (int i = 0; i < pocetKrokov; i++) {
				int krok = genKrok.sample();
				if (krok == 0) {
					poziciaX += 1;
				} else if (krok == 1) {
					poziciaX -= 1;
				} else if (krok == 2) {
					poziciaY += 1;
				} else {
					poziciaY -= 1;
				}
			}
			total+= (Math.abs(poziciaX) + Math.abs(poziciaY));
		}

		System.out.println("Vysledok:" + (double)total/pocetRep);

		/**
		 * Zadanie 3
		 */

		genKrok = new UniformDiscreteRNG(0,5);

		System.out.println("Zadanie 3");
		System.out.println("Odhad: " + Math.sqrt(((6*pocetKrokov)/Math.PI)));

		total = 0;

		for (int j = 0; j < pocetRep;j++) {
			int poziciaX = 0;
			int poziciaY = 0;
			int poziciaZ = 0;

			for (int i = 0; i < pocetKrokov; i++) {
				int krok = genKrok.sample();
				if (krok == 0) {
					poziciaX += 1;
				} else if (krok == 1) {
					poziciaX -= 1;
				} else if (krok == 2) {
					poziciaY += 1;
				} else if (krok == 3) {
					poziciaY -= 1;
				} else if (krok == 4) {
					poziciaZ += 1;
				} else {
					poziciaZ -= 1;
				}
			}
			total+= (Math.abs(poziciaX) + Math.abs(poziciaY) + Math.abs(poziciaZ));
		}

		System.out.println("Vysledok:" + (double)total/pocetRep);

	}
}
