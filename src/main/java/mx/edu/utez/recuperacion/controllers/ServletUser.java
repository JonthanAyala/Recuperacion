package mx.edu.utez.recuperacion.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.recuperacion.models.DaoUser;
import mx.edu.utez.recuperacion.models.Incidencia;
import mx.edu.utez.recuperacion.models.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "users",urlPatterns = {
        "/user/view-login",
        "/user/login",
        "/user/admin",
        "/user/usuario",
        "/user/charger",
        "/user/view-incidencia",
        "/user/save-incidencia",
        "/user/cerrar",
        "/user/des-aprove",
        "/user/acept",
        "/user/aprove",
        "/user/des-aprove-admin"

})
public class ServletUser extends HttpServlet {

    private String action;
    private String redirect = "/user/view-login";
    HttpSession session;
    private User user;

    private String role, name, lastname, mail, pass;
    private Long id_user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/view-login":
                redirect = "/index.jsp";
                break;
            case "/user/admin":
                List<Incidencia> incidencias = new DaoUser().findIncidencias();
                req.setAttribute("incidencias", incidencias);
                redirect = "/views/admin.jsp";
                break;
            case "/user/usuario":
                User user1 = (User) session.getAttribute("user");
                Long userId = user1.getId_user();
                System.out.println("User ID: " + userId);
                List<Incidencia> incidencias2 = new DaoUser().findIncidenciasUser(userId);
                req.setAttribute("incidencias", incidencias2);
                redirect = "/views/user.jsp";
                break;
            case "/user/charger":
                List<Incidencia> incidencias3 = new DaoUser().findIncidenciasCharger();
                req.setAttribute("incidencias", incidencias3);
                redirect = "/views/charger.jsp";
                break;
            case "/user/view-incidencia":
                redirect = "/views/incidencia.jsp";
                break;
            case "/user/cerrar":
                HttpSession session = req.getSession(false);  // Obtener la sesión existente (sin crear una nueva)
                if (session != null) {
                    session.invalidate();  // Invalidar la sesión para cerrarla
                    redirect = "/user/view-login?result=true&message=" + URLEncoder
                            .encode("Sesión cerrada correctamente", StandardCharsets.UTF_8);
                }else{
                    redirect = "/user/view-login?result=false&message=" + URLEncoder
                            .encode("Error en cerrar la Sesion", StandardCharsets.UTF_8);
                }
                break;
            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action){
            case "/user/login":
                mail = req.getParameter("mail");
                pass = req.getParameter("pass");
                try {
                    user = new DaoUser().loadUser( mail, pass);

                    if (user != null){
                        session = req.getSession();
                        session.setAttribute("user", user);
                        System.out.println(session);
                        switch (user.getRole()){
                            case "ADMIN_ROLE":
                                redirect = "/user/admin";
                                break;
                            case "CHARGE_ROLE":
                                redirect = "/user/charger";
                                break;
                            case "USER_ROLE":
                                redirect = "/user/usuario";
                                break;
                            default:
                                redirect = "/user/view-login?result=false&message=" + URLEncoder
                                        .encode("Usuario Afectado acude al administrador",
                                                StandardCharsets.UTF_8);
                                break;
                        }
                    }else {
                        redirect = "/user/view-login?result=false&message=" + URLEncoder
                                .encode("Credenciales inválidas. Intenta de nuevo",
                                        StandardCharsets.UTF_8);
                    }
                }catch (Exception e) {
                    redirect = "/user/view-login?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/save-incidencia":
                User user1 = (User) session.getAttribute("user");
                Long userId = user1.getId_user();
                System.out.println("User ID: " + userId);
                String titulo = req.getParameter("titulo");
                String descripcion = req.getParameter("descripcion");
                String tipo = req.getParameter("tipo");
                Incidencia incidencia = new Incidencia(null,titulo,descripcion,tipo, "Pendiente", null, userId);
                boolean resulSave = new  DaoUser().saveIncidencia(incidencia);
                if (resulSave){
                    redirect = "/user/usuario?result=false&message=" + URLEncoder
                            .encode("Incidencia Guardada",
                                    StandardCharsets.UTF_8);
                }else {
                    redirect = "/user/usuario?result=false&message=" + URLEncoder
                            .encode("Error incidencia no guardada",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/des-aprove":
                Long id = Long.valueOf(req.getParameter("id"));
                boolean resultD = new DaoUser().invaliteI(id);
                if (resultD) {
                    redirect = "/user/charger";
                }else {
                    redirect = "/user/charger?result=false&message=" + URLEncoder
                            .encode("Error en invalidar Incidencia",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/acept":
                Long id2 = Long.valueOf(req.getParameter("id"));
                boolean resultA = new DaoUser().aceptI(id2);
                if (resultA) {
                    redirect = "/user/charger";
                }else {
                    redirect = "/user/charger?result=false&message=" + URLEncoder
                            .encode("Error en invalidar Incidencia",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/aprove":
                Long id3 = Long.valueOf(req.getParameter("id"));
                boolean resultC = new DaoUser().aprove(id3);
                if (resultC) {
                    redirect = "/user/admin";
                }else {
                    redirect = "/user/admin?result=false&message=" + URLEncoder
                            .encode("Error en Aprovar Incidencia",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/des-aprove-admin":
                Long id4 = Long.valueOf(req.getParameter("id"));
                boolean resultDA = new DaoUser().invaliteI(id4);
                if (resultDA) {
                    redirect = "/user/admin";
                }else {
                    redirect = "/user/admin?result=false&message=" + URLEncoder
                            .encode("Error en invalidar Incidencia",
                                    StandardCharsets.UTF_8);
                }
                break;

        }
        resp.sendRedirect(req.getContextPath()+ redirect);
    }
}
