//package interlink.controller;
//
//
//import interlink.dao.ListDAO;
//import interlink.model.ListTask;
//
//import org.hibernate.SessionFactory;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet({"/home"})
//public class HomePageServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ListDAO listDAO = new ListDAO((SessionFactory) getServletContext().getAttribute("factory"));
//        List<ListTask> list = listDAO.getAllListTasks();
//
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
//        req.setAttribute("ListTasks", list);
//        dispatcher.forward(req, resp);
//    }
//}
