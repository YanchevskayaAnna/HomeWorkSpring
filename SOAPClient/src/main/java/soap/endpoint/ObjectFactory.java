
package soap.endpoint;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.endpoint package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Teacher }
     * 
     */
    public Teacher createTeacher() {
        return new Teacher();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Mark }
     * 
     */
    public Mark createMark() {
        return new Mark();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

}
