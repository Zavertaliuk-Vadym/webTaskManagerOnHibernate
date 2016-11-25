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
public class HomeController {

    @Autowired
    TaskService taskService;

    @Autowired
    ListService listService;

    @RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
    void deleteTask(@RequestParam("task") String id,
                HttpServletResponse response) throws IOException {
        taskService.deleteTask(id);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "/deleteList", method = RequestMethod.POST)
    void deleteList(@RequestParam("task") String id,
                HttpServletResponse response) throws IOException {
        listService.deleteTask(id);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    void swith(@RequestParam("task") String id,
               HttpServletResponse response) throws IOException {
        taskService.switchView(id);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    String about(@RequestParam("task") String id, ModelMap modelMap) {
        modelMap.addAttribute("task", taskService.getTaskById(id));
        return "aboutTask";
    }
}
