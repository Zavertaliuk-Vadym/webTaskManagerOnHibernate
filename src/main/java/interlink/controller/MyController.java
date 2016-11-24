package interlink.controller;

import interlink.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class MyController {

    @Autowired
    ListService listService;

    @RequestMapping("/add_task")
    String addTask(ModelMap modelMap) throws IOException {
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "add_task";
    }

    @RequestMapping("/home")
    String index(ModelMap modelMap) {
        modelMap.addAttribute("ListTasks", listService.getAllListsWithTasks());
        return "home";
    }


}
