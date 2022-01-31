package org.aguzman.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*DispacheServlet:No realiza un request nuevo, si no que actualiza el request actual
        * y lo une con un nuevo servlet  y mantiene las variable del request anterior
        * y no cambia el servelet original su ruta, se mantiene a /despachar
        * con las nuevs variables del servlet producto.html*/

        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
    }
}
