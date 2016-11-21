package model;


import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task implements java.io.Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id",insertable = false,updatable = false)
    private ListTask listTask;

    @Column(name = "title")
    private String title;

    @Column(name = "details")
    private String details;

    @Column(name = "view")
    private Boolean view ;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "currentDay")
    private String currentDay;

    @Column(name = "list_id")
    private Integer listId;

    public Task() {

    }

    public Task(ListTask listTask) {
        this.listTask = listTask;
    }

    public Task(Integer listId, String title, String details, Boolean view, String startTime, String currentDay) {
        this.listId = listId;
        this.title = title;
        this.details = details;
        this.view = view;
        this.startTime = startTime;
        this.currentDay = currentDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int taskId) {
        this.id = taskId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Column(name = "view", columnDefinition = "tinyint default false")
    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    @Column(name = "startTime")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Column(name = "currentDay")
    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }


    public ListTask getListTask() {
        return listTask;
    }

    public void setListTask(ListTask listTask) {
        this.listTask = listTask;
    }

    public Boolean getView() {
        return view;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }
}