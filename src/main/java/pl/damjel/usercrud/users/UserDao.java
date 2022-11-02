package pl.damjel.usercrud.users;

import org.mindrot.jbcrypt.BCrypt;
import pl.damjel.usercrud.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String INSERT_USER = "INSERT INTO users (first_name, last_name, email, phone, city, zip_code, street, street_number, pass) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_SHOW_USERS = "SELECT id FROM users;";
    private static final String QUERY_SHOW_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
    private static final String UPDATE_USER_BY_ID = "UPDATE users\n" +
            "SET first_name = ?, last_name = ?, email = ?, phone = ?, city = ?, zip_code = ?, " +
            "street = ?, street_number = ?\n" +
            "WHERE id = ?;";
    private static final String UPDATE_USER_PASS_BY_ID = "UPDATE users\n" +
            "SET pass = ?\n" +
            "WHERE id = ?;";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?;";

    public String hashPassword(String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }

    public Boolean checkPass(int userId, String enteredPass) {
        User user = readUser(userId);
        return BCrypt.checkpw(enteredPass, user.getPass());
    }

    public User createUser(User user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER/*, Statement.RETURN_GENERATED_KEYS*/)) {
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setString(6, user.getZipCode());
            preparedStatement.setString(7, user.getStreet());
            preparedStatement.setString(8, user.getStreetNumber());
            preparedStatement.setString(9, hashPassword(user.getPass()));
            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            while (resultSet.next()) {
//                user.setId(resultSet.getInt("id"));
//            }
//            resultSet.close();
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public User readUser(int id) {
        User user = new User();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SHOW_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rsUser = preparedStatement.executeQuery();
            while (rsUser.next()) {
                user.setId(rsUser.getInt(1));
                user.setFirst_name(rsUser.getString(2));
                user.setLast_name(rsUser.getString(3));
                user.setEmail(rsUser.getString(4));
                user.setPhone(rsUser.getString(5));
                user.setCity(rsUser.getString(6));
                user.setZipCode(rsUser.getString(7));
                user.setStreet(rsUser.getString(8));
                user.setStreetNumber(rsUser.getString(9));
                user.setPass(rsUser.getString(10));
            }
            rsUser.close();
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SHOW_USERS);
             ResultSet rsUser = preparedStatement.executeQuery()) {
            while (rsUser.next()) {
                User user = readUser(rsUser.getInt("id"));
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void updateUser(User user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID)) {
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setString(6, user.getZipCode());
            preparedStatement.setString(7, user.getStreet());
            preparedStatement.setString(8, user.getStreetNumber());
            preparedStatement.setInt(9, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Boolean updateUserPass(int id, String oldPass, String newPass) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PASS_BY_ID)) {
            if (checkPass(id, oldPass) && !checkPass(id, newPass)) {
                preparedStatement.setString(1, hashPassword(newPass));
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void deleteUser(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
