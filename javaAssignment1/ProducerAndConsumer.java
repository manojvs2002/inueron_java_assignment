package javaAssignment1;
//Write a Java program that implements a producer-consumer model using
//multithreading. The program should have a producer thread that generates random
//numbers and adds them to a queue, and a consumer thread that reads numbers
//from the queue and calculates their sum. The program should use synchronization to
//ensure that the queue is accessed by only one thread at a time

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class ProducerAndConsumer {
	
	static Scanner scan = new Scanner(System.in);
	
	public static final int maxcap=3;
	public static final int maxnum=5;
	
	Queue<Integer> queue = new LinkedList<>();
	private Random random =new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProducerAndConsumer obj =new ProducerAndConsumer();
		obj.start();
	}

	public void start() {
		// TODO Auto-generated method stub
		
		Thread produce = new Thread(new producer());
		Thread consume = new Thread(new consumer());
		
		produce.start();
		consume.start();
		
	}

	class producer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<maxnum;i++) {
				try {
					produce();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public void produce() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized(queue) {
			while(queue.size()==maxcap) {
				queue.wait();
			}
			int number=random.nextInt(100);
			queue.add(number);
			System.out.println("produced"+number);
			
			queue.notifyAll();
		}
	}

	
	class consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int sum=0;
			
			for(int i=0;i<maxnum;i++) {
				try {
					sum+=consume();
					
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public int consume() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (queue) {
			while(queue.isEmpty()) {
				queue.wait();
			}
			int number = queue.poll();
			System.out.println("consumer "+number);
			
			queue.notifyAll();
			
			return number;
		}
		
	}

	
}
