package com.example.EEmployee.appuser.registration.controller;

import com.example.EEmployee.appuser.registration.collection.RegistrationRequest;
import com.example.EEmployee.appuser.service.AppUserService;
import com.example.EEmployee.appuser.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {
@Autowired
    private RegistrationService registerService;
@Autowired
private AppUserService appUserService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registerService.register(request);
    }

    @PostMapping("/clear")
    public void clearData(){
        appUserService.clearApp();
    }
}
