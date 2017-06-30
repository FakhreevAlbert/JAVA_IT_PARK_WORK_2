package utils;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileDaoTemplate {
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;

    public FileDaoTemplate(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;

    }


    public void saveHuman(String name, String surname) {
        try {
            Connection connection =
                    DriverManager
                            .getConnection(databaseUrl, databaseUsername, databasePassword);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO humans (name, surname) VALUES (? , ?)");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void saveApartment(int number, int area, int ownerId){
        try {
            Connection connection =
                    DriverManager
                            .getConnection(databaseUrl, databaseUsername, databasePassword);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO apartments (number, area, ownerid) VALUES (? , ?, ?)");
            statement.setInt(1, number);
            statement.setInt(2, area);
            statement.setInt(3, ownerId);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
