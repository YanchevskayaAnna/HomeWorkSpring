
package soap.endpointdto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.endpointdto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StudentsList_QNAME = new QName("http://endpointDTO.soap/", "studentsList");
    private final static QName _Student_QNAME = new QName("http://endpointDTO.soap/", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.endpointdto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentDTO }
     * 
     */
    public StudentDTO createStudentDTO() {
        return new StudentDTO();
    }

    /**
     * Create an instance of {@link StudentList }
     * 
     */
    public StudentList createStudentList() {
        return new StudentList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpointDTO.soap/", name = "studentsList")
    public JAXBElement<StudentList> createStudentsList(StudentList value) {
        return new JAXBElement<StudentList>(_StudentsList_QNAME, StudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpointDTO.soap/", name = "student")
    public JAXBElement<StudentDTO> createStudent(StudentDTO value) {
        return new JAXBElement<StudentDTO>(_Student_QNAME, StudentDTO.class, null, value);
    }

}
