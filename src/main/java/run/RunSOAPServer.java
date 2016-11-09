package run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AdminController;
import soap.endpoint.StudentEndPointImpl;

import javax.xml.ws.Endpoint;

public class RunSOAPServer {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("app-context.xml");
        AdminController studentService = appCon.getBean(AdminController.class);

//        Endpoint.publish(
//                "http://192.168.1.61:9999/soap/student", new StudentEndPointImpl(studentService));

        Endpoint.publish(
                "http://192.168.0.100:9999/soap/student", new StudentEndPointImpl(studentService));

    }
}
