package UI.API;

import com.example.EEmployee.collection.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAPI {
    final static CloseableHttpClient httpClient= HttpClients.createDefault();

    public static void getAllEmployee()throws Exception{
        HttpGet request=new HttpGet("http://localhost:8080/Employee/");
        CloseableHttpResponse respone=httpClient.execute(request);
        HttpEntity entity=respone.getEntity();
        if(respone.getStatusLine().getStatusCode()!=200){
            System.err.println("There's Something went wrong");
        }
        ObjectMapper mapper=new ObjectMapper();
        List<Employee> list=new ArrayList<Employee>();

        list=mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<Employee>>() {
        });
        list.forEach(e-> System.out.println("e = " + e));
    }
}
