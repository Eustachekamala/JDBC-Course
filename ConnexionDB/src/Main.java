import com.company.DbFunctions;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception{
        DbFunctions db = new DbFunctions();
        Connection con = db.connectionDb("yourDbName", "postgres", "yourPassword");
//        db.createTable(con, "employee");
//        db.insert_row(con, "employee", "Jared", "USA");
//        db.insert_row(con, "employee", "Mark", "Italy");
//        db.update_name(con, "employee", "Jean", "Mark");
//        db.update_address(con, "employee", "Congo", "Canada");
//        db.search_by_name(con, "employee", "Rosette");
//        db.search_by_id(con, "employee", 2);
//        db.delete_row_by_name(con, "employee", "Mark");
//        db.delete_row_by_id(con, "employee", 3);
//        db.read_data(con, "employee");
//        db.delete_table(con, "employee");

    }
}