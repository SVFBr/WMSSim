package com.ssi.schaefer.yanbal.util.tools;

import java.util.Random;

public class Tools {

	static private Random rnd = new Random();

	public static int getRandRotate(int min, int max) {
		// return rnd.nextInt(max - min + 1) + min;
		return rnd.nextInt(max - min) + min;
		// return rnd.nextInt(max - min) + 1 + min;
		// return rnd.nextInt(max - min - 1) + 1 + min;
	}

	public static boolean getRandBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}

	public static String getRandBoxTypeC() {
		String[] boxTypes = new String[] { "C1", "C2", "C3", "C4", "A1", "A2" };
		return boxTypes[rnd.nextInt(boxTypes.length)];
		// return boxTypes[rand.nextInt(boxTypes.length)];
	}

	public static String getRandBoxTypeN() {
		String[] boxTypes = new String[] { "131", "132", "133", "134", "135", "136" };
		return boxTypes[rnd.nextInt(boxTypes.length)];
		// return boxTypes[rand.nextInt(boxTypes.length)];
	}

}
