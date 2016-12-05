package interlink.rest;

import interlink.todolist.model.Task;
import interlink.todolist.model.TasksList;
import interlink.todolist.service.ListService;
import interlink.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskRestController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "")
    @ResponseBody
    Task getAllLists(){
        return taskService.getTaskById("21");
    }
}