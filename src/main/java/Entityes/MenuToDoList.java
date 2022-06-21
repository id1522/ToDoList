package Entityes;

import com.company.TodoRep.RepositoryLists;
import com.company.TodoRep.RepositoryTasks;

import java.util.Scanner;

public class MenuToDoList {

    private final Scanner sc = new Scanner(System.in);
    private int COUNT;

    public MenuToDoList() {
    }

    public void run() {

        System.out.println("Hello! Welcome to App 'ToDoList' :");
        showToDoList();
        boolean quit = false;
        String todoMenu = """
                1. Display ToDoList
                2. Add new List
                3. Delete List
                4. Select List
                5. Quit
                """;
        while (!quit) {

            Scanner input = new Scanner(System.in);
            System.out.println(todoMenu);
            System.out.println("Enter the number");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> showToDoList();
                case 2 -> createList();
                case 3 -> deleteList();
                case 4 -> selectList().runMenuTask();
                case 5 -> quit = true;

            }
        }
    }

    private void showToDoList() {
        System.out.println("This is your ToDoList : ");
        RepositoryLists repl = new RepositoryLists();
        RepositoryTasks rept = new RepositoryTasks();

        for (Lists o : repl.getAll()) {
            COUNT = o.getId();
            int a = 0;
            for (Tasks task : rept.getAll()) {
                if (task.getListId() == o.id) {
                    a++;
                }
            }
            System.out.println("id: " + o.getId() + " Topic: " + o.getTopic() + " Tasks: " + " " + a);
        }

    }

    private void createList() {
        COUNT++;
        RepositoryLists repl = new RepositoryLists();
        System.out.println(" Enter topic: ");
        String namList = sc.nextLine();
        Lists l = new Lists();
        l.setId(COUNT);
        l.setTopic(namList);

        System.out.println(" ToDoList: new topic " + namList + " added! ");
        repl.getAdd(l);
    }


    private void deleteList() {
        System.out.println(" Enter id topic ");
        int id = sc.nextInt();
        RepositoryLists repl = new RepositoryLists();
        for (Lists o : repl.getAll()) {
            if (o.getId() == id) {
                repl.Delete(o);
            }else{
                System.out.println(" Invalid id ! Еry again! ");
            }
            System.out.println(" topic deleted ");
        }
    }


    private Lists selectList() {
        System.out.println(" Please enter Name of List to select ");
        int idList = sc.nextInt();
        RepositoryLists repl = new RepositoryLists();
        Lists list = new Lists() ;
        for (Lists o : repl.getAll()) {
            if (o.getId() == idList) {
                list.setId(o.getId());
                list.setTopic(o.getTopic());
                System.out.println(" ToDoList: you select topic " + o.getTopic());
                break;
            }
        }
        return list;
    }
}
