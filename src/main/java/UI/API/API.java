package UI.API;

import com.example.EEmployee.collection.Employee;

import java.util.List;

public interface API {
    List<Employee> getAllEmployee(String cookie) throws Exception;
    Employee POSTEmployee(Employee employee, String cookie) throws Exception;
    Employee updateEmployee(Employee employee, String cookie , String id) throws Exception;
}
