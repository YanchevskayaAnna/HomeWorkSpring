package test;

import soap.endpointdto.StudentDTO;
import soap.endpointdto.StudentEndPoint;
import soap.endpointdto.StudentEndPointImplService;
import soap.endpointdto.StudentList;

public class RunClient {

//    BEFORE D:\ACP14\JPA_Hebirnate\HomeWorkSpring\SOAPClient\src\main\java>wsimport -keep http://192.168.0.100:9999/soap/student?wsdl

    public static void main(String[] args) {

        StudentEndPoint studentEndpoint = new StudentEndPointImplService().getStudentEndPointImplPort();
        StudentList studentList = studentEndpoint.getAll();

        studentList.getStudents().stream().
                forEach((s) ->
                        System.out.printf("%d,%s\n", s.getId(),s.getName()));

    }
}
