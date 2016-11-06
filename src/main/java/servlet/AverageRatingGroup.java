package servlet;

import model.Group;
import org.springframework.context.ApplicationContext;
import service.AdminController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/averageRatingGroup"})
public class AverageRatingGroup extends HttpServlet{

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
        req.getRequestDispatcher("/WEB-INF/pages/averageRatingGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupid  = req.getParameter("groupid");
        Group group = studentService.getGroupById(Integer.parseInt(groupid));

        int averageRatingGroup = studentService.getAverageRatingGroup(group);
        resp.getWriter().print("Average rating of group " + group + " : " + averageRatingGroup);

    }


}
