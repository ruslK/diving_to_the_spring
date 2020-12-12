package com.ormconfig;

import com.ormconfig.entity.Car;
import com.ormconfig.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrmconfigApplication {

	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrmconfigApplication.class, args);
	}

	@PostConstruct
	public void dataInit() {
		List<Car> cars = new ArrayList<>();
		Car c1 = new Car("BMW", "M5");
		Car c2 = new Car("KIA", "X6");
		Car c3 = new Car("Honda", "I8");

		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(new Car("Tesla", "X"));
//		carRepository.save(c1);
//		carRepository.save(c2);
//		carRepository.save(c3);
		carRepository.saveAll(cars);

		System.out.println("Testing");
		System.out.println(carRepository.findAll().size());
		System.out.println(carRepository.findById(1L).get().getMake());
		System.out.println(carRepository.findById(1L).get().getModel());
		System.out.println(carRepository.findById(1L).get().getId());
		System.out.println("Testing");
	}
}
