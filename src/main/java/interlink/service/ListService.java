package interlink.service;

import interlink.dao.ListDAO;
import interlink.model.ListTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
