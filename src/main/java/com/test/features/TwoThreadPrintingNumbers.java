package com.test.features;

public class TwoThreadPrintingNumbers {

	synchronized public void printOdd() {
		for (int i = 1; i < 50; i = i + 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(i);

			notify();
		}
	}

	synchronized private void printEven() {
		for (int i = 0; i < 50; i = i + 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(i);

			notify();
		}
	}
	public static void main(String[] args) {
		final var twoThreadPrintingNumbers = new TwoThreadPrintingNumbers();
		Runnable printOdd = twoThreadPrintingNumbers::printOdd;
		Runnable printEven = twoThreadPrintingNumbers::printEven;

		Thread thread1 = new Thread(printOdd);
		Thread thread2 = new Thread(printEven);

		thread1.start();
		thread2.start();
	}


}
