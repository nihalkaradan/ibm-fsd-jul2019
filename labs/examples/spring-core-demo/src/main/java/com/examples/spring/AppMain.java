package com.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args)
	{
//		Car bmw = new Car();
//		bmw.setColor("White");
//		bmw.setManufacturer("BMW");
//		bmw.setModel("XA");
		
//		Engine vti = new Engine();
//		vti.setCapacity(2000);
//		vti.setNoOfCynclinders(4);
//		vti.setTorque(10);
		
//		Engine vtix = new Engine();
//		vtix.setCapacity(4000);
//		vtix.setNoOfCynclinders(4);
//		vtix.setTorque(10);
//		
//		bmw.setEngine(vtix);

		
		
//		System.out.println("Manufacturer: " + bmw.getManufacturer());
//		System.out.println("Color: " + bmw.getColor());
//		System.out.println("Capacity: " + bmw.getEngine().getCapacity());
		
//		// Instantiate IoC container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		Car bmw = (Car) context.getBean("bmw");
		
		System.out.println("Manufacturer: " + bmw.getManufacturer());
		System.out.println("Color: " + bmw.getColor());
		System.out.println("Capacity: " + bmw.getEngine().getCapacity());		
		
	}
}