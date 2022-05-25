package com.rade.dentistbookingsystem.controller;

import com.rade.dentistbookingsystem.domain.Branch;
import com.rade.dentistbookingsystem.domain.District;
import com.rade.dentistbookingsystem.domain.Province;
import com.rade.dentistbookingsystem.model.BranchDTO;
import com.rade.dentistbookingsystem.repository.BranchRepo;
import com.rade.dentistbookingsystem.repository.DistrictRepo;
import com.rade.dentistbookingsystem.repository.ProvinceRepo;
import com.rade.dentistbookingsystem.services.impl.BranchServiceImpl;
import com.rade.dentistbookingsystem.services.impl.DistrictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/branch")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class BranchController {
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private ProvinceRepo provinceRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private BranchServiceImpl branchServiceImpl;
    @Autowired
    private DistrictServiceImpl districtServiceImpl;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor((true));
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ModelAttribute("branchDTO")
    public BranchDTO branchDTO() {
        return new BranchDTO();
    }

    @ModelAttribute("districtList")
    public List<District> districtList() {
        return districtRepo.findAll();
    }
    @ModelAttribute("provinceList")
    public List<Province> provinceList() {
        return provinceRepo.findAll();
    }


    @GetMapping("")
    public String listPage1(Model model){
        model.addAttribute("branchList", branchRepo.findAll(PageRequest.of(0, 12)));
        return "admin/branch-list";
    }

    @GetMapping("{i}")
    public String list(Model model, @PathVariable int i){
        model.addAttribute("branchList", branchRepo.findAll(PageRequest.of(i, 12)));
        return "admin/branch-list";
    }

    @GetMapping("add")
    public String showBranchForm(Model model){
        return "admin/branch-form";
    }

    @PostMapping("add")
    public String insert(Model model,
                         @Valid @ModelAttribute("branchDTO") BranchDTO branchDTO,
                         @RequestParam MultipartFile photo,
                         BindingResult bindingResult) throws Exception{

        boolean valid = true;

        //name
        String name = branchDTO.getName();
        if(!(name != null && !name.isBlank())){
            bindingResult.rejectValue("name", "error.name", "Branch's name is required");
            valid = false;
        }
        else if(name.length()<8 || name.length()>30){
            bindingResult.rejectValue("name", "error.name", "Branch's name's length from 8 to 30");
            valid = false;
        }
        if(branchServiceImpl.findByName(name) != null){
            bindingResult.rejectValue("name", "error.name", "Branch's name is existed");
            valid = false;
        }
        //district_id
        int district_id = branchDTO.getDistrict_id();
        if(district_id==0){
            bindingResult.rejectValue("district_id", "error.district_id", "District is required");
            valid = false;
        }
        if(districtRepo.findById(district_id) == null){
            bindingResult.rejectValue("district_id", "error.district_id", "District isn't existed");
            valid = false;
        }
        //url
        if(branchDTO.getUrl() == null){
            if(photo.getOriginalFilename() == ""){
                model.addAttribute("urlError", "Branch's image is required");
                valid = false;
            }
            else {
                if (!(photo.getOriginalFilename().endsWith(".jpg") || photo.getOriginalFilename().endsWith(".png"))){
                    model.addAttribute("urlError", "Branch's image must be JPG or PNG file");
                    valid = false;
                }
                else {
                    if (branchRepo.findByUrl(photo.getOriginalFilename()) != null) {
                        model.addAttribute("urlError", "Branch's image's url is existed");
                        valid = false;
                    }
                    else{
                        Path path = Paths.get("src/main/resources/static/image/branch");
                        byte[] bytes = photo.getBytes();
                        InputStream inputStream = photo.getInputStream();
                        Path filePath = path.resolve(photo.getOriginalFilename());
                        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                        branchDTO.setUrl(photo.getOriginalFilename());
                    }
                }
            }
        }
        else{
            if(photo.getOriginalFilename() != ""){
                if (!(photo.getOriginalFilename().endsWith(".jpg") || photo.getOriginalFilename().endsWith(".png"))){
                    model.addAttribute("urlError", "Branch's image must be JPG or PNG file");
                    valid = false;
                }
                else {
                    if (branchRepo.findByUrl(photo.getOriginalFilename()) != null) {
                        if(photo.getOriginalFilename() != branchDTO.getUrl()){
                            model.addAttribute("urlError", "Branch's image's url is existed");
                            valid = false;
                        }
                    }
                    else{
                        File file = new File("src/main/resources/static/image/branch/"+branchDTO.getUrl());
                        file.delete();
                        Path path = Paths.get("src/main/resources/static/image/branch");
                        byte[] bytes = photo.getBytes();
                        InputStream inputStream = photo.getInputStream();
                        Path filePath = path.resolve(photo.getOriginalFilename());
                        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                        branchDTO.setUrl(photo.getOriginalFilename());
                    }
                }
            }
        }

        //open_time
        String open_time = branchDTO.getOpen_time();
        if (!(open_time != null && !open_time.isBlank())
        ){
            bindingResult.rejectValue("open_time", "error.open_time", "Branch's open time is required");
            valid = false;
        }
        //close_time
        String close_time = branchDTO.getClose_time();
        if (!(close_time != null && !close_time.isBlank())){
            bindingResult.rejectValue("close_time", "error.close_time", "Branch's close time is required");
            valid = false;
        }

        if(branchDTO.getStatus() == null){
            bindingResult.rejectValue("status", "error.status", "Branch's status is required");
            valid = false;
        }

        if(!valid){
            return "admin/branch-form";
        }

        else{
            branchServiceImpl.save(branchDTO);
            return "redirect:";
        }
    }
}
