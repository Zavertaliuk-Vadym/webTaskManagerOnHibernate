package interlink.dao;

import interlink.model.TasksList;
import interlink.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class ListDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<TasksList> getAllListTasks() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(TasksList.class);
       // criteria.setFetchMode("lists", FetchMode.LAZY);
        List<TasksList> tasksList = (List<TasksList>) criteria.list();
        for (TasksList task : tasksList) {
            task.getList_name();
            for (Task task1 : task.getTasks()) {
                task1.getTitle();
            }
        }
        return tasksList;
    }

    public List<TasksList> getAllLists() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(TasksList.class);
        List<TasksList> tasksList = (List<TasksList>) criteria.list();
        return tasksList;
    }

    public void addNewList(String name) {
        TasksList tasksList = new TasksList(name);
        sessionFactory.getCurrentSession().save(tasksList);
    }

    public void delete(String id) {
        TasksList task = (TasksList) sessionFactory.getCurrentSession().createCriteria(TasksList.class)
                .add(eq("id", parseInt(id))).uniqueResult();
        sessionFactory.getCurrentSession().delete(task);
    }
}
