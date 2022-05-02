
package org.aguzman.webapp.jaxws.services;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.aguzman.webapp.jaxws.services package. 
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

    private final static QName _Guardar_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "guardar");
    private final static QName _GuardarResponse_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "guardarResponse");
    private final static QName _Listar_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "listar");
    private final static QName _ListarResponse_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "listarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.aguzman.webapp.jaxws.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Guardar }
     * 
     */
    public Guardar createGuardar() {
        return new Guardar();
    }

    /**
     * Create an instance of {@link GuardarResponse }
     * 
     */
    public GuardarResponse createGuardarResponse() {
        return new GuardarResponse();
    }

    /**
     * Create an instance of {@link Listar }
     * 
     */
    public Listar createListar() {
        return new Listar();
    }

    /**
     * Create an instance of {@link ListarResponse }
     * 
     */
    public ListarResponse createListarResponse() {
        return new ListarResponse();
    }

    /**
     * Create an instance of {@link Curso }
     * 
     */
    public Curso createCurso() {
        return new Curso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Guardar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Guardar }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "guardar")
    public JAXBElement<Guardar> createGuardar(Guardar value) {
        return new JAXBElement<Guardar>(_Guardar_QNAME, Guardar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "guardarResponse")
    public JAXBElement<GuardarResponse> createGuardarResponse(GuardarResponse value) {
        return new JAXBElement<GuardarResponse>(_GuardarResponse_QNAME, GuardarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "listar")
    public JAXBElement<Listar> createListar(Listar value) {
        return new JAXBElement<Listar>(_Listar_QNAME, Listar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "listarResponse")
    public JAXBElement<ListarResponse> createListarResponse(ListarResponse value) {
        return new JAXBElement<ListarResponse>(_ListarResponse_QNAME, ListarResponse.class, null, value);
    }

}
