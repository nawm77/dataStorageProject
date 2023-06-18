package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.CarDTO;
import com.example.datastorageproject.Mapper.CarMapper;
import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> getAllCars(){
        return carRepository.findAll()
                .stream()
                .map(CarMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
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
        carFromRepo.setId(id);
        carRepository.save(carFromRepo);
    }

    public void deleteCarById(Integer id){
        carRepository.deleteById(id);
    }

    public List<CarDTO> getAvailableCars(){
        return carRepository.getAvailableCars()
                .stream()
                .map(e -> new CarDTO(
                        Integer.parseInt(String.valueOf(e[0])),
                        (String) e[1],
                        (String) e[2],
                        Integer.parseInt(String.valueOf(e[3])),
                        (String) e[4],
                        (String) e[5],
                        (String) e[6],
                        Integer.parseInt(String.valueOf(e[7])),
                        Boolean.valueOf(String.valueOf(e[8])),
                        Boolean.valueOf(String.valueOf(e[9])),
                        Boolean.valueOf(String.valueOf(e[10]))
                )).collect(Collectors.toList());
    }
}
