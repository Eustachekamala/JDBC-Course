package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {

    //To create the connection to the database
    public Connection connectionDb(String dbname, String user, String password){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, password);
            if(con != null){
                System.out.println("Connection Established to the -> " + dbname);
            } else {
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    // To create a table in the database
    public void createTable(Connection con, String table_name){
        Statement statement;
        try {
            String query = "create table "+table_name+" (empId SERIAL, name varchar(200), address varchar(200), primary key(empId))";
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // To insert the values into the database
    public void insert_row( Connection con, String table_name, String name, String address){
        Statement statement;
        try {
          String query = String.format("insert into %s(name, address) values('%s', '%s');",table_name, name, address);
          statement = con.createStatement();
          statement.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // To retrieve the data from the database
    public  void read_data(Connection con, String table_name){
        Statement statement;
        ResultSet rt = null;
        try {
            String query = String.format("select * from %s order by empId", table_name);
            statement = con.createStatement();
            rt = statement.executeQuery(query);
            while(rt.next()){
                System.out.print(rt.getString("empId")+ " ");
                System.out.print(rt.getString("name")+ " ");
                System.out.println(rt.getString("address")+ " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // To update a value ine the database
    public void update_name(Connection con, String table_name, String old_name, String new_name){
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name='%s'", table_name, new_name, old_name);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("The name was updated successfully in : " + table_name + " table");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update_address(Connection con, String table_name, String old_address, String new_address){
        Statement statement;
        try {
            String query = String.format("update %s set address='%s' where address='%s'", table_name, new_address, old_address);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("The address was updated successfully in : " + table_name + " table");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //To search by name
    public void search_by_name(Connection con, String table_name, String name){
        Statement statement;
        ResultSet rt = null;
        try {
            String query = String.format("select * from %s where name='%s'", table_name, name);
            statement = con.createStatement();
            rt = statement.executeQuery(query);
            while (rt.next()){
                System.out.print(rt.getString("empId")+ " ");
                System.out.print(rt.getString("name")+ " ");
                System.out.println(rt.getString("address")+ " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}