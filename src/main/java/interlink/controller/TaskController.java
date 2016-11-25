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
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ListService listService;

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    String aboutTask(@RequestParam("id") String id,
                     ModelMap modelMap) throws IOException {
        modelMap.addAttribute("task", taskService.getTaskById(id));
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "change";
    }
}
