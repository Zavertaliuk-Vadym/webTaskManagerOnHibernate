package interlink.controller;

import interlink.service.ListService;
import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping(value = "/changeTask")
public class ChangeTaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ListService listService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    String changeTask(@RequestParam("taskId") String taskId,
                      @RequestParam("title") String title,
                      @RequestParam("details") String details,
                      @RequestParam("startTime") String startTime,
                      @RequestParam("endTime") String endTime,
                      @RequestParam("new_list") String listId,
                      ModelMap modelMap) {
            taskService.updateTask(taskId, title, details, startTime, endTime,listId);
            modelMap.addAttribute("task", taskService.getTaskById(taskId));
       return "aboutTask";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    String aboutTask(@RequestParam("id") String id,
                     ModelMap modelMap) throws IOException {
        modelMap.addAttribute("task", taskService.getTaskById(id));
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "changeTask";
    }
}