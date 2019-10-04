package com.examples.java.concurrency;

public class SynchronizationEx {
	
	public static class Counter implements Runnable {

		int counter = 0;
		
		@Override
		public void run() {
			System.out.format("%s - started %n", Thread.currentThread().getName());
//			counter = 0;
			
			
			
			synchronized (this) {
				increment();	
				print(); // 1
				decrement();
				print(); // 0
				increment();
				increment();
				print(); // 2				
				System.out.format("%s - Counter test1 %n", Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.format("%s - Counter test2 %n", Thread.currentThread().getName());				
			}
					

		}
		
		public void process () {
			
			increment();
			decrement();
			System.out.println("Data processing...");
		}
		
		public void increment() {
			counter = counter + 1;
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
		public void decrement() {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}			
			counter = counter - 1;
		}
		
		public void print() {
			System.out.format("%s - counter:%d %n", Thread.currentThread().getName(), counter);
		}
		
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		Thread counter1 = new Thread(counter);
		counter1.start();
		
		Thread counter2 = new Thread(counter);
		counter2.start();		
		
	}

}
