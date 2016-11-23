package interlink.dao;

import interlink.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class TaskDAO {

    @Autowired
    SessionFactory sessionFactory;

//    private Session session;

//    public TaskDAO(SessionFactory factory) {
//        this.sessionFactory = factory.openSession();
//    }

    public List<Task> getAllTasks() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        List<Task> list = (List<Task>) criteria.list();
//        session.close();
        return list;
    }

    public void addNewTask(String title, String details, int listId, String currentDay) {
//        session.beginTransaction();
        sessionFactory.getCurrentSession();
        Task task = new Task(listId, title, details, Boolean.FALSE, new Date(System.currentTimeMillis()).toString(), currentDay);
        sessionFactory.getCurrentSession().save(task);
        sessionFactory.getCurrentSession().getTransaction().commit();
//        session.close();
    }

    public void deleteTask(String taskId) {
//        session.beginTransaction();
//        sessionFactory.getCurrentSession();
        Task task = (Task)  sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        sessionFactory.getCurrentSession().delete(task);
        sessionFactory.getCurrentSession().getTransaction().commit();
//        session.close();
    }

    public void switchStatusTask(String taskId) {
//        session.beginTransaction();
        Task task = (Task)  sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        task.setView(!task.getView());
        sessionFactory.getCurrentSession().update(task);
        sessionFactory.getCurrentSession().getTransaction().commit();
//        session.close();
    }

    public Task getTaskById(String taskId) {
        Task task = (Task)  sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId)))
                .uniqueResult();
        return task;
    }
}
