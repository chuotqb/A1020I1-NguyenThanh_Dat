package models.services;

import models.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
     boolean insertUser(User user) throws SQLException;
     User selectUser(int id);
     User findByCountry(String name);
     List<User> selectAllUsers();
     boolean deleteUser(int id) throws SQLException;
     boolean  updateUser(User user) throws SQLException;
     User getUserById(int id);
     void insertUserStore(User user) throws SQLException;
     void addUserTransaction(User user, int[] permision);
     void insertUpdateWithoutTransaction();
     void insertUpdateUseTransaction();
}
