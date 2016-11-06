package servlet;

import model.Group;
import model.Student;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.AdminController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

// register

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

    private ApplicationContext applicationContext;
    private AdminController studentService;

    @Override
    public void init() throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        studentService = applicationContext.getBean(AdminController.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  some action
        // just redirect to register.jsp
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
        String name = req.getParameter("name");
        String groupid = req.getParameter("groupid");

        if (name == null || groupid == null) {
            // redirect
            resp.sendRedirect("http/error.jsp");

        } else {

            Group group = studentService.getGroupById(Integer.parseInt(groupid));
            Student student = new Student();
            student.setGroup(group);
            student.setName(name);
            Student created = studentService.createStudent(student);
            req.setAttribute("student", created);
            req.getRequestDispatcher("/WEB-INF/pages/student-info.jsp").forward(req, resp);

        }
    }

}
