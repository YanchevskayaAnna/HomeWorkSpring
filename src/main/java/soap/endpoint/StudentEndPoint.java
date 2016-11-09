package soap.endpoint;

import model.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentEndPoint {

    @WebMethod
    Student getEntityById(Integer id);

    @WebMethod
    boolean update(Student entity);

    @WebMethod
    Student create(Student entity);
}
