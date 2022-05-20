package UI.API;

import com.example.EEmployee.collection.Employee;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface API {
    List<Employee> getAllEmployee(String cookie) throws Exception;
    Employee POSTEmployee(Employee employee, String cookie) throws Exception;
}
