package com.company.TodoRep;

import DataBase.DTBConfig;
import Entityes.Lists;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryLists {

    public void getAdd(Lists list){
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Nikita5767");
             Statement stat = con.createStatement()) {
            String sql = ("INSERT INTO lists VALUES  ("  + list.getId() + ","+ list.getTopic() + ");");
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  List<Lists> getAll() { //вывести всех обьектов для выбранной табл на экран
        List<Lists> todos = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DTBConfig.URL, DTBConfig.USER, DTBConfig.PASSWORD);
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Lists ;");
            while (rs.next()) {
                Lists todo = new Lists();
                todo.setId(rs.getInt("Id"));
                todo.setTopic(rs.getString("Topic"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public Lists getOne(long id) {// выведет то что собираемся добавить в будущем
        Lists todo = new Lists();
        try {
            Connection con = DriverManager.getConnection(DTBConfig.URL, DTBConfig.USER, DTBConfig.PASSWORD);
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Lists where Id = "+ id +";");
            while (rs.next()) {
                todo.setId(rs.getInt("Id"));
                todo.setTopic(rs.getString("Topic"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public void save(Lists list) {
        changeDBEntity("INSERT INTO Task VALUES = ("  + list.getId() + ",'"+ list.getTopic() + "');");
    }

    public void update(Lists list) {
        changeDBEntity("UPDATE Lists" + " SET topic = 'bob' WHERE id = " + list.getId() + ";");
    }

    public void Delete(Lists list) {
        changeDBEntity("DELETE FROM  Lists WHERE id = "+ list.getId() + ";");
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
