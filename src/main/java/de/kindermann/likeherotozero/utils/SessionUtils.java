package de.kindermann.likeherotozero.utils;

import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Utility class for handling session-related operations.
 */
public class SessionUtils {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserEmail() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
       if (session.getAttribute("userEmail") != null) {
           return session.getAttribute("userEmail").toString();
       } else {
           return null;
       }
    }

    /**
     * Retrieves the user ID from the current HTTP session.
     *
     * @return the user ID if present in the session, null otherwise.
     */
    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("userid");
        else
            return null;package de.kindermann.likeherotozero.utils;

import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Utility class for handling session-related operations.
 */
        public class SessionUtils {

            public static HttpSession getSession() {
                return (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);
            }

            public static HttpServletRequest getRequest() {
                return (HttpServletRequest) FacesContext.getCurrentInstance()
                        .getExternalContext().getRequest();
            }

            public static String getUserEmail() {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);
                if (session.getAttribute("userEmail") != null) {
                    return session.getAttribute("userEmail").toString();
                } else {
                    return null;
                }
            }

            public static String getUserId() {
                HttpSession session = getSession();
                if (session != null)
                    return (String) session.getAttribute("userid");
                else
                    return null;
            }
        }
    }
}