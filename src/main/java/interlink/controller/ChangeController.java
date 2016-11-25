package interlink.controller;

import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/changeTask", method = RequestMethod.POST)
    String changeTask(@RequestParam("taskId") String taskId,
                      @RequestParam("title") String title,
            @RequestParam("details") String details,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
                      ModelMap modelMap) {
            taskService.updateTask(taskId, title, details, startTime, endTime);
            modelMap.addAttribute("task", taskService.getTaskById(taskId));
       return "about";
    }
}