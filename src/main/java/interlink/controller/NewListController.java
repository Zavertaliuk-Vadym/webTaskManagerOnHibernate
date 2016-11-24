package interlink.controller;

import interlink.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NewListController {
    @Autowired
    ListService listService;

    @RequestMapping(value = "/newList", method = RequestMethod.POST)
    void newTask(@RequestParam("name") String name,
                  HttpServletResponse response
    ) throws IOException {
        listService.addNewList(name);
        response.sendRedirect("home");
    }
}
