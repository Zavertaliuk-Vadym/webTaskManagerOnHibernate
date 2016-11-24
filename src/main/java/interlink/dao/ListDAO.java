package interlink.dao;

import interlink.model.ListTask;
import interlink.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ListDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<ListTask> getAllListTasks() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(ListTask.class);
        List<ListTask> listTask = (List<ListTask>) criteria.list();
        for (ListTask task:listTask){
            task.getList_name();
            for (Task task1 :task.getTask()){
                task1.getTitle();
            }
        }
        return listTask;
    }

    public List<ListTask> getAllLists() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(ListTask.class);
        List<ListTask> listTask = (List<ListTask>) criteria.list();
        return listTask;
    }
}
