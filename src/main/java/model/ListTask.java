package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "list")
public class ListTask implements java.io.Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer list_id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listTask")
    private List<Task> task = new ArrayList();

    @Column(name = "name")
    private String list_name;

    public ListTask() {
    }

    public ListTask(String list_name) {
        this.list_name = list_name;
    }

    public ListTask(Integer list_id, String list_name) {
        this.list_id = list_id;
        this.list_name = list_name;
    }


    public ListTask(Integer list_id, String list_name, List<Task> task) {
        this.list_id = list_id;
        this.list_name = list_name;
        this.task = task;
    }

    @Column(name = "id")
    public Integer getList_id() {
        return list_id;
    }

    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }
    @Column(name = "name")
    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }


    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }


}