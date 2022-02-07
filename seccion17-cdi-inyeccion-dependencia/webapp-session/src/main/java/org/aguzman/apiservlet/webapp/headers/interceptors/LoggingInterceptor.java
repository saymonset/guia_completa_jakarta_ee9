package org.aguzman.apiservlet.webapp.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LoggingInterceptor {

    @Inject
    private Logger log;


    /*metodo nombrado como queira pere debe estar anotado con @AroundInvoke.
    Envolver la invocacion de este metodo
            debe ser @AroundInvoke*/
    /*Va a devolver siempre Object*/
    @AroundInvoke
    public Object logging(InvocationContext invocation) throws Exception {

        log.info(" ***** entrando antes de invacar el metodo "+
                invocation.getMethod().getName() +
                " de la clase " +  invocation.getMethod().getDeclaringClass());

        /*Antes de ejecutar el metodo*/
        Object resultado = invocation.proceed();
        /*Despues de ejecutar el metodo*/

        log.info(" ***** saliendo de la invocacion del metodo " +
                invocation.getMethod().getName());
        return resultado;
    }
}
