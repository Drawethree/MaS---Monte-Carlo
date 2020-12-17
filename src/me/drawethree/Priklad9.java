package me.drawethree;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;
import OSPRNG.UniformDiscreteRNG;

public class Priklad9 {

	public static void main(String[] args) {

		TriangularRNG genRedukcieCeny = new TriangularRNG(1.0,4.0,11.0);
		UniformContinuousRNG genZvysovaniaNaplnenosti = new UniformContinuousRNG(5.0,14.0);

		double aktualnaCenaLetenky = 500;
		int pocetDni = 7;
		int pocetReplikacii = 100000;
		double naplnenosLetu = 27;
		double[] cena = new double [7];
		boolean zmenena = false;

		//1 replikacia = 7 dni
		for (int i = 0; i < pocetReplikacii; i++) {
			//vsetkych 7 dni
			for (int j = 0; j < pocetDni; j++) {
				//posles ceny v den j
				double poklesCeny = genRedukcieCeny.sample();
				//narast pasazierov v den j
				double narastPasazierov = genZvysovaniaNaplnenosti.sample();

				//zvysime naplnenost letu
				naplnenosLetu += narastPasazierov;

				if (naplnenosLetu >= 75 && !zmenena) {
					aktualnaCenaLetenky += (aktualnaCenaLetenky * 0.3);
					zmenena = true;
				} else if (naplnenosLetu < 75) {
					aktualnaCenaLetenky -= (aktualnaCenaLetenky * poklesCeny / 100.0);
				}
				cena[j] += aktualnaCenaLetenky;
			}
			zmenena = false;
			aktualnaCenaLetenky = 500;
			naplnenosLetu = 27;
		}

		for (int i = 0; i < pocetDni; i++) {
			System.out.println("Priemerna cena v " + (i + 1) + " den bola " + cena[i] / pocetReplikacii);
		}

	}
}
