<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<%--como este user name solo esta en el contexto requestScope, se puede omitir
el requestScope--%>
<c:if test="${username.present}">
    <%--La etiqueta <c:out test="$username.get()" /> se uede quitar y colocar de forma directa--%>
   <div>Hola ${username.get()}, bienvenido!</div>
   <p><a href="${pageContext.request.contextPath}/productos/form">crear [+]</a></p>
</c:if>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>tipo</th>
        <c:if test="${username.present}">
        <th>precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
        </c:if>
    </tr>
    <c:forEach items="${productos}" var="p">
    <tr>
        <td>${p.id}</td>
        <td>${p.nombre}</td>
        <td>${p.categoria.nombre}</td>
        <c:if test="${username.present}">
        <td>${p.precio}</td>
        <td><a href="${pageContext.request.contextPath}/carro/agregar?id=${p.id}">agregar al carro</a></td>
        <td><a href="${pageContext.request.contextPath}/productos/form?id=${p.id}">editar</a></td>
        <td><a onclick="return confirm('esta seguro que desea eliminar?');"
        href="${pageContext.request.contextPath}/productos/eliminar?id=${p.id}">eliminar</a></td>
        </c:if>
    </tr>
    </c:forEach>
</table>

<%--Contexto de la aplicacion: getServletContext es equivalente
a lenguaje de expresion
applicationScope --%>
<p>${applicationScope.mensaje}</p>
<%--
Para cada request, la expresion lenguaje es requestScope que sustituye a
request.getAttribute("xxx");
--%>
<p>${requestScope.mensaje}</p>
</body>
</html>