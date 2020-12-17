package me.drawethree;

import OSPRNG.TriangularRNG;

public class Priklad7 {
	public static void main(String[] args) {
		TriangularRNG generatorVakcin = new TriangularRNG(1000.0, 4000.0, 8500.0);
		double priemernyDopyt = 4500;

		int pocetReplikacia = 1000000;
		double naklady=0;
		double ziskNajVakcin = 5000000;
		double pocetNajVakcin=0;


		for (int j = 1000; j < 8501; j++) {

			int kapacitaSkladu = j;

			for (int i = 0; i < pocetReplikacia; i++) {
				double pocetVakcin = generatorVakcin.sample();

				double prem = Math.abs(pocetVakcin-j);

				if (pocetVakcin > j) {
					naklady += prem*150;
				} else if ( pocetVakcin == priemernyDopyt) {
					naklady +=0;
				} else {
					naklady += prem*50;
				}
			}

			naklady /= pocetReplikacia;

			if (ziskNajVakcin > naklady) {
				pocetNajVakcin = j;
				ziskNajVakcin = naklady;
			}

			naklady=0;
		}

		System.out.println("Minimalne naklady budu " + ziskNajVakcin +" pri " + pocetNajVakcin + " vakcinach");
	}
}
