package test;

import soap.endpoint.Student;
import soap.endpoint.StudentEndPoint;
import soap.endpoint.StudentEndPointImplService;

public class RunClient {

//    BEFORE D:\ACP14\JPA_Hebirnate\HomeWorkSpring\SOAPClient\src\main\java>wsimport -keep http://192.168.0.100:9999/soap/student?wsdl

    public static void main(String[] args) {

        StudentEndPoint studentEndPoint = new StudentEndPointImplService().getStudentEndPointImplPort();

//        Student student = studentEndPoint.getEntityById(6);
//        System.out.printf("name %s id %s", student.getName(), student.getId());

        Student student1 = new Student();
        student1.setName("Soap client");

        Student student2 = studentEndPoint.create(student1);
        System.out.printf("name %s id %s", student2.getName(), student2.getId());

    }
}
