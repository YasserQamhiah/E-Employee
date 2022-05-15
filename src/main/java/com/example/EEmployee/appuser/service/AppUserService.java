package com.example.EEmployee.appuser.service;

import com.example.EEmployee.appuser.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String ERROR_MESSAGE_MSG ="THERE IS NO USER WITH THAT %s EMAIL";
    @Autowired
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(ERROR_MESSAGE_MSG,email)));
    }
}
