package interlink.controller;

import interlink.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ListController {

    @Autowired
    ListService listService;

    @RequestMapping(value = "/add_task",method = RequestMethod.GET)
    String addTask(ModelMap modelMap) throws IOException {
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "add_task";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    String index(ModelMap modelMap) {
        modelMap.addAttribute("ListTasks", listService.getAllListsWithTasks());
        return "home";
    }
}
