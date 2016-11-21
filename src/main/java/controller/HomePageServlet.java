package controller;


import dao.ListDAO;
import dao.TaskDAO;
import model.ListTask;
import model.Task;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/home"})
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        TaskDAO taskDAO = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
//
//        List<Task> tasks = taskDAO.getAllTasks();

        ListDAO listDAO = new ListDAO((SessionFactory) getServletContext().getAttribute("factory"));
        List<ListTask> list = listDAO.getAllListTasks();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        req.setAttribute("ListTasks", list);
        dispatcher.forward(req, resp);
    }
}
