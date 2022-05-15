package com.example.EEmployee.service;

import com.example.EEmployee.repository.EmployeeRepository;
import com.example.EEmployee.collection.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public void addEmployee(Employee employee) {
        employee.setEmployeeId(sequenceGeneratorService.generateSequence(employee.SEQUENCE_NAME));

        employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployeeById(String id) throws Exception {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new Exception("There's NO Employee with that id");
        }
        return employee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList=employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }

    @Override
    public Employee deleteEmployee(String id) throws Exception {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new Exception("There's NO Employee with that id");
        }
        employeeRepository.deleteById(id);
        return employee.get();
    }


    public Employee findByEmail(String email){
        Query query=new Query().addCriteria(Criteria.where("email").is(email));
        return  mongoTemplate.find(query,Employee.class).get(0);
    }



}
