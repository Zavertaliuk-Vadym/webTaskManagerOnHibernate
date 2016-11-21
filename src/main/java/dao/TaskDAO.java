package dao;

import model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/16/16.
 */
public class TaskDAO {

    private Session session;

    public TaskDAO(SessionFactory factory) {
        this.session = factory.openSession();
    }

    public List<Task> getAllTasks() {
        Criteria criteria = session.createCriteria(Task.class);
        List<Task> list = (List<Task>) criteria.list();
        session.close();
        return list;
    }

    public void addNewTask(String title, String details, int listId, String currentDay) {
        session.beginTransaction();
        Task task = new Task(listId, title, details, Boolean.FALSE, new Date(System.currentTimeMillis()).toString(), currentDay);
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteTask(String taskId) {
        session.beginTransaction();
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        session.delete(task);
        session.getTransaction().commit();
        session.close();
    }

    public void switchStatusTask(String taskId) {
        session.beginTransaction();
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        task.setView(!task.getView());
        session.update(task);
        session.getTransaction().commit();
        session.close();
    }

    public Task getTaskById(String taskId) {
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", parseInt(taskId)))
                .uniqueResult();
        return task;
    }
}
