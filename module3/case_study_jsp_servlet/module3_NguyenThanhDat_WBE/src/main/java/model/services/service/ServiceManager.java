package model.services.service;

import model.bean.customer.Customer;
import model.bean.service.Services;
import model.bean.service.TypeRent;
import model.bean.service.TypeService;

import java.sql.SQLException;
import java.util.List;

public interface ServiceManager {
    boolean insertService (Services services) throws SQLException;
    List<Services> selectAllService() throws SQLException;
    List<TypeRent> selectAllTypeRent() throws SQLException;
    List<TypeService> selectAllTypeService() throws SQLException;

}
