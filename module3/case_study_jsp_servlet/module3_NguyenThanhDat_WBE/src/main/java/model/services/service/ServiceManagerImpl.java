package model.services.service;

import model.bean.customer.Customer;
import model.bean.service.Services;
import model.bean.service.TypeRent;
import model.bean.service.TypeService;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceManagerImpl implements ServiceManager{
    private BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String SELECT_ALL_TYPE_RENT = "select * from rent_type";
    private static final String SELECT_ALL_TYPE_SERVICE = "select * from service_type";
    @Override
    public boolean insertService(Services services) throws SQLException {
        int row =0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_SERVICE_SQL);
            preparedStatement.setInt(1,services.getId());
            preparedStatement.setString(2,services.getName());
            preparedStatement.setInt(3,services.getArea());
            preparedStatement.setDouble(4,services.getCost());
            preparedStatement.setInt(5,services.getMaxPeople());
            preparedStatement.setInt(6,services.getIdRentType());
            preparedStatement.setInt(7,services.getIdTypeService());
            preparedStatement.setString(8,services.getStandarRoom());
            preparedStatement.setString(9,services.getDescriptionOther());
            preparedStatement.setDouble(10,services.getPoolArea());
            preparedStatement.setInt(11,services.getNumOfFloor());
            row = preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public List<Services> selectAllService() throws SQLException {
        List<Services> servicesList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_SERVICE);

            Services services = null;
            while (resultSet.next()) {
                services = new Services();
                services.setId(resultSet.getInt("service_id"));
                services.setName(resultSet.getString("service_name"));
                services.setArea(resultSet.getInt("service_area"));
                services.setCost(resultSet.getDouble("service_cost"));
                services.setMaxPeople(resultSet.getInt("service_max_people"));
                services.setIdRentType(resultSet.getInt("rent_type_id"));
                services.setIdTypeService(resultSet.getInt("service_type_id"));
                services.setStandarRoom(resultSet.getString("standard_room"));
                services.setDescriptionOther(resultSet.getString("description_other_convenience"));
                services.setPoolArea(resultSet.getDouble("pool_area"));
                services.setNumOfFloor(resultSet.getInt("number_of_floors"));
                servicesList.add(services);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return servicesList;
    }

    @Override
    public List<TypeRent> selectAllTypeRent() throws SQLException {
        List<TypeRent> typeRentList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_TYPE_RENT);

            TypeRent typeRent = null;
            while (resultSet.next()) {
                typeRent = new TypeRent();
                typeRent.setId(resultSet.getInt("rent_type_id"));
                typeRent.setName(resultSet.getString("rent_type_name"));
                typeRent.setCost(resultSet.getDouble("rent_type_cost"));

                typeRentList.add(typeRent);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeRentList;
    }

    @Override
    public List<TypeService> selectAllTypeService() throws SQLException {
        List<TypeService> typeServiceList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_TYPE_SERVICE);

            TypeService typeService = null;
            while (resultSet.next()) {
                typeService = new TypeService();
                typeService.setId(resultSet.getInt("service_type_id"));
                typeService.setName(resultSet.getString("service_type_name"));

                typeServiceList.add(typeService);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeServiceList;
    }
}
