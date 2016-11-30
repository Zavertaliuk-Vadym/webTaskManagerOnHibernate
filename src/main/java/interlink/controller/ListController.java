package interlink.controller;


import interlink.service.ListService;
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
public class ListController {
    @Autowired
    ListService listService;

    @RequestMapping(value = "/list/{listId}/update", method = RequestMethod.POST)
    String changeTask(@RequestParam("id") String id,
                      @RequestParam("name") String name,
                      HttpServletResponse response,
                      @PathVariable("listId") String listId) throws IOException {
        listService.updateList(id, name);
        return "redirect:/home/list/{listId}/update";
    }

    @RequestMapping(value = "/list/{listId}/view", method = RequestMethod.GET)
    String viewList(@RequestParam("id") String id,
                    ModelMap modelMap,
                    @PathVariable("listId") String listId) throws IOException {
        modelMap.addAttribute("list", listService.getListById(id));
        return "changeList";
    }

    @RequestMapping(value = "/newList", method = RequestMethod.GET)
    String addlist() throws IOException {
        return "add_list";
    }

    @RequestMapping(value = "/list/{listId}/delete", method = RequestMethod.POST)
    String deleteList(@RequestParam("id") String id,
                      HttpServletResponse response,
                      @PathVariable("listId") String listId) throws IOException {
        listService.deleteList(id);
        return "redirect:/home/list/{listId}/delete";
    }
}
