package interlink.controller;

import interlink.service.ListService;
import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NewTaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ListService listService;

    @RequestMapping(value = "/newTask", method = RequestMethod.GET)
    String addTask(ModelMap modelMap) throws IOException {
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "add_task";
    }

    @RequestMapping(value = "task/newTask", method = RequestMethod.POST)
    String newTask(@RequestParam("new_task") String title,
                 @RequestParam("new_description") String description,
                 @RequestParam("new_list") Integer listId,
                 @RequestParam("new_startTime") String startTime,
                 @RequestParam("new_currentTime") String currentTime, HttpServletResponse response
    ) throws IOException {
        taskService.addNewTask(title, description, listId, currentTime, startTime);
        return "redirect:/home/task/newTask";
    }
}
