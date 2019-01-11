package main;

import java.util.Random;

public class RandomSingleton {
	
	private static Random random;
	
	public static Random getInstance() {
		if(random==null) {
			random = new Random();
		}
		return random;
	}

}
