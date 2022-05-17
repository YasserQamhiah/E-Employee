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
        @Override
    public Employee updateEmployee(String id,Employee employee) throws Exception {
        Optional<Employee> temp=employeeRepository.findById(id);
        if(!temp.isPresent()){
            throw new Exception("There's NO Employee with that id");
        }
        employee=updateEmployeeValue(temp.get(),temp.get());
        employee.setEmployeeId(id);
        employeeRepository.save(employee);
        return employee;
    }
    private Employee updateEmployeeValue(Employee old, Employee newEmployee){

        if(newEmployee.getFname()!=null &&!old.getFname().equals(newEmployee.getFname()))
            newEmployee.setFname(old.getFname());
        if(newEmployee.getLname()!=null &&!old.getLname().equals(newEmployee.getLname()))
            newEmployee.setLname(old.getLname());
        if(newEmployee.getBirthDate()!=null && !old.getBirthDate().equals(newEmployee.getBirthDate()))
            newEmployee.setBirthDate(old.getBirthDate());
        if(newEmployee.getEmail()!=null &&!old.getEmail().equals(newEmployee.getEmail()))
            newEmployee.setEmail(old.getEmail());
        if(newEmployee.getPhone()!=null &&!old.getPhone().equals(newEmployee.getPhone()))
            newEmployee.setPhone(old.getPhone());
        if(newEmployee.getSalary()!=-1 &&old.getSalary()!= newEmployee.getSalary())
            newEmployee.setSalary(old.getSalary());
        if(newEmployee.getHireDate()!=null &&!old.getHireDate().equals(newEmployee.getHireDate()))
            newEmployee.setHireDate(old.getHireDate());


        return newEmployee;
    }


}
