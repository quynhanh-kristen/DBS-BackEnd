package com.rade.dentistbookingsystem.controller;


import com.rade.dentistbookingsystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("add")
    public String add(Model model){
        return "admin/doctor/addOrEdit";
    }

    @GetMapping("/list")
    public String viewDoctorProfile(Model model) {

        return "doctor";
    }


}
