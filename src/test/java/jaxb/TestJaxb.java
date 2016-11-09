package jaxb;

import dto.StudentDTO;
import dto.StudentList;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;


public class TestJaxb {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        StudentDTO serhii = new StudentDTO(1, "Serhii");
        studentList.setDtoList(Arrays.asList(serhii,
                new StudentDTO(2, "ivan")));


        StringWriter writer = new StringWriter();

        JAXB.marshal(studentList, writer);

        String res = writer.toString();

        System.out.println(res);

        StudentList unmarshaled = JAXB.unmarshal(new StringReader(res), StudentList.class);

        System.out.println();

    }
}
