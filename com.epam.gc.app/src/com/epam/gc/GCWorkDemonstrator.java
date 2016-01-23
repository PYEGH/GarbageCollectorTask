package com.epam.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GCWorkDemonstrator {

	private static Random rand = new Random();
	private static final int MAX_OBJECTS_COUNT = 1000;
	private static final int OBJECT_SIZE = 1024;
	private static final int ADD_PROCESS_TIME = 1000;
	private static final long WORK_TIME = 1000 * 60 * 5; // 5 minutes

	/**
	 * Method create objects during 5 minutes.
	 */
	public void run() {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + WORK_TIME;
		while (System.currentTimeMillis() < endTime) {
			makeObjects();
		}
	}

	/**
	 * Method creates list with arrays. On every iteration array is created and
	 * set to list. Number of iteration is generated randomly.
	 */
	private void makeObjects() {

		List<byte[]> objectList = new ArrayList<byte[]>();
		final int rendomlyGeneratedNumber = rand.nextInt(MAX_OBJECTS_COUNT);
		System.out.println(rendomlyGeneratedNumber);
		for (int i = 0; i < rendomlyGeneratedNumber; i++) {
			objectList.add(new byte[OBJECT_SIZE]);
		}

		try {
			objectList = null;
			Thread.sleep(ADD_PROCESS_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
