package interlink.service;

import interlink.dao.TaskDAO;
import interlink.model.Task;
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

    public void switchView(String id) {
        dao.switchStatusTask(id);
    }

    public Task getTaskById(String id) {
        Task task =dao.getTaskById(id);
        return task;
    }

    public void updateTask(String taskId, String title, String details, String startTime, String endTime) {
        dao.updateTask(taskId,title,details,startTime,endTime);
    }
}
