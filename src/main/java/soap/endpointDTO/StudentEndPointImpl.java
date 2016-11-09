package soap.endpointDTO;

import dto.StudentDTO;
import dto.StudentList;
import model.Student;
import service.AdminController;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap.endpointDTO.StudentEndPoint")
public class StudentEndPointImpl implements StudentEndPoint {

    private AdminController adminController;

    public StudentEndPointImpl(AdminController adminController) {
        this.adminController = adminController;
    }

    public StudentEndPointImpl() {
    }

    @Override
    public StudentDTO getEntityById(Integer id) {
        Student student = adminController.getStudentById(id);
        return new StudentDTO(student.getId(), student.getName());
    }

    @Override
    public boolean update(StudentDTO entity) {
        Student student = new Student();
        student.setName(entity.getName());
        student.setId(entity.getId());
        return adminController.updateStudent(student);
    }

    @Override
    public StudentDTO create(StudentDTO entity) {

        Student student = new Student();
        student.setName(entity.getName());
        student.setId(entity.getId());
        Student newstudent =  adminController.createStudent(student);
        return new StudentDTO(newstudent.getId(), newstudent.getName());

    }

    @Override
    public StudentList getAll() {

        List<Student> students = adminController.getAllStudents();
        return getStudentList(students);

    }

    private StudentList getStudentList(List<Student> students) {

        StudentList studentList = new StudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            studentDTOs.add(new StudentDTO(student.getId(),student.getName()));
        }

        studentList.setDtoList(studentDTOs);

        return studentList;
    }
}
