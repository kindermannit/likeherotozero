package de.kindermann.likeherotozero.utils;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * This filter checks the authorization of incoming requests to ensure that the user
 * is authenticated before allowing access to protected resources. It intercepts
 * all requests with the pattern "*.xhtml" and checks for an existing session with a
 * user email attribute. If the user is not authenticated, it redirects them to
 * the login page.
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.contains("/login.xhtml")
                    || (ses != null && ses.getAttribute("userEmail") != null)
                    || reqURI.contains("/public/")
                    || reqURI.contains("jakarta.faces.resource"))
                chain.doFilter(request, response);
            else
                resp.sendRedirect(reqt.getContextPath() + "/login.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}