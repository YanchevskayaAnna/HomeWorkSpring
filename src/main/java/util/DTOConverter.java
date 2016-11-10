package util;

import dto.StudentDTO;
import dto.StudentList;
import model.Group;
import model.Student;

import java.util.ArrayList;
import java.util.List;


public class DTOConverter {

    public static StudentDTO convert(Student student){
        return new StudentDTO(student.getId(),student.getName());
    }

    public static Student convert(StudentDTO student){
        Student student1 = new Student();
        student1.setId(student.getId());
        student1.setName(student.getName());
        return student1;
    }


    public static StudentList getStudentList(List<Student> students) {
        StudentList studentList = new StudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            studentDTOs.add(new StudentDTO(student.getId(),student.getName()));
        }

        studentList.setDtoList(studentDTOs);

        return studentList;
    }
}
