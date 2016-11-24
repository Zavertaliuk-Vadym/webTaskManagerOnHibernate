package interlink.controller;

import com.sun.deploy.net.HttpResponse;
import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/24/16.
 */
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/newTask")
    void newTask(@RequestParam("new_task") String title,
                 @RequestParam("new_description") String descr,
                 @RequestParam("new_list") Integer list,
                 @RequestParam("new_currentTime") String currentTime, HttpServletResponse response
    ) throws IOException {
        taskService.addNewTask(title, descr, list, currentTime);
        response.sendRedirect("home");
    }
}
