package com.example.datastorageproject.Service;

import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    public Car getById(Integer id){
        return carRepository.getById(id);
    }
    public void saveCar(Car car){
        carRepository.save(car);
    }
    public void updateCar(Integer id, Car car){
        Car carFromRepo = carRepository.getById(id);
        carFromRepo = car;
        carRepository.deleteById(id);
        carRepository.save(carFromRepo);
    }

    public void deleteCarById(Integer id){
        carRepository.deleteById(id);
    }
}
