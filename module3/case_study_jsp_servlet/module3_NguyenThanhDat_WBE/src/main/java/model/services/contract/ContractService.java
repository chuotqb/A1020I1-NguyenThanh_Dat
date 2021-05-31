package model.services.contract;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    boolean insertContract (Contract contract) throws SQLException;
    List<Contract> selectAllContract();

}
