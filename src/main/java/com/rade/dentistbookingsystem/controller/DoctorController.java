package com.rade.dentistbookingsystem.controller;


import com.rade.dentistbookingsystem.domain.Doctor;
import com.rade.dentistbookingsystem.domain.Role;
import com.rade.dentistbookingsystem.services.DoctorService;
import com.rade.dentistbookingsystem.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.print.Doc;
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
 ///@RolesAllowed({"ROLE_ADMIN"})
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
