package com.rade.dentistbookingsystem.controller;


import com.rade.dentistbookingsystem.domain.Doctor;
import com.rade.dentistbookingsystem.services.DoctorService;
import com.rade.dentistbookingsystem.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("admin/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    RoleService roleService;


    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Doctor> viewDoctorList() {

        return doctorService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Doctor> createDoctor(@RequestBody @Valid Doctor doctor ){
        Doctor saveDoctor = doctorService.save(doctor);
        URI doctorURI = URI.create("/doctor/create/" + doctor.getId());
        return ResponseEntity.created(doctorURI).body(saveDoctor);
    }




}
