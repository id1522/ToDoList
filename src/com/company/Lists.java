package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lists {
    String idList;
    String nameList;
    List<Task> tasks = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public Lists() {
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public void runMenuTask() {
        boolean quitMenu = false;

        String menuItem = ("""
                1. Add Task
                2. Delete Task
                3. Change Task
                4. Mark Task as completed
                5. Quit ToDo Menu
                """);


        while (!quitMenu) {

            Scanner input = new Scanner(System.in);
            System.out.println(menuItem);
            System.out.println("Please enter Action for Task: ");
            int choice = input.nextInt();
            switch (choice) {
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
        System.out.println("Please enter task:");
        String task = sc.nextLine();


        Task t = new Task();
        t.setId(idList);
        t.setTask(task);
        t.setDone(false);
        tasks.add(t);
        System.out.println("New Task: " + task + " created!");
    }

    public void deleteTask() {
        for (Task t : tasks) {
            System.out.println("ID " + t.getId() + " Task " + t.getTask());
        }
        System.out.println("Please enter task name to delete");
        String taskToDel = sc.nextLine();
        for (Task t : tasks) {
            if (t.getTask().equals(taskToDel)) {
                tasks.remove(t);
                System.out.println("Task deleted! ");
                break;
            } else {
                System.out.println("Invalid Task! Еry again! ");
            }
        }
    }

    public void changeTask() {
        System.out.println("Write Task to change and enter new Task: ");
        String taskToChange = sc.nextLine();
        for (Task t : tasks) {
            if (t.getTask().equals(taskToChange)) {
                tasks.set(tasks.indexOf(t), new Task(idList, sc.nextLine(), false));
                System.out.println("Task changed! ");
                break;
            } else {
                System.out.println("Invalid Task! Еry again! ");
            }
        }
    }

    public void markCompletedTask() {
        System.out.println("Please enter task name to mark it as completed");
        String taskCompleted = sc.nextLine();
        for (Task o : tasks) {
            if (o.getTask().equals(taskCompleted)) {
                o.setDone(true);
                break;
            } else {
                System.out.println("Invalid Task! Еry again! ");
            }
        }
    }
    @Override
    public String toString() {
        return "Lists{" +
                "idList='" + idList + '\'' +
                ", nameList='" + nameList + '\'' +
                ", tasks=" + tasks +
                ", sc=" + sc +
                '}';
    }
}


