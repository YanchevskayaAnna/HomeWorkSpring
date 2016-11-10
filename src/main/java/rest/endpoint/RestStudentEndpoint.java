package rest.endpoint;

import dto.StudentDTO;
import dto.StudentList;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AdminController;
import soap.endpointDTO.StudentEndPoint;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class RestStudentEndpoint implements StudentEndPoint {

    private AdminController adminController;

    public RestStudentEndpoint() {
        System.out.println("Endpoint constructor");
    }

    @PostConstruct
    public void init() {
        // use listener for init context
        ApplicationContext app = new ClassPathXmlApplicationContext("app-context.xml");
        adminController = app.getBean(AdminController.class);
    }

    @Path("/hello")
    @GET
    public String hello(){
        return "hello";
    }

//    http://localhost:8080/jersey/rest/student/info/1
    @Path("/info/{id}")
    @GET
    public StudentDTO getEntityById(@PathParam("id")Integer id) {
        Student student = adminController.getStudentById(id);
        return new StudentDTO(student.getId(), student.getName());
    }

    @POST
    @Path("/update")
    public boolean update(StudentDTO entity) {
        Student student = new Student();
        student.setName(entity.getName());
        student.setId(entity.getId());
        return adminController.updateStudent(student);
    }

    @POST
    @Path("/create")
    public StudentDTO create(StudentDTO entity) {

        Student student = new Student();
        student.setName(entity.getName());
        student.setId(entity.getId());
        Student newstudent =  adminController.createStudent(student);
        return new StudentDTO(newstudent.getId(), newstudent.getName());

    }

    @GET
    @Path("/all")
    //    public StudentList getAll(@QueryParam("start")int start,@QueryParam("end") int lenght) {
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
