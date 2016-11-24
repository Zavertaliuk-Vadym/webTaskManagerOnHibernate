package interlink.service;

import interlink.dao.ListDAO;
import interlink.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskDAO dao;

    public void addNewTask(String title, String details, int listId, String currentDay) {
        dao.addNewTask(title, details, listId, currentDay);
    }

    public void deleteTask(String id){
        dao.deleteTask(id);
    }
}
