package com.example.EEmployee.appuser.registration.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RegistrationRequest {
    private final String password;
    private final String email;
    private final String username;





}
