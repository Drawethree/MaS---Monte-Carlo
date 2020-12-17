package me.drawethree;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Priklad8 {
	public static void main(String[] args) {
		TriangularRNG triangularHaZaHodinu = new TriangularRNG(1.0, 3.0, 3.5);

		int rozloha = 300;

		int pocetDni = 2;

		int pracovnaDoba = 10;

		int pocetReplikacii = 1_000_000;

		int pocetKombajnov = 10;

		int zatvaUspesna = 0;

		// OD 3 DO 10 Kombajnov
		for (int k = 3; k < pocetKombajnov; k++) {
			for (int i = 0; i < pocetReplikacii; i++) {
				double priebezneZozbierane = 0;

				//pracovnaDoba * pocetDni * k - pocet, kolko hodin sa celkovo zozbiera
				for (int j = 0; j < (pracovnaDoba * pocetDni * k); j++) {
					double haZaHodinu = triangularHaZaHodinu.sample();
					priebezneZozbierane += haZaHodinu;
				}

				if (priebezneZozbierane >= rozloha) {
					zatvaUspesna++;
				}
			}
			System.out.println("Zatva bola uspesna pre pocet kombajnov " + k + " v " + ((double)zatvaUspesna / (double)pocetReplikacii * 100.0) + "% pripadoch");
			zatvaUspesna = 0;
		}

	}
}
