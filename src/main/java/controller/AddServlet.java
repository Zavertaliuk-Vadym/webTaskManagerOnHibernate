package controller;

import dao.ListDAO;
import dao.TaskDAO;
import model.ListTask;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet({"/add_task"})
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListDAO listDAO = new ListDAO((SessionFactory) getServletContext().getAttribute("factory"));
        List<ListTask> ListTasks = listDAO.getAllListTasks();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/add_task.jsp");
        req.setAttribute("ListTasks", ListTasks);
        dispatcher.forward(req, resp);
    }

}