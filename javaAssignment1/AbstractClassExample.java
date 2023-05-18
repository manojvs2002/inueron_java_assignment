package javaAssignment1;

abstract class Vehicle{
	private String brand;
	
	public Vehicle(String brand) {
		this.brand=brand;
	}
	
	public abstract void start();
	
	public void stop() {
		System.out.println("Vehicle stopped");
	}
	
	public String getBrand() {
		return brand;
	}
}
	 class Car extends Vehicle{

		public Car(String brand) {
			super(brand);
			
		}

		@Override
		public void start() {
			System.out.println("car started");
			
		}
		 
	 }
	 
	 public class AbstractClassExample{
		 public static void main(String[] args) {
			 Car car = new Car("toyata");
			 System.out.println("Brand "+car.getBrand());
			  car.start();
			  car.stop();
			 
		 }
	 }
	

