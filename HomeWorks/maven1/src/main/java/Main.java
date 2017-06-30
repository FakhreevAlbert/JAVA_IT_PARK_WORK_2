
import dao.ApartmentDao;
import dao.ApartmentDaoFileBasedImpl;
import dao.HumanDao;
import dao.HumanDaoFileBasedImpl;
import utils.FileDaoTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static String databaseUrl = "jdbc:postgresql://localhost:5432/FAKHREEV_BD";
    static String databaseUsername = "postgres";
    static String databasePassword = "J8PFekZS";


    public static void main(String[] args) {
        try {

            Connection connection =
                    DriverManager
                            .getConnection(databaseUrl, databaseUsername, databasePassword);
            ApartmentDao apartmentDao = new ApartmentDaoFileBasedImpl(databaseUrl, databaseUsername,
                    databasePassword);

            HumanDao humanDao = new HumanDaoFileBasedImpl(databaseUrl, databaseUsername,
                    databasePassword);
            FileDaoTemplate template = new FileDaoTemplate(databaseUrl, databaseUsername,
                    databasePassword);
            humanDao.findAll();
            apartmentDao.findAll();



        } catch (SQLException e) {
            System.err.println("Ошибка подключения");
            e.printStackTrace();
        }

    }

    }

