package org.aguzman.apiservlet.webapp.headers.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
/*Hay que darle cuaquier contexto porque en el bean.xml colocamos clases anotadas solamente*/
@ApplicationScoped
public class ProducerResources {

    @Inject
    private Logger log;

    @Resource(name="jdbc/mysqlDB")
    private DataSource ds;

    @Produces
    @RequestScoped
    @MysqlConn
    private Connection beanConnection() throws NamingException, SQLException {
//        Context initContext = new InitialContext();
//        Context envContext = (Context) initContext.lookup("java:/comp/env");
//        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
        return ds.getConnection();
    }

    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    /*La forma cdi con dispose para cerrar la conexion con bd*/
    public void close(@Disposes @MysqlConn Connection connection) throws SQLException {
        connection.close();
        log.info("cerrando la conexion a la bbdd mysql!");
    }
}
