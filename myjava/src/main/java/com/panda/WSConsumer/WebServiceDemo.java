
package com.panda.WSConsumer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceDemo", targetNamespace = "http://externalService.app.panda.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceDemo {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "testWebService", targetNamespace = "http://externalService.app.panda.com/", className = "com.panda.WSConsumer.TestWebService")
    @ResponseWrapper(localName = "testWebServiceResponse", targetNamespace = "http://externalService.app.panda.com/", className = "com.panda.WSConsumer.TestWebServiceResponse")
    @Action(input = "http://externalService.app.panda.com/WebServiceDemo/testWebServiceRequest", output = "http://externalService.app.panda.com/WebServiceDemo/testWebServiceResponse")
    public String testWebService(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}
