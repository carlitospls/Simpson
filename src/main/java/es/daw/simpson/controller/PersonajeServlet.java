package es.daw.simpson.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import es.daw.simpson.model.Personaje;
import es.daw.simpson.repository.PersonajeRepository;
import es.daw.simpson.service.PersonajeService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/personajes")
public class PersonajeServlet extends HttpServlet {

    // NO VAMOS A USAR REPOSITORIOS DIRECTAMENTE DEL SERVLET, VAMOS A USAR SERVICIOS!!!!
    private final PersonajeService personajeService = new PersonajeService();


//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//
//        // lo que me de la gana...
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // 1. LEER LOS PARÁMETROS DEL REQUEST
        // PENDIENTE!!!
        String lugar = request.getParameter("lugar");
        String edadMax = request.getParameter("edadMax"); // cuidadín!!! llega como un String pero la edad la trato como un int

        Integer edadMin = Integer.valueOf(request.getParameter("edadMin"));
        int edadMin2 = Integer.parseInt(request.getParameter("edadMin"));

        // continuará...
        //boolean descendente = Boolean.parseBoolean(request.getParameter("descendente"));
        boolean descendente = request.getParameter("descendente") != null; // si no está marcado no se envía!!!



        // 2. VALIDAR LOS DATOS DE LOS PARÁMETROS

        // 3. LÓGICA DE NEGOCIO QUE HARÁ UN SERVICIO. OBTENER LA LISTA DE LOS PERSONAJES (con o sin filtro, con o sin ordenación...)
        List<Personaje> personajes = personajeService.buscar();


        // 4. ENVIAR A LA VISTA LA INFORMACIÓN PERTINENTE
        request.setAttribute("personajes", personajes);

        // 5. REENVIAR A LA VISTA (JSP)
        request.getRequestDispatcher("/personajes.jsp").forward(request,response);

    }


}