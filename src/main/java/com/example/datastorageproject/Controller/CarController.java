package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCarList(Model model){
        List<Car> cars = carService.getAllCars();
        //TODO Возвращать список carDTO вместо Car
        model.addAttribute(cars);
        System.out.println(cars);
        return "cars";
    }
}
