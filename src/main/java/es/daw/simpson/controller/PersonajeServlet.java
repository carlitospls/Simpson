package es.daw.simpson.controller;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/personajes")
public class PersonajeServlet extends HttpServlet {
    private String message;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // lo que me de la gana...
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // ...........

    }


}