/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rade.dentistbookingsystem.controller;

import com.rade.dentistbookingsystem.repository.BranchRepo;
import com.rade.dentistbookingsystem.repository.ServiceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Masterkien
 */
@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private ServiceTypeRepo serviceTypeRepo;
    @Autowired
    private BranchRepo branchRepo;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("serviceTypeList", serviceTypeRepo.findAll());
        model.addAttribute("branchList", branchRepo.findAll());
        return "home";
    }
}
