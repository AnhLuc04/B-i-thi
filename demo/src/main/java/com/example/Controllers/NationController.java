package com.example.Controllers;


import com.example.Model.Nation;
import com.example.Service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class NationController {
    @Autowired
    private NationService nationService;
    @GetMapping("nation")
    public ModelAndView listNation(){
        Iterable<Nation>nations = nationService.findAll();
        ModelAndView modelAndView = new ModelAndView("nation/ListNation");
        modelAndView.addObject("nation",nations);
        return modelAndView;
    }
    @GetMapping("/create-nation")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("nation/create");
        modelAndView.addObject("nation", new Nation());
        return modelAndView;
    }
    @PostMapping("/create-nation")
    public ModelAndView saveNation(@Validated @ModelAttribute("nation") Nation nation, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("nation/create");
            modelAndView.addObject("message", "Cú pháp sai bạn nhé");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("nation/create");
        nationService.save(nation);
        modelAndView.addObject("nation", new Nation());
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }

    @GetMapping("/edit-nation/{ID}")
    public ModelAndView updateNation(@PathVariable Long ID) {
        Optional<Nation> nation = nationService.findById(ID);
        if(nation != null) {
            ModelAndView modelAndView = new ModelAndView("nation/edit");
            modelAndView.addObject("nation",nation);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-nation")
    public ModelAndView updateNation(@ModelAttribute("nation") Nation nation){
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/ListNation");
        List<Nation> nations= nationService.findAll();;
        modelAndView.addObject("nation", nations);
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }
    @GetMapping("/delete-nation/{ID}")
    public ModelAndView showDeleteForm(@PathVariable Long ID){
       nationService.remove(ID);
        List<Nation> nation= nationService.findAll();
        if(nation != null) {
            ModelAndView modelAndView = new ModelAndView("nation/ListNation");
            modelAndView.addObject("nation", nation);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
