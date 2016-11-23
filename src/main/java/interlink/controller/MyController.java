package interlink.controller;

import interlink.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/home")
    String index(ModelMap modelMap) {
        modelMap.addAttribute("ListTasks",taskService.getAllList());
        return "jsp/home";
    }
}
