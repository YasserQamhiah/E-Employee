package com.example.EEmployee.collection;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "EmployeeCollection")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String employeeId;
    @NotNull(message = "YOU CAN NOT LEAVE FIRST NAME EMPTY")
    private String fname;
    @NotNull(message = "YOU CAN NOT LEAVE LAST NAME EMPTY")
    private String lname;

    private String email;
    private int salary;
    private String phone;
    private String roll;
    private String job;
    private String birthDate;
    private String hireDate;
}


