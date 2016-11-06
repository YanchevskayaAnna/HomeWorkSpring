package servlet;

import model.Student;
import org.springframework.context.ApplicationContext;
import service.AdminController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private ApplicationContext applicationContext;
    private AdminController adminService;

    @Override
    public void init() throws ServletException {

        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");

        adminService = applicationContext.getBean(AdminController.class);

    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Student found = adminService.getStudentById(Integer.parseInt(id));

        if (found == null) {

            req.setAttribute("errorTitle", "Login Error");
            req.setAttribute("errorMessage", "invalid id");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);

        } else {

            HttpSession session = req.getSession(true);
            session.setAttribute("inSystem", true);
            session.setAttribute("currentUserName", found.getName());
            resp.sendRedirect("index.jsp");

        }
    }
}
