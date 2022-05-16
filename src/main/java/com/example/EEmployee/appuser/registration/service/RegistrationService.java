package com.example.EEmployee.appuser.registration.service;

import com.example.EEmployee.appuser.registration.collection.RegistrationRequest;
import com.example.EEmployee.appuser.collection.AppUser;
import com.example.EEmployee.appuser.collection.AppUserRole;
import com.example.EEmployee.appuser.service.AppUserService;
import com.example.EEmployee.appuser.token.ConfirmationToken;
import com.example.EEmployee.appuser.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) {
        boolean isValid=emailValidator.test(request.getEmail());
        if(!isValid){
            return "Not Valid Name";
        }
       return appUserService.signUpUser(AppUser.builder().email(request.getEmail()).username(request.getUsername()).appUserRole(AppUserRole.ADMIN).password(request.getPassword()).build());

    }
    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken= confirmationTokenService.getToken(token).
                orElseThrow(() ->
                new IllegalStateException("Token not found"));
        if(confirmationToken.getConfirmedAt()!=null){
            throw new IllegalStateException("email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenService.updateToken(confirmationToken);
        appUserService.enableUser(confirmationToken.getAppUser());
        return "DONE";

    }

}
