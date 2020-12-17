package me.drawethree;

import OSPRNG.TriangularRNG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Priklad6 {

	public static void main(String[] args) {

		TriangularRNG genFastCasy = new TriangularRNG(40.0,50.0,75.0);
		TriangularRNG genFuriousCasy = new TriangularRNG(40.0,52.0,80.0);

		List<CarAndTime> cars;

		int total = 0;
		int spravne = 0;

		for	(int i = 0; i < 10_000_000; i++) {
			cars = new ArrayList<>();

			for (int j = 0; j < 5; j++) {
				double casFuri = genFuriousCasy.sample();
				double casFast = genFastCasy.sample();

				CarAndTime carFast = new CarAndTime(CarType.FAST,casFast);
				CarAndTime carFuri = new CarAndTime(CarType.FURIOUS,casFuri);

				cars.add(carFast);
				cars.add(carFuri);
			}

			Collections.sort(cars, (o1, o2) -> {
				if (o1.getCas() > o2.getCas()) {
					return 1;
				} else if (o1.getCas() == o2.getCas()) {
					return 0;
				} else {
					return -1;
				}
			});

			total +=1;
			if (cars.get(0).getType() == CarType.FAST && cars.get(1).getType() == CarType.FAST) {
				spravne+=1;
			}

		}

		System.out.println("pravdepodobnost: " + (spravne/(total + 0.0)));

	}

	private static class CarAndTime {

		private final CarType type;

		@Override
		public String toString() {
			return "CarAndTime{" +
					"type=" + type +
					", cas=" + cas +
					'}';
		}

		private final double cas;

		public CarAndTime(CarType type, double cas) {

			this.type = type;
			this.cas = cas;
		}

		public CarType getType() {
			return type;
		}

		public double getCas() {
			return cas;
		}
	}
}
