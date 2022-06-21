package Entityes;

public class Tasks{

    private int id;
    private String task;
    private boolean status;
    private int ListId;

    public Tasks(int id, String task, boolean status,int listId) {
        this.id = id;
        this.task = task;
        this.status = status;
        ListId = listId;
    }

    public Tasks() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getListId() {
        return ListId;
    }

    public void setListId(int listId) {
        ListId = listId;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", status=" + status +
                ", ListId=" + ListId +
                '}';
    }
}

