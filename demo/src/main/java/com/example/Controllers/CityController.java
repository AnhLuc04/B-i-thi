package com.example.Controllers;

import com.example.Model.City;
import com.example.Model.Nation;
import com.example.Service.CityService;
import com.example.Service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;

    @ModelAttribute("nation")
    public Iterable<Nation> allProvinces() {
        return nationService.findAll();
    }

    @GetMapping("city")
    public ModelAndView showList( Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("city/ListCity");
        Page<City> citys = cityService.findAll(pageInfo);
        modelAndView.addObject("city", citys);
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView saveCity(@Validated @ModelAttribute("city")City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("city/create");
            modelAndView.addObject("message", "Cú pháp sai bạn nhé");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("city/create");
        cityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }
    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @GetMapping("/edit-city/{ID}")
    public ModelAndView updateCity(@PathVariable Long ID) {
        Optional<City> city = cityService.findById(ID);
        if(city!= null) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city",city);
            return modelAndView;
      }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
        @PostMapping("/edit-city")
    public ModelAndView updateCity(@Validated @ModelAttribute("city") City city,BindingResult bindingResult){
            if (bindingResult.hasFieldErrors()) {
                ModelAndView modelAndView = new ModelAndView("city/edit");
                modelAndView.addObject("message", "Cú pháp sai bạn nhé");
                return modelAndView;
            }
            cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        Iterable<City> citys= cityService.findAll();;
        modelAndView.addObject("city", citys);
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }


    @GetMapping("/delete-city/{ID}")
    public ModelAndView showDeleteForm(@PathVariable Long ID,Pageable pageable){
        cityService.delete(ID);
        Page<City>city= cityService.findAll(pageable);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("city/ListCity");
            modelAndView.addObject("city", city);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @GetMapping("/city/{ID}")
    public ModelAndView showLists(@PathVariable Long ID) {
        ModelAndView modelAndView= new ModelAndView("city/List-detail");
        Optional<City> city = cityService.findById(ID);
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }
}
