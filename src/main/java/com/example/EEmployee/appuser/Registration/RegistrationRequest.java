package com.example.EEmployee.appuser.Registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;





}
