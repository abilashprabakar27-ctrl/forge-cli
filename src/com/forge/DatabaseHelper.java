package com.forge
import java.sql.Connection
import java.sql.DriverManager
import java.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
public class DatabaseHelper {
    private static final String DB_URL="jdbc:sqlite:db/snippets.db";
    @return
    @throws
    public static Connection connect() throws SQLException {
        return DriverManager.getconnection(URL);
    }
    public static void intializeDatabase(){
        string sql="CREATE TABLE IF NOT EXISTS snippets ("+"
        id INTEGER PRIMARY KEY AUTOINCREMENT,"+
        "title TEXT NOT NULL,"+
        "language TEXT NOT NULL,"+
        "body TEXT NOT NULL,"+
        ")";
        try(Connection conn=connect(); Statement stmt=conn.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e){
            System.err.println("Database intialization failed:"+e.getMessage());

        }
        }
    public static void SaveSnippet(string title,string language,string body){
        string sql="INSERT INTO snippets(title,language,body) VALUES(?,?,?)";
        try(Connection conn=connect(); PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,title);
            pstmt.setString(2,language);
            pstmt.setString(3,body);
            pstmt.executeUpdate();
        } catch (SQLException e){
            System.err.println("Failed to save snippet:"+e.getMessage());

    }
    }
}