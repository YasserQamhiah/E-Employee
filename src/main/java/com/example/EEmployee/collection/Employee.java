package com.example.EEmployee.collection;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    private String employeeId;
    @NonNull
    private String fname;
    @NonNull
    private String lname;

    private String email;

    private String phone;

    private String birthDate;
    private String hireDate;
}


