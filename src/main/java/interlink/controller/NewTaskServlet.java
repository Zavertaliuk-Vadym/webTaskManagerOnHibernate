package interlink.controller;


import interlink.dao.TaskDAO;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet({"/newTask"})
public class NewTaskServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TaskDAO dao = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
        dao.addNewTask(req.getParameter("new_task"), req.getParameter("new_description"), parseInt(req.getParameter("new_list")), req.getParameter("new_currentTime"));
        resp.sendRedirect("/home");
    }

}
