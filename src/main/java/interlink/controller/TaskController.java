package interlink.controller;

import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task/{taskId}/delete", method = RequestMethod.POST)
    String deleteTask(@RequestParam("id") String id,
                      HttpServletResponse response, @PathVariable("taskId") String taskId) throws IOException {
        taskService.deleteTask(id);
        return "redirect:/home/task/{taskId}/delete";
    }

    @RequestMapping(value = "/task/{taskId}/status", method = RequestMethod.POST)
    String swith(@RequestParam("id") String id,
                 HttpServletResponse response,
                 @PathVariable("taskId") String taskId) throws IOException {
        taskService.switchView(id);
        return "redirect:/home/task/{taskId}/status";
    }

    @RequestMapping(value = "task/details", method = RequestMethod.GET)
    String about(@RequestParam("id") String id, ModelMap modelMap) {
        modelMap.addAttribute("task", taskService.getTaskById(id));
        return "aboutTask";
    }
}
