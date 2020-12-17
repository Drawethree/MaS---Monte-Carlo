package me.drawethree;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Priklad5 {

	public static void main(String[] args) {

		UniformContinuousRNG genPravda1 = new UniformContinuousRNG();
		UniformContinuousRNG genPravda2 = new UniformContinuousRNG();
		UniformContinuousRNG genPravda3 = new UniformContinuousRNG();


		int pocetRovnakych2 = 0;
		int pocetRovnakych2Pravda = 0;

		int pocetRovnakych3 = 0;
		int pocetRovnakych3Pravda = 0;

		for (int i = 0; i < 10_000_000;i++) {
			// 0.0 - 0.8 - pravda
			// > 0.8 - loz
			double pravda1 = genPravda1.sample();
			double pravda2 = genPravda2.sample();
			double pravda3 = genPravda3.sample();

			if ((pravda1 <= 0.8 && pravda2 <= 0.8) || (pravda1 > 0.8 && pravda2 > 0.8)) {
				pocetRovnakych2 +=1;
				if (pravda1 <= 0.8 && pravda2 <= 0.8) {
					pocetRovnakych2Pravda +=1;
				}
			}

			if ((pravda1 <= 0.8 && pravda2 <= 0.8 && pravda3 <= 0.8) || (pravda1 > 0.8 && pravda2 > 0.8 && pravda3 > 0.8)) {
				pocetRovnakych3 +=1;
				if (pravda1 <= 0.8 && pravda2 <= 0.8 && pravda3 <= 0.8) {
					pocetRovnakych3Pravda +=1;
				}
			}
		}

		System.out.println("pravdepodobnost je " + (100*(double)pocetRovnakych2Pravda/pocetRovnakych2) + "%");
		System.out.println("pravdepodobnost je " + (100*(double)pocetRovnakych3Pravda/pocetRovnakych3) + "%");


		//Cast 2

		TriangularRNG genPravda1T = new TriangularRNG(30.0,80.0,100.0);
		TriangularRNG genPravda2T = new TriangularRNG(30.0,80.0,100.0);
		TriangularRNG genPravda3T = new TriangularRNG(30.0,80.0,100.0);

		pocetRovnakych2 = 0;
		pocetRovnakych2Pravda = 0;

		pocetRovnakych3 = 0;
		pocetRovnakych3Pravda = 0;

		for (int i = 0; i < 10_000_000;i++) {
			// 0.0 - 0.8 - pravda
			// > 0.8 - loz
			double pravda1 = genPravda1T.sample();
			double pravda2 = genPravda2T.sample();
			double pravda3 = genPravda3T.sample();

			if ((pravda1 <= 80 && pravda2 <= 80) || (pravda1 > 80 && pravda2 > 80)) {
				pocetRovnakych2 +=1;
				if (pravda1 <= 80 && pravda2 <= 80) {
					pocetRovnakych2Pravda +=1;
				}
			}

			if ((pravda1 <= 80 && pravda2 <= 80 && pravda3 <= 80) || (pravda1 > 80 && pravda2 > 80 && pravda3 > 80)) {
				pocetRovnakych3 +=1;
				if (pravda1 <= 80 && pravda2 <= 80 && pravda3 <= 80) {
					pocetRovnakych3Pravda +=1;
				}
			}
		}

		System.out.println("pravdepodobnost je " + (100*(double)pocetRovnakych2Pravda/pocetRovnakych2) + "%");
		System.out.println("pravdepodobnost je " + (100*(double)pocetRovnakych3Pravda/pocetRovnakych3) + "%");

	}
}
