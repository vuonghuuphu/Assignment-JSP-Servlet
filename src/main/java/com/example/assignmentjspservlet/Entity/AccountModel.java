package com.example.assignmentjspservlet.Entity;

import com.example.assignmentjspservlet.Model.Account;
import util.ConnectionHelper;
import util.SqlConfig;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AccountModel {
    public boolean save(Account account) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            SqlConfig.INSERT_ACCOUNT);
//            username`, `fullname`, `passwordHash`, `salt`, `CreatedAt`, `failureCount`, `Status`, `locktime
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getFullname());
            preparedStatement.setString(3, account.getPasswordHash());
            preparedStatement.setString(4, account.getSalt());
            preparedStatement.setString(5, account.getCreatedAt());
            preparedStatement.setInt(6, account.getStatus());
            // PrepareStatement
            System.out.println(preparedStatement);
            preparedStatement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account findAccountByUsername(String username) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            SqlConfig.SELECT_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1, username);
            // PrepareStatement
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String usernameDatabase = resultSet.getString("username");
                String passwordHash = resultSet.getString("passwordHash");
                String salt = resultSet.getString("salt");
                Account account = new Account();
                account.setUsername(usernameDatabase);
                account.setPasswordHash(passwordHash);
                account.setSalt(salt)
                ;
                account.setFullname(resultSet.getString("fullName"));
                account.setStatus(resultSet.getInt("status"));
                account.setFailureCount(resultSet.getInt("failureCount"));
                account.setCreatedAt(resultSet.getString("createdAt"));
                account.setRole(resultSet.getInt("Role"));
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    if (resultSet.getString("lockTime") != null) {
                        account.setLocktime(LocalDateTime.parse(resultSet.getString("lockTime"), formatter));
                    }
                } catch (DateTimeParseException ex) {
                    System.out.println(ex.getMessage());
                }
                return account;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateLock(String username, Account account) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(
                            SqlConfig.LOCK_ACCOUNT);
            statement.setInt(1, account.getStatus());
            statement.setInt(2, account.getFailureCount());
            statement.setString(3, account.getLocktime().toString());
            statement.setString(4, username);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
