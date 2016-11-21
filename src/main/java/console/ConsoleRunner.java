package console;

import dao.ListDAO;
import model.ListTask;
import model.Task;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public class ConsoleRunner {

    private SessionFactory sessionFactory;
    private ListDAO listDAO;

    public ConsoleRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        viewAllTasks();
    }

    private void viewAllTasks() {
        listDAO = new ListDAO(sessionFactory);
        List<ListTask> list = listDAO.getAllListTasks();
        for (ListTask listTask : list) {
            System.out.println(listTask.getList_id() + ") " + listTask.getList_name());
            for (Task task : listTask.getTask()) {
                System.out.println("      " + task.getId() + "    " + task.getTitle());
            }
        }
    }
}
