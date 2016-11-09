package run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AdminController;
import soap.endpointDTO.StudentEndPointImpl;

import javax.xml.ws.Endpoint;

public class RunSOAPServerDTO {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("app-context.xml");
        AdminController studentService = appCon.getBean(AdminController.class);

        Endpoint.publish(
                "http://192.168.0.100:9999/soap/student", new StudentEndPointImpl(studentService));

        //http://192.168.0.100:9999/soap/student?wsdl

    }
}
