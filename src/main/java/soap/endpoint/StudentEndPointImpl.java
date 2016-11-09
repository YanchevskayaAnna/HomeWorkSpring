package soap.endpoint;

import model.Student;
import service.AdminController;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.endpoint.StudentEndPoint")
public class StudentEndPointImpl implements StudentEndPoint {
    private AdminController adminController;

    public StudentEndPointImpl(AdminController adminController) {
        this.adminController = adminController;
    }

    public StudentEndPointImpl() {
    }

    @Override
    public Student getEntityById(Integer id) {
        return adminController.getStudentById(id);
    }

    @Override
    public boolean update(Student entity) {
        return adminController.updateStudent(entity);
    }

    @Override
    public Student create(Student entity) {
        return adminController.createStudent(entity);
    }
}
