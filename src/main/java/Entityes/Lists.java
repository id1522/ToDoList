package Entityes;

import com.company.TodoRep.RepositoryTasks;

import java.util.Scanner;

public class Lists {

    int id;
    String topic;
    private final Scanner sc = new Scanner(System.in);
    private int COUNT;

    public Lists() {
    }

    public void runMenuTask() {
        System.out.println("Tasks for this Topic: ");
        showTaskList();

        boolean quitMenu = false;

        String menuItem = ("""
                1. Add Task
                2. Delete Task
                3. Change Task
                4. Mark Task as completed
                5. Quit ToDo Menu
                0. Show List Tasks
                """);


        while (!quitMenu) {

            Scanner input = new Scanner(System.in);
            System.out.println(menuItem);
            System.out.println("Please enter Action for Task: ");
            int choice = input.nextInt();
            switch (choice) {
                case 0 -> showTaskList();
                case 1 -> createTask();
                case 2 -> deleteTask();
                case 3 -> changeTask();
                case 4 -> markCompletedTask();
                case 5 -> quitMenu = true;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public void createTask() {
        COUNT++;
        System.out.println("Please enter task:");
        String task = sc.nextLine();

        Tasks t = new Tasks();
        t.setId(COUNT);
        t.setTask(task);
        t.setStatus(false);
        t.setListId(id);

        System.out.println("New Task: " + task + " created!");
        RepositoryTasks rept = new RepositoryTasks();
        rept.getAdd(t);

    }

    public void deleteTask() {
        System.out.println("Please write task to delete");
        int taskToDel = sc.nextInt();
        RepositoryTasks rept = new RepositoryTasks();
        for (Tasks t : rept.getAll()) {
            if (t.getId() == taskToDel) {
                rept.Delete(t);
            }
        }
    }


    public void changeTask() {
        System.out.println("Write Task to change and enter new Task: ");
        int taskToChan = sc.nextInt();
        RepositoryTasks rept = new RepositoryTasks();
        for (Tasks t : rept.getAll()) {
            if (t.getId() == taskToChan) {
                System.out.println("Write new Task: ");
                Scanner sc = new Scanner(System.in);
                String taskToChange = sc.nextLine();
                t.setTask(taskToChange);
                rept.update(t);
                System.out.println("Task changed! ");
            }
        }
    }

    public void markCompletedTask() {
        System.out.println("Please write task to mark it as completed");
        int taskToMark = sc.nextInt();
        RepositoryTasks rept = new RepositoryTasks();
        for (Tasks t : rept.getAll()) {
            if (t.getId() == taskToMark) {
                rept.updateBoolean(t);
                System.out.println("Status changed! ");
            }
        }
    }
    public void showTaskList(){
        RepositoryTasks rept = new RepositoryTasks();
        for (Tasks o : rept.getAll()) {
            COUNT = o.getId();
           if (o.getListId() == id) {
               System.out.println(" Id: " + o.getId() + " Task: " + o.getTask() + " Status: " + o.isStatus());
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Lists{" +
                "id=" + id +
                ", topic='" + topic +
                '}';
    }
}


