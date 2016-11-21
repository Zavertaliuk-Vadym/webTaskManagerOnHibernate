package dao;

import model.ListTask;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by employee on 11/17/16.
 */
public class ListDAO {

    private Session session;

    public ListDAO(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public List<ListTask> getAllListTasks() {
        Criteria criteria = session.createCriteria(ListTask.class);
        List<ListTask> listTaskses = (List<ListTask>) criteria.list();
        return listTaskses;
    }
}
