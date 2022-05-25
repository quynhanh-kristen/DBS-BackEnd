package com.rade.dentistbookingsystem.controller;

import com.rade.dentistbookingsystem.repository.ServiceRepo;
import com.rade.dentistbookingsystem.repository.ServiceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("service-type")
public class ServiceController {
    @Autowired
    private ServiceTypeRepo serviceTypeRepo;
    @Autowired
    private ServiceRepo serviceRepo;

    @GetMapping("{name}")
    public String list(Model model, @PathVariable String name){
        model.addAttribute("serviceList", serviceRepo.findByServiceType(serviceTypeRepo.findByName(name)));
        return "guest/service-list";
    }
}
