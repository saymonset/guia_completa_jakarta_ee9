
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

    private final static QName _Crear_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "crear");
    private final static QName _CrearResponse_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "crearResponse");
    private final static QName _Listar_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "listar");
    private final static QName _ListarResponse_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "listarResponse");
    private final static QName _Saludar_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "saludar");
    private final static QName _SaludarResponse_QNAME = new QName("http://services.jaxws.webapp.aguzman.org/", "saludarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.aguzman.webapp.jaxws.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Crear }
     * 
     */
    public Crear createCrear() {
        return new Crear();
    }

    /**
     * Create an instance of {@link CrearResponse }
     * 
     */
    public CrearResponse createCrearResponse() {
        return new CrearResponse();
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
     * Create an instance of {@link Saludar }
     * 
     */
    public Saludar createSaludar() {
        return new Saludar();
    }

    /**
     * Create an instance of {@link SaludarResponse }
     * 
     */
    public SaludarResponse createSaludarResponse() {
        return new SaludarResponse();
    }

    /**
     * Create an instance of {@link Curso }
     * 
     */
    public Curso createCurso() {
        return new Curso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Crear }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Crear }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "crear")
    public JAXBElement<Crear> createCrear(Crear value) {
        return new JAXBElement<Crear>(_Crear_QNAME, Crear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "crearResponse")
    public JAXBElement<CrearResponse> createCrearResponse(CrearResponse value) {
        return new JAXBElement<CrearResponse>(_CrearResponse_QNAME, CrearResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Saludar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Saludar }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "saludar")
    public JAXBElement<Saludar> createSaludar(Saludar value) {
        return new JAXBElement<Saludar>(_Saludar_QNAME, Saludar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaludarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaludarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.jaxws.webapp.aguzman.org/", name = "saludarResponse")
    public JAXBElement<SaludarResponse> createSaludarResponse(SaludarResponse value) {
        return new JAXBElement<SaludarResponse>(_SaludarResponse_QNAME, SaludarResponse.class, null, value);
    }

}
