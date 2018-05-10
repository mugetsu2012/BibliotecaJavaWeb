/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Utiles;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    private List<String> urlsPermitidasAdmin;
    private List<String> urlsPermitidasAlumnoProfesor;

    public AuthorizationFilter() {
        urlsPermitidasAdmin = Arrays.asList("login.xhtml", "estantes.xhtml", "libros.xhtml", "prestamos.xhtml", "devoluciones.xhtml", "misprestamos.xhtml", "usuarios.xhtml", "parametros.xhtml", "revistas.xhtml", "categorias.xhtml","tesis.xhtml","cd.xhtml","reporte.xhtml");
        urlsPermitidasAlumnoProfesor = Arrays.asList("misprestamos.xhtml");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //Se sacan los request
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            HttpSession ses = reqt.getSession();

            //Obtenemos el uri para donde iba el user
            String reqURI = reqt.getRequestURI();

            //Si no va para el el login, o esta obteniendo un recurso y no hay session lo mandamos al login
            if ((reqURI.indexOf("/login.xhtml") >= 0
                    || (ses != null && ses.getAttribute("usuario") != null)
                    || reqURI.indexOf("/public/") >= 0
                    || reqURI.contains("javax.faces.resource")) && tienePermiso(reqURI, ses)) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }

    public boolean tienePermiso(String uri, HttpSession ses) {

        //Primero ver que el uri tenga un xhtml
        if (!uri.contains(".xhtml")) {
            return true;
        }

        if (uri.indexOf("/login.xhtml") >= 0) {
            return true;
        }

        if (ses.getAttribute("rol") == null) {
            return false;
        }

        //Se saca el rol y su enum
        String rolString = ses.getAttribute("rol").toString();
        int rolInt = Integer.parseInt(rolString);
        Enums.Roles rol = Enums.Roles.valueOf(rolInt);

        //Si es admin
        if (rol == Enums.Roles.Admin) {
            return comprobarPaginas(uri, urlsPermitidasAdmin);
        } else if (rol == Enums.Roles.Alumno || rol == Enums.Roles.Profesor) {
            return comprobarPaginas(uri, urlsPermitidasAlumnoProfesor);
        }

        return false;
    }

    public boolean comprobarPaginas(String uri, List<String> paginasPermitidas) {
        List<String> result = paginasPermitidas.stream()
                .filter(pagina -> uri.contains(pagina))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
