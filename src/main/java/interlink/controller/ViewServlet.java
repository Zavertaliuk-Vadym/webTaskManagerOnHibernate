//package interlink.controller;
//
//
//import interlink.dao.TaskDAO;
//import org.hibernate.SessionFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet({"/view"})
//public class ViewServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        TaskDAO dao = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
//        TaskDAO dao = new TaskDAO();
//        dao.switchStatusTask(req.getParameter("task"));
//        resp.sendRedirect("/home");
//    }
//}