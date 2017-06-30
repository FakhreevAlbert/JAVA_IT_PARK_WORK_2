package dao;

import models.Apartment;

import java.sql.*;


public class ApartmentDaoFileBasedImpl implements ApartmentDao {
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;

    public ApartmentDaoFileBasedImpl(String databaseUrl, String databaseUsername,
                                     String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;


        try {
            Connection connection = DriverManager.getConnection(databaseUrl,
                    databaseUsername, databasePassword);


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

        @Override
        public void findByNumber ( int number){
            try {
                Connection connection = DriverManager.getConnection(databaseUrl,
                        databaseUsername, databasePassword);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM apartments WHERE apartments.number =" + number
                );

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    // вытаскиваем из resultSet столбец name
                    System.out.println(resultSet.getString("number") + " " +
                            resultSet.getString("area") + " " +
                    resultSet.getString("ownerId"));
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void findByArea ( int area){
            try {
                Connection connection = DriverManager.getConnection(databaseUrl,
                        databaseUsername, databasePassword);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM apartments WHERE apartments.area =" + area
                );

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    System.out.println(resultSet.getString("number") + " " +
                            resultSet.getString("area") + " " +
                            resultSet.getString("ownerId"));
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }




        }
    public void findAll(){
        try {
            Connection connection = DriverManager.getConnection(databaseUrl,
                    databaseUsername, databasePassword);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM apartments"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getString("number") + " " +
                        resultSet.getString("area") + " " +
                        resultSet.getString("ownerId"));
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

        @Override
        public int save (Apartment model){
            return 0;
        }

        @Override
        public Apartment find (int id) {
            try {
                Connection connection = DriverManager.getConnection(databaseUrl,
                        databaseUsername, databasePassword);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM apartments WHERE apartments.id =" + id
                );

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    System.out.println(resultSet.getString("number") + " " +
                            resultSet.getString("area") + " " +
                            resultSet.getString("ownerId"));
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        public void update (Apartment model){

        }

        @Override
        public void delete ( int id){

        }


    }

