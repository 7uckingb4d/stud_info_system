import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class repository {
    // VARIABLES
    private Connection conn;
    private String DB_URL = "jdbc:sqlite:university.db";

    public repository() {
        this.conn = connect();
        createTable();
    }

    private Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS studentInfo ("
                   + "STUDID INTEGER PRIMARY KEY, "
                   + "STUDFNAME TEXT, "
                   + "STUDLNAME TEXT, "
                   + "STUDMNAME TEXT, "
                   + "STUDYEAR INTEGER, "
                   + "STUDSECTION TEXT, "
                   + "STUDPROG TEXT, "
                   + "STUDADDRESS TEXT, "
                   + "STUDEMAIL TEXT, "
                   + "STUDPHONE TEXT"
                   + ");";
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error sa pag-create ng table: " + e.getMessage());
        }
    }

    public void insertStudent(studentInfo s) {
        String sql = "INSERT INTO studentInfo (STUDID, STUDFNAME, STUDLNAME, STUDMNAME, STUDYEAR, STUDSECTION, STUDPROG, STUDADDRESS, STUDEMAIL, STUDPHONE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // MATCHED GETTERS
            pstmt.setInt(1, s.getSTUDID());
            pstmt.setString(2, s.getSTUDFNAME());
            pstmt.setString(3, s.getSTUDLNAME());
            pstmt.setString(4, s.getSTUDMNAME());
            pstmt.setInt(5, s.getSTUDYEAR());
            pstmt.setString(6, s.getSTUDSECTION());
            pstmt.setString(7, s.getSTUDPROG());
            pstmt.setString(8, s.getSTUDADDRESS());
            pstmt.setString(9, s.getSTUDEMAIL());
            pstmt.setString(10, s.getSTUDPHONE());
            
            pstmt.executeUpdate();
            System.out.println("Student Saved sa Database!");
        } catch (SQLException e) { 
            System.out.println("Error sa DB Insert: " + e.getMessage()); 
        }
    }
    public List<studentInfo> getAllStudents() {
        List<studentInfo> studentList = new ArrayList<>();
        String sql = "SELECT * FROM studentInfo";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                // Binubuo ulit yung object mula sa database gamit ang Builder
                studentInfo s = new studentInfo.StudentBuilder()
                        .setSTUDID(rs.getInt("STUDID"))
                        .setSTUDFNAME(rs.getString("STUDFNAME"))
                        .setSTUDLNAME(rs.getString("STUDLNAME"))
                        .setSTUDMNAME(rs.getString("STUDMNAME"))
                        .setSTUDYEAR(rs.getInt("STUDYEAR"))
                        .setSTUDSECTION(rs.getString("STUDSECTION"))
                        .setSTUDPROG(rs.getString("STUDPROG"))
                        .setSTUDADDRESS(rs.getString("STUDADDRESS"))
                        .setSTUDEMAIL(rs.getString("STUDEMAIL"))
                        .setSTUDPHONE(rs.getString("STUDPHONE"))
                        .BuildStudent();
                
                studentList.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error sa pagkuha ng data: " + e.getMessage());
        }
        
        return studentList;
    }
}
