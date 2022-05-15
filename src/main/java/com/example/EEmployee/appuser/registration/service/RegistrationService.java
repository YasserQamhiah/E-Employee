package com.example.EEmployee.appuser.registration.service;

import com.example.EEmployee.appuser.registration.collection.RegistrationRequest;
import com.example.EEmployee.appuser.collection.AppUser;
import com.example.EEmployee.appuser.collection.AppUserRole;
import com.example.EEmployee.appuser.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private AppUserService appUserService;
    public String register(RegistrationRequest request) {
        boolean isValid=emailValidator.test(request.getEmail());
        if(!isValid){
            return "Not Valid Name";
        }
       return appUserService.signUpUser(AppUser.builder().email(request.getEmail()).username(request.getUsername()).appUserRole(AppUserRole.ADMIN).password(request.getPassword()).build());

    }

}
