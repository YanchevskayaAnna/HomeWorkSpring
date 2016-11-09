
package soap.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StudentEndPointImplService", targetNamespace = "http://endpoint.soap/", wsdlLocation = "http://192.168.0.100:9999/soap/student?wsdl")
public class StudentEndPointImplService
    extends Service
{

    private final static URL STUDENTENDPOINTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException STUDENTENDPOINTIMPLSERVICE_EXCEPTION;
    private final static QName STUDENTENDPOINTIMPLSERVICE_QNAME = new QName("http://endpoint.soap/", "StudentEndPointImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.100:9999/soap/student?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STUDENTENDPOINTIMPLSERVICE_WSDL_LOCATION = url;
        STUDENTENDPOINTIMPLSERVICE_EXCEPTION = e;
    }

    public StudentEndPointImplService() {
        super(__getWsdlLocation(), STUDENTENDPOINTIMPLSERVICE_QNAME);
    }

    public StudentEndPointImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), STUDENTENDPOINTIMPLSERVICE_QNAME, features);
    }

    public StudentEndPointImplService(URL wsdlLocation) {
        super(wsdlLocation, STUDENTENDPOINTIMPLSERVICE_QNAME);
    }

    public StudentEndPointImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STUDENTENDPOINTIMPLSERVICE_QNAME, features);
    }

    public StudentEndPointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StudentEndPointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StudentEndPoint
     */
    @WebEndpoint(name = "StudentEndPointImplPort")
    public StudentEndPoint getStudentEndPointImplPort() {
        return super.getPort(new QName("http://endpoint.soap/", "StudentEndPointImplPort"), StudentEndPoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StudentEndPoint
     */
    @WebEndpoint(name = "StudentEndPointImplPort")
    public StudentEndPoint getStudentEndPointImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoint.soap/", "StudentEndPointImplPort"), StudentEndPoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STUDENTENDPOINTIMPLSERVICE_EXCEPTION!= null) {
            throw STUDENTENDPOINTIMPLSERVICE_EXCEPTION;
        }
        return STUDENTENDPOINTIMPLSERVICE_WSDL_LOCATION;
    }

}
