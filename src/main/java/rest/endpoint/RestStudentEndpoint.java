package rest.endpoint;

import dto.StudentDTO;
import dto.StudentList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AdminController;
import soap.endpointDTO.StudentEndPoint;
import util.DTOConverter;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

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
    public String hello() {
        return "hello";
    }

    //    http://localhost:8080/jersey/rest/student/info/1
    @Path("/info/{id}")
    @GET
    @Produces({"application/json"})
    public StudentDTO getEntityById(@PathParam("id") Integer id) {
        return DTOConverter.convert(adminController.getStudentById(id));
    }

    @Path("/update")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public boolean update(StudentDTO entity) {
        return adminController.updateStudent(DTOConverter.convert(entity));
    }


    @Path("/create")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public StudentDTO create(StudentDTO entity) {
        return DTOConverter.convert(adminController.createStudent(DTOConverter.convert(entity)));
    }

    @GET
    @Path("/all")
    @Produces({"application/json"})
    //    public StudentList getAll(@QueryParam("start")int start,@QueryParam("end") int lenght) {
    public StudentList getAll() {
        return DTOConverter.getStudentList(adminController.getAllStudents());
    }
}
