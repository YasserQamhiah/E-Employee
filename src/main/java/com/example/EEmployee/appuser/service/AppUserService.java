package com.example.EEmployee.appuser.service;

import com.example.EEmployee.appuser.collection.AppUser;
import com.example.EEmployee.appuser.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String ERROR_MESSAGE_MSG ="THERE IS NO USER WITH THAT %s EMAIL";
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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
        usersRepository.save(appUser);
        return "";
    }
    public void clearApp(){
        usersRepository.deleteAll();
    }
}
