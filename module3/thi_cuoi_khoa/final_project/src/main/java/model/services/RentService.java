package model.services;

import model.bean.Rent;
import model.bean.StatusRent;
import model.bean.TypeRent;

import java.sql.SQLException;
import java.util.List;

public interface RentService {
    boolean insertRent (Rent rent) throws SQLException;
    List<Rent> selectAllRent();
    List<StatusRent> selectAllStatusRent();
    List<TypeRent> selectAllTypeRent();
}
