package controller;

import dao.TaskDAO;
import model.ListTask;
import model.Task;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/about"})
public class AboutTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TaskDAO dao = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
        Task task = dao.getTaskById(req.getParameter("task"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/about.jsp");
        req.setAttribute("task", task);
        dispatcher.forward(req, resp);
    }
}
