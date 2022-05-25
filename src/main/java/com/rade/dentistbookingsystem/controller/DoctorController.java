package com.rade.dentistbookingsystem.controller;

import com.rade.dentistbookingsystem.domain.Doctor;
import com.rade.dentistbookingsystem.model.DoctorDTO;
import com.rade.dentistbookingsystem.services.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@RequestMapping("admin/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("add")
    public String addDoctor(Model model) {
        model.addAttribute("doctor", new DoctorDTO());
        return "admin/doctor/addOredit";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editDoctor(Model model, @PathVariable("doctor_id") int id) {
        Optional<Doctor> optional = doctorService.findById(id);
        if (optional.isPresent()) {
            DoctorDTO doctorDTO = new DoctorDTO();
            Doctor doctor = optional.get();
            BeanUtils.copyProperties(doctor, doctorDTO);
            model.addAttribute("doctor", doctorDTO);
            return new ModelAndView("admin/doctor/addOredit");
        }
        model.addAttribute("Message", "doctor does not exsit");
        return new ModelAndView("admin/doctor");
    }

    @GetMapping("delete")
    public String deleteDoctor() {

        return "redirect:admin/doctor";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("doctor") DoctorDTO doctorDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:admin/doctor", model);


        }
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(doctorDTO, doctor);
        doctorService.save(doctor);
        model.addAttribute("Message", "Add successfully");

        return new ModelAndView("redirect:admin/doctor", model);

    }
}
