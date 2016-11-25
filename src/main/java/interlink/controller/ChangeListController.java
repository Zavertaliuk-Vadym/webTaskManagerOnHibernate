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
@RequestMapping(value = "/changeList")
public class ChangeListController {
    @Autowired
    TaskService taskService;

    @Autowired
    ListService listService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    void changeTask(@RequestParam("id") String id,
                      @RequestParam("name") String name,
                      HttpServletResponse response) throws IOException {
        listService.updateList(id, name);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    String aboutTask(@RequestParam("id") String id,
                     ModelMap modelMap) throws IOException {
        modelMap.addAttribute("list", listService.getListById(id));
        return "changeList";
    }
}
