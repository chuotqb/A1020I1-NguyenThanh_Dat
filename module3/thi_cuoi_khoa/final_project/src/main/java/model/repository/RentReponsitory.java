package model.repository;

import model.bean.Rent;

import java.sql.SQLException;
import java.util.List;

public interface RentReponsitory {
    boolean insertRent (Rent rent) throws SQLException;
    List<Rent> selectAllRent();
}
