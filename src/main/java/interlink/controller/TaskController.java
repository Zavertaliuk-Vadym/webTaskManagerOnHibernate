package interlink.controller;

import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/24/16.
 */
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/newTask",method = RequestMethod.POST)
    void newTask(@RequestParam("new_task") String title,
                 @RequestParam("new_description") String description,
                 @RequestParam("new_list") Integer listId,
                 @RequestParam("new_currentTime") String currentTime, HttpServletResponse response
    ) throws IOException {
        taskService.addNewTask(title, description, listId, currentTime);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    void delete(@RequestParam("task") String id,
                HttpServletResponse response) throws IOException {
        taskService.deleteTask(id);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "/view",method = RequestMethod.POST)
    void swith(@RequestParam("task") String id,
                HttpServletResponse response) throws IOException {
        taskService.switchView(id);
        response.sendRedirect("home");
    }

    @RequestMapping("/about")
    String about(@RequestParam("task") String id, ModelMap modelMap){
        modelMap.addAttribute("task",taskService.getTaskById(id));
        return "about";
    }


}
