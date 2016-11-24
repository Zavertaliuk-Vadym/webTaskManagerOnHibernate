package interlink.service;

import interlink.dao.ListDAO;
import interlink.dao.TaskDAO;
import interlink.model.ListTask;
import interlink.model.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import java.util.List;

@Service
public class ListService {

    @Autowired
    ListDAO dao;

    public List<ListTask> getAllListsWithTasks() {
        List<ListTask> list = dao.getAllListTasks();
        return list;
    }

    public List<ListTask> getAllLists() {
        List<ListTask> list = dao.getAllLists();
        return list;
    }
}
