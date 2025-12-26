import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "#Reyazlove1";
        String query = "DELETE FROM employee WHERE id =2;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username , password);
            System.out.println("connection Established successfully");
            Statement stmt = con.createStatement();
            int rowsaffected =  stmt.executeUpdate(query);

            if(rowsaffected>0){
                System.out.println("Deletion  Successfully. "+rowsaffected+" row(s) affected.");
            }else{
                System.out.println("Deletion failed");
            }

            stmt.close();
            con.close();
            System.out.println();
            System.out.println("connection closed successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
