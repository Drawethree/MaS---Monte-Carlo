package me.drawethree;

import OSPRNG.UniformContinuousRNG;

public class Priklad3 {
	public static void main(String[] args) {

		UniformContinuousRNG genX = new UniformContinuousRNG(0.0,1.0);
		UniformContinuousRNG genY = new UniformContinuousRNG(0.0,1.0);

		int pocetRep = 1_000_000;

		double polomer = 0.5;

		int total = 0;



		for (int i = 0;i<pocetRep;i++) {
			double x = genX.sample();
			double y = genY.sample();

			if ((Math.pow(x - 0.5,2) + Math.pow(y - 0.5,2)) <= Math.pow(polomer,2)) {
				total +=1;
			}
		}

		double pi = (total / (pocetRep + 0.0) ) / Math.pow(polomer,2);
		System.out.println("odhad pi : " + pi);

		pocetRep = Integer.MAX_VALUE;
		total = 0;
		for (int i = 0;i<pocetRep;i++) {
			double x = genX.sample();
			double y = genY.sample();

			if ((Math.pow(x - 0.5,2) + Math.pow(y - 0.5,2)) <= Math.pow(polomer,2)) {
				total +=1;
			}

			if (0.000001 > Math.PI - ((total / (pocetRep + 0.0) ) / Math.pow(polomer,2))) {
				System.out.println("Bolo treba " + i + " replikacii.");
				break;
			}
		}

		pi = (total / (pocetRep + 0.0) ) / Math.pow(polomer,2);
		System.out.println("odhad pi : " + pi);

	}
}
