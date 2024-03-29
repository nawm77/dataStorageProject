package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class  CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCarList(Model model){
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @GetMapping("/cars/available")
    public String getAvailableCars(Model model){
        model.addAttribute("cars", carService.getAvailableCars());
        return "cars";
    }
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping("/cars/update/{id}")
    public String updateCarInfo(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getById(id));
        return "editCar";
    }
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping("/cars/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Car car, Errors errors){
        if(errors.hasErrors()){
            return "editCar";
        }
        carService.updateCar(id, car);
        return "redirect:/cars";
    }
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping("/cars/new")
    public String newCarForm(Model model){
        model.addAttribute("car", new Car());
        return "newCarForm";
    }
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping("/cars/add")
    public String addNewCar(@Valid Car car, Errors errors){
        if(errors.hasErrors()){
            return "newCarForm";
        }
        carService.saveCar(car);
        return "redirect:/cars";
    }
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping("/cars/delete/{id}")
    public String deleteCarById(@PathVariable("id") Integer id){
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("/cars/status")
    public String getNotRepairedCars(Model model){
        model.addAttribute("cars", carService.getAllCarsWithServiceInfo());
        return "carsWithInfoService";
    }
}
