/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Utiles;

import java.io.IOException;
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
    
    public AuthorizationFilter(){
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            //Se sacan los request
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            
            HttpSession ses = reqt.getSession();
            
            //Obtenemos el uri para donde iba el user
            String reqURI = reqt.getRequestURI();
            
            //Si no va para el el login, o esta obteniendo un recurso y no hay session lo mandamos al login
            if (reqURI.indexOf("/login.xhtml") >= 0
                    || (ses != null && ses.getAttribute("usuario") != null)
                    || reqURI.indexOf("/public/") >= 0
                    || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        
    }
    
    
}
