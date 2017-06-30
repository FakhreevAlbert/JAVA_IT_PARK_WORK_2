package dao;


import java.sql.*;


public class Main2 {
    public static void main(String[] args) {

        // интерфейс для создания подключения к БД
        String databaseUrl = "jdbc:postgresql://localhost:5432/FAKHREEV_BD";
        String databaseUsername = "postgres";
        String databasePassword = "J8PFekZS";
        try {
            // создаем подключение к БД

            Connection connection =
                    DriverManager
                            .getConnection(databaseUrl, databaseUsername, databasePassword);

                PreparedStatement statement = connection.prepareStatement("SELECT * FROM humans WHERE id > 0");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname"));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
