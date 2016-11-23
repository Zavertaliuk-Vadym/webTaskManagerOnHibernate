package interlink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by employee on 11/23/16.
 */
@Controller
public class MyController {

    @RequestMapping("/")
    String index() {
        return "index1.jsp";
    }
}
