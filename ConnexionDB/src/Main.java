import com.company.DbFunctions;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception{
        DbFunctions db = new DbFunctions();
        Connection con = db.connectionDb("tutoDb", "postgres", "092000The");
//        db.createTable(con, "employee");
//        db.insert_row(con, "employee", "Jason", "USA");
//        db.insert_row(con, "employee", "Rosette", "Italy");
//        db.update_name(con, "employee", "Jean", "Mark");
//        db.update_address(con, "employee", "Congo", "Canada");
        db.search_by_name(con, "employee", "Rosette");
//        db.read_data(con, "employee");

    }
}