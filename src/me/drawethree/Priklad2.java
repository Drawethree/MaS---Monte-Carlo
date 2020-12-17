package me.drawethree;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformDiscreteRNG;

public class Priklad2 {


	public static void main(String[] args) {

		int maxA = 70;
		int maxB = 90;

		double predajnaCenaA = 3.0;
		double predajnaCenaB = 2.0;

		int pocetRep = 1_000_000;

		TriangularRNG genNakladyA = new TriangularRNG(1.0,1.75,2.5);
		TriangularRNG genNakladyB = new TriangularRNG(0.7,1.20,1.7);

		UniformDiscreteRNG genDopytA = new UniformDiscreteRNG(40,80);
		UniformDiscreteRNG genDopytB = new UniformDiscreteRNG(66,155);

		double totalA = 0;
		double totalB = 0;

		for (int i = 0; i < pocetRep; i++) {
			double nakladA = genNakladyA.sample();
			double nakladB = genNakladyB.sample();

			int predaneA = Math.min(genDopytA.sample(), maxA);
			int predaneB = Math.min(genDopytB.sample(), maxB);

			double hvA = (predaneA * predajnaCenaA) - (maxA * nakladA);
			double hvB = (predaneB * predajnaCenaB) - (maxB * nakladB);

			totalA += hvA;
			totalB += hvB;
		}

		System.out.println("Celkovo A: " + totalA/pocetRep + 0.0);
		System.out.println("Celkovo B: " + totalB/pocetRep + 0.0);

	}
}
