package org.example.customizephonevalidate.controller;


import org.example.customizephonevalidate.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/index2";
    }

    @PostMapping("/phone1")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber,
                                   BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index2";
        } else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }
}