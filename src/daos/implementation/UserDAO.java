package daos.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.UserManagementInterface;
import models.User;

public class UserDAO implements UserManagementInterface{
  private Connection connection;

  public UserDAO(Connection connection) {
    this.connection = connection;
  }

  @Override
  public boolean login(String username, String password) {
    String query = "SELECT username FROM tbl_m_user WHERE username = ? AND password = ?";

    try (
      PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, username);
      statement.setString(2, password);

      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return true;
      } else {
        return false;
      }
    } 
    catch (SQLException e) {
      e.getMessage();
      return false;
    }
  }

  @Override
  public User get(int id) {
    User user = null;
    String query = "SELECT u.username, e.first_name, e.last_name, e.email, e.division_id " +
                    "FROM tbl_m_user u " +
                    "JOIN tbl_m_employee e ON u.employee_id = e.id " +
                    "WHERE u.id = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String username = resultSet.getString("username");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            Integer division = resultSet.getInt("division_id");

            user = new User(firstName, lastName, email, division, username, null);
        }
    } catch (SQLException e) {
        e.getMessage();
    }
    return user;
  }
}
