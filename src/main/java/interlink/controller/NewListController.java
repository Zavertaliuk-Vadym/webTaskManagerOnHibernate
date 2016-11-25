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
@RequestMapping(value = "/newList")
public class NewListController {

    @Autowired
    ListService listService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    void newList(@RequestParam("name") String name,
                  HttpServletResponse response
    ) throws IOException {
        listService.addNewList(name);
        response.sendRedirect("home");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    String addlist() throws IOException {
        return "add_list";
    }

}
