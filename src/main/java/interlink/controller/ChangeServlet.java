//package interlink.controller;
//
//import interlink.dao.TaskDAO;
//import interlink.model.Task;
//import org.hibernate.SessionFactory;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet({"/change"})
//public class ChangeServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        TaskDAO dao = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
//        TaskDAO dao = new TaskDAO();
//        Task task = dao.getTaskById(req.getParameter("id"));
//        System.out.println("task"+task);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/change.jsp");
//        req.setAttribute("task", task);
//        dispatcher.forward(req, resp);
//    }
//}