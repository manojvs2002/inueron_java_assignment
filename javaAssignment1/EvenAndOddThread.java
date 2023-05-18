package javaAssignment1;

import java.util.Scanner;

public class EvenAndOddThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread even = new Thread(new EvenPrinter());
		Thread odd = new Thread(new OddPrinter());
		
		even.start();
		odd.start();
	}

}

class EvenPrinter implements Runnable{

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=10;i=i+2) {
		System.out.println("even nos are"+i);	
		}
	}
	
}

class OddPrinter implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i=i+2) {
			System.out.println("odd nos are"+i);
		}
	}
	
}
