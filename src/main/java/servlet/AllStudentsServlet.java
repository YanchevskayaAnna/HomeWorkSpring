package servlet;


import org.springframework.context.ApplicationContext;
import service.AdminController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/allstudents"})
public class AllStudentsServlet extends HttpServlet {

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
        List students = studentService.getAllStudents();
        req.setAttribute("liststudents", students);
        req.getRequestDispatcher("/WEB-INF/pages/all-students.jsp").forward(req, resp);
    }

  }
