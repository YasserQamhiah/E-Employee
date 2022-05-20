package UI.API;

import com.example.EEmployee.collection.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class EmployeeAPI implements API {
    final static CloseableHttpClient httpClient= HttpClients.createDefault();

    public List<Employee> getAllEmployee(String cookie)throws Exception{
        HttpGet request=new HttpGet("http://localhost:8080/Employee");
        request.setHeader("Cookie","JSESSIONID="+cookie);
        CloseableHttpResponse respone=httpClient.execute(request);
        HttpEntity entity=respone.getEntity();
        if(respone.getStatusLine().getStatusCode()!=200){
            System.err.println("There's Something went wrong" + "\n " + respone.getStatusLine().toString());
            return null;
        }
        ObjectMapper mapper=new ObjectMapper();
        List<Employee> list=new ArrayList<Employee>();

        list=mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<Employee>>() {
        });
        return list;
    }
    public Employee POSTEmployee(Employee employee,String cookie) throws IOException {
        HttpPost request=new HttpPost(
                "http://localhost:8080/Employee"
        );
        request.setHeader("Cookie","JSESSIONID="+cookie);

        ObjectMapper mapper=new ObjectMapper();
        StringEntity json=new StringEntity(mapper.writeValueAsString(employee), ContentType.APPLICATION_JSON);
        request.setEntity(json);
        CloseableHttpResponse response=httpClient.execute(request);
        HttpEntity entity=response.getEntity();

        if(response.getStatusLine().getStatusCode()!=200){
            System.err.println("There's Something went wrong");
            return null;
        }
        Employee e=mapper.readValue(EntityUtils.toString(entity), new TypeReference<Employee>() {
        });
        return e;


    }
}
