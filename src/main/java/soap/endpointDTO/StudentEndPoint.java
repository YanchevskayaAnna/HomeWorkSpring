package soap.endpointDTO;

import dto.StudentDTO;
import dto.StudentList;
import model.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentEndPoint {

    @WebMethod
    StudentDTO getEntityById(Integer id);

    @WebMethod
    boolean update(StudentDTO entity);

    @WebMethod
    StudentDTO create(StudentDTO entity);

    @WebMethod
    StudentList getAll();
}
