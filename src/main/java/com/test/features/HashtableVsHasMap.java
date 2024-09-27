package com.test.features;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtableVsHasMap {
	public static void main(String[] args) {
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, null);
		hashtable.put(2, "two");
		hashtable.put(3, "three");
		hashtable.put(4, "Four");


		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(null, "one");
		hashMap.put(2, "two");
		hashMap.put(3, "three");
		hashMap.put(4, "Four");


		System.out.println("DONE");

	}
}
