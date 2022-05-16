package com.example.EEmployee.appuser.service;

import com.example.EEmployee.appuser.collection.AppUser;
import com.example.EEmployee.appuser.repository.UsersRepository;
import com.example.EEmployee.appuser.token.ConfirmationToken;
import com.example.EEmployee.appuser.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service

public class AppUserService implements UserDetailsService {
    private final static String ERROR_MESSAGE_MSG ="THERE IS NO USER WITH THAT %s EMAIL";
    @Autowired
    private  UsersRepository usersRepository;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(ERROR_MESSAGE_MSG,email)));
    }
    public String signUpUser(AppUser appUser){
        boolean userExist=usersRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("Email Already Taken");
        }
        String encodedPassword=bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        String token= UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=ConfirmationToken.builder()
                .token(token)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusMinutes(15))
                .appUser(appUser)
                .build();
        usersRepository.save(appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    public void clearApp(){
        usersRepository.deleteAll();
    }


    public String enableUser(AppUser user){
        user.setEnabled(true);
        usersRepository.save(user);
        return "DONE";
    }
}
