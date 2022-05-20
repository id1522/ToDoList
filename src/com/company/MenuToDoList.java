package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuToDoList {
    List<Lists> toDoList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    void run() {
System.out.println("Hello! Welcome to App 'ToDoList' :");
        boolean quit = false;
        String todoMenu = """
                1. Display ToDoList
                2. Add new List(topic)
                3. Delete List(topic)
                4. Select List(topic)
                5. Quit
                """;
        while (!quit) {
            Scanner input = new Scanner(System.in);
            System.out.println(todoMenu);
            System.out.println("Please enter number");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> showToDoList();
                case 2 -> createList();
                case 3 -> deleteList();
                case 4 -> selectList().runMenuTask();
                case 5 -> quit = true;
                default -> System.out.println("Invalid entry try again");
            }
        }
    }

    private void showToDoList() {
        System.out.println("This is your ToDoList : ");
        for (Lists i : toDoList) {
            System.out.println("List: " + i.nameList + "Id" + i.getIdList());
            for (Task a : i.tasks) {
                System.out.println(" Id " + a.getId() + " Tasks: " + a.getTask() + " Status: " + a.isDone());
            }
        }
    }

    private void createList() {
        System.out.println("Please enter Id for List: ");
        String idList = sc.nextLine();
        System.out.println("Please enter name List(topic): ");
        String namList = sc.nextLine();

        Lists l = new Lists();
        l.setIdList(idList);
        l.setNameList(namList);
        toDoList.add(l);
        System.out.println("ToDoList: new List " + namList + " added! ");
    }


    private void deleteList() {
        System.out.println("Please enter ToDoList List");
        String nameLis = sc.nextLine();
        for (Lists i : toDoList) {
            if (i.getNameList().equals(nameLis)) {
                toDoList.remove(i);
                System.out.println("ToDoList List " + nameLis + " deleted");
                break;
            } else {
                System.out.println(" Invalid name List! Еry again! ");
            }
        }
    }

    private Lists selectList() {
        System.out.println("Please enter Name of List to select");
        String nList = sc.nextLine();
        Lists list = null;
        for (Lists i : toDoList) {
            if (i.getNameList().equals(nList)) {
                list = toDoList.get(toDoList.indexOf(i));
                System.out.println("ToDoList: you select List " + nList);
                break;
            } else {
                System.out.println(" Invalid name List! Еry again! ");
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "MenuToDoList{" +
                "toDoList=" + toDoList +
                '}';
    }
}
