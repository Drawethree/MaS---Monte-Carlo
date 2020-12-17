package me.drawethree;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Priklad1 {


	public static void main(String[] args) {

		final double cenaNakup = 0.15;
		final double cenaVratenie = cenaNakup * 0.65;
		final double predajKazdych = 2.7;

		final int pocetRep = 1_000_000;

		TriangularRNG predajnaCena = new TriangularRNG(0.25,0.6,0.95);
		UniformContinuousRNG dlzkaPredaja = new UniformContinuousRNG(250.0,450.0);

		double total = 0;

		Map<Integer,Double> ziskyPriBalikoch = new LinkedHashMap<>();

		//1 - 50 balikov
		for (int i = 1; i < 50; i++) {

			double pocetKupenychNovin = i * 10;

			for (int j = 0; j < pocetRep; j++) {
				//ako dlho predava
				double casPredaja = dlzkaPredaja.sample();
				//za kolko v dany den predava noviny
				double cenaPredaja = predajnaCena.sample();
				//kolko novin v ten den preda
				double predaneNoviny = Math.min((int)(casPredaja/predajKazdych) + 1, pocetKupenychNovin);
				//kolko novin ostane
				double zvysneNoviny = pocetKupenychNovin - predaneNoviny;

				//predaneNoviny * cenaPredaja - celkovy obrat
				//zvysneNoviy * cenaVratenia - vratene peniaze z novin ktore nepredal
				//pocetKupenych * cenaNakup - nakupna cena
				total += (predaneNoviny * cenaPredaja) + (zvysneNoviny * cenaVratenie) - (pocetKupenychNovin * cenaNakup);
			}

			System.out.println("Kupenych balikov: " + i + " , denny zisk: " + (total/pocetRep));
			ziskyPriBalikoch.put(i,(total/pocetRep));
			total = 0;
		}

		double maxZisk = Collections.max(ziskyPriBalikoch.values());
		int pocetBalickov = 0;
		for (int i : ziskyPriBalikoch.keySet()) {
			if (ziskyPriBalikoch.get(i) == maxZisk) {
				pocetBalickov = i;
			}
		}

		System.out.println(String.format("Najviac sa oplati kupovat %d balickov, zisk je %f",pocetBalickov,maxZisk));
	}

}
