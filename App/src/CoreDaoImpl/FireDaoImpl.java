//package CoreDaoImpl;
//
//import CoreDao.FireDao;
//import CorePersistanceData.FireEntity;
//import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class FireDaoImpl implements FireDao {
//
//    private Connection conn;
//    private Statement stmt;
//    private ResultSet rset;
//    final String urlConnection = "jdbc:mysql://localhost:3306/fire";
//    final String usernameMysql = "root";
//    final String passwordMysql = "1234";
//
//    @Override
//    public void saveFireStatus() {
//        if (conn != null){
//            String query = "insert into firearea (are1, are2, are3, are4, are5, are6, eare7, are8, are9, are10, are11, are12, are13, are14, are15, are16, voltage, timefire)"
//                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
//            Int query2 
//            FireEntity fireEntity = new FireEntity();
//            try {
//                PreparedStatement paPreparedStatement = conn.prepareStatement(query);
//                    paPreparedStatement.setString(1,fireEntity.getArea1());
//                    paPreparedStatement.setString(2,fireEntity.getArea2());
//                    paPreparedStatement.setString(3,fireEntity.getArea3());
//                    paPreparedStatement.setString(4,fireEntity.getArea4());
//                    paPreparedStatement.setString(5,fireEntity.getArea5());
//                    paPreparedStatement.setString(6,fireEntity.getArea6());
//                    paPreparedStatement.setString(7,fireEntity.getArea7());
//                    paPreparedStatement.setString(8,fireEntity.getArea8());
//                    paPreparedStatement.setString(9,fireEntity.getArea9());
//                    paPreparedStatement.setString(10,fireEntity.getArea10());
//                    paPreparedStatement.setString(11,fireEntity.getArea12());
//                    paPreparedStatement.setString(12,fireEntity.getArea13());
//                    paPreparedStatement.setString(13,fireEntity.getArea14());
//                    paPreparedStatement.setString(14,fireEntity.getArea15());
//                    paPreparedStatement.setString(15,fireEntity.getArea16());
//                    paPreparedStatement.setString(16,fireEntity.getVoltage());
//                    paPreparedStatement.setString(17,fireEntity.getArea1());
//                    paPreparedStatement.setString(18,fireEntity.getArea1());
//            } catch (SQLException ex) {
//                Logger.getLogger(FireDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
//
//
//        }
//    }
//
//    @Override
//    public Connection connectionMysql() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(urlConnection, usernameMysql, passwordMysql);
//
//        } catch (Exception e) {
//            System.out.println("Failed to load JDBC/ODBC driver.");
//            e.printStackTrace();
//        }
//
//        return conn;
//    }
//
//}
