package dao;



import models.Human;

import java.sql.*;


public class HumanDaoFileBasedImpl implements HumanDao{

    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;



    public HumanDaoFileBasedImpl(String databaseUrl, String databaseUsername,
                                 String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    public int save(Human human) {



        return 0;
    }


    public Human find(int id) {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl,
                    databaseUsername, databasePassword);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM humans WHERE humans.id =" + id
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("surname"));
            }


        } catch (SQLException e) {
            e.printStackTrace();


        }
        return null;
    }


    public void update(Human model) {

    }


    public void delete(int id) {

    }

    @Override
    public void findAll() {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl,
                    databaseUsername, databasePassword);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM humans"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("surname") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean isExistById(int humanId) {
        return false;
    }


    @Override
    public void findByName(String name) {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl,
                    databaseUsername, databasePassword);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM humans WHERE name = ?"
            );
            statement.setString(1,name);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("surname"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void findBySurname(String surname) {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl,
                    databaseUsername, databasePassword);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM humans WHERE surname = ?"
            );
            statement.setString(1,surname);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("surname"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    }



