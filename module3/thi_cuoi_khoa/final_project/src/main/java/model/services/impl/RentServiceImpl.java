package model.services.impl;

import model.bean.Rent;
import model.bean.StatusRent;
import model.bean.TypeRent;
import model.repository.BaseRepository;
import model.repository.RentReponsitory;
import model.services.RentService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentServiceImpl implements RentService {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_RENT = "SELECT * from rent";
    private static final String INSERT_RENT = "INSERT INTO rent (rent_id,area,rent_status_id,number_of_floor,type_rent_id,cost,start_date,end_date)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_STATUS = "SELECT * from rent_status";
    private static final String SELECT_TYPE_RENT = "SELECT * from type_rent";
    @Override
    public boolean insertRent(Rent rent) throws SQLException {
        int row =0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_RENT);
            preparedStatement.setString(1,rent.getIdRent());
            preparedStatement.setInt(2,rent.getArea());
            preparedStatement.setInt(3,rent.getIdStatus());
            preparedStatement.setInt(4,rent.getNumOfFloor());
            preparedStatement.setInt(5,rent.getIdType());
            preparedStatement.setInt(6,rent.getCost());
            preparedStatement.setString(7,rent.getStartDate());
            preparedStatement.setString(8,rent.getEndDate());

            row = preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public List<Rent> selectAllRent() {
        List<Rent> listRent = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_RENT);

            Rent rent = null;
            while (resultSet.next()) {
                rent = new Rent();
                rent.setIdRent(resultSet.getString("rent_id"));
                rent.setArea(resultSet.getInt("area"));
                rent.setIdStatus(resultSet.getInt("rent_status_id"));
                rent.setNumOfFloor(resultSet.getInt("number_of_floor"));
                rent.setIdType(resultSet.getInt("type_rent_id"));
                rent.setCost(resultSet.getInt("cost"));
                rent.setStartDate(resultSet.getString("start_date"));
                rent.setEndDate(resultSet.getString("end_date"));


                listRent.add(rent);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listRent;
    }

    @Override
    public List<StatusRent> selectAllStatusRent() {
        List<StatusRent> listStatus = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_STATUS);

            StatusRent statusRent = null;
            while (resultSet.next()) {
                statusRent = new StatusRent();
                statusRent.setIdStatus(resultSet.getInt("rent_status_id"));
                statusRent.setNameStatus(resultSet.getString("name_status"));


                listStatus.add(statusRent);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listStatus;
    }

    @Override
    public List<TypeRent> selectAllTypeRent() {
        List<TypeRent> listRentType = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_TYPE_RENT);

            TypeRent typeRent = null;
            while (resultSet.next()) {
                typeRent = new TypeRent();
                typeRent.setIdType(resultSet.getInt("type_rent_id"));
                typeRent.setNameType(resultSet.getString("name_type"));


                listRentType.add(typeRent);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listRentType;
    }
}
