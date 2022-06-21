package com.company.TodoRep;

import DataBase.DTBConfig;
import Entityes.Tasks;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryTasks {

            public void getAdd( Tasks task){
            try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Nikita5767");
                 Statement stat = con.createStatement()) {
                String sql = ("INSERT INTO \"Tasks\" VALUES  ("  + task.getId() + ","+ task.getTask() +","+task.isStatus() +","+ task.getListId() + ");");
                stat.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public List<Tasks> getAll() { //вывести всех обьектов для выбранной табл на экран
            List<Tasks> todos = new ArrayList<>();
            try {
                Connection con = DriverManager.getConnection(DTBConfig.URL, DTBConfig.USER, DTBConfig.PASSWORD);
                Statement stat = con.createStatement();
                ResultSet rs = stat.executeQuery("SELECT * FROM \"Tasks\" order by id;");
                while (rs.next()) {
                    Tasks todo = new  Tasks();
                    todo.setId(rs.getInt("Id"));
                    todo.setTask(rs.getString("Task"));
                    todo.setStatus(rs.getBoolean("Status"));
                    todo.setListId(rs.getInt("ListId"));
                    todos.add(todo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return todos;
        }

        public Tasks  getOne(long id) {// выведет то что собираемся добавить в будущем
            Tasks todo = new Tasks();
            try {
                Connection con = DriverManager.getConnection(DTBConfig.URL, DTBConfig.USER, DTBConfig.PASSWORD);
                Statement stat = con.createStatement();
                ResultSet rs = stat.executeQuery("SELECT * FROM \"Tasks\" where Id = " + id + ";");
                while (rs.next()) {
                    todo.setId(rs.getInt("Id"));
                    todo.setTask(rs.getString("Task"));
                    todo.setStatus(rs.getBoolean("Status"));
                    todo.setTask(rs.getString("ListId"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return todo;
        }

        public void save(Tasks task) {
            changeDBEntity("INSERT INTO \"Tasks\" VALUES = ("  + task.getId() + ",'"+ task.getTask() + "');");
        }

        public void update(Tasks task) {
            changeDBEntity("UPDATE \"Tasks\" SET task = "+"'"+ task.getTask()+"'" +" WHERE id = " + task.getId() + ";");
        }
    public void updateBoolean(Tasks task) {
        changeDBEntity("UPDATE  \"Tasks\" SET status = NOT" + "'" + task.isStatus() +"'" + "WHERE id ="+ task.getId() + ";");
    }

        public void Delete(Tasks task) {
            changeDBEntity("DELETE FROM  \"Tasks\" WHERE id = "+ task.getId() + ";");
        }

        private void changeDBEntity(String sql) {
            try (Connection con = DriverManager.getConnection(DTBConfig.URL, DTBConfig.USER, DTBConfig.PASSWORD);
                 Statement stat = con.createStatement()) {
                stat.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

