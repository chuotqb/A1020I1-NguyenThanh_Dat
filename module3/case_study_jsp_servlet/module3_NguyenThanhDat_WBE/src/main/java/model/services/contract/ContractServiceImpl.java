package model.services.contract;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer.TypeCustomer;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContractServiceImpl implements ContractService{
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CONTRACT = "SELECT * from contract";
    private static final String INSERT_CONTRACT = "INSERT INTO contract (contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        int row =0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_CONTRACT);
            preparedStatement.setInt(1,contract.getId());
            preparedStatement.setString(2,contract.getStartDate());
            preparedStatement.setString(3,contract.getEndDate());
            preparedStatement.setDouble(4,contract.getDeposit());
            preparedStatement.setDouble(5,contract.getTotalMoney());
            preparedStatement.setInt(6,contract.getIdEmployee());
            preparedStatement.setInt(7,contract.getIdCustomer());
            preparedStatement.setInt(8,contract.getIdService());

            row = preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> listContract = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CONTRACT);

            Contract contract = null;
            while (resultSet.next()) {
                contract = new Contract();
                contract.setId(resultSet.getInt("contract_id"));
                contract.setStartDate(resultSet.getString("contract_start_date"));
                contract.setEndDate(resultSet.getString("contract_end_date"));
                contract.setDeposit(resultSet.getDouble("contract_deposit"));
                contract.setTotalMoney(resultSet.getDouble("contract_total_money"));
                contract.setIdEmployee(resultSet.getInt("employee_id"));
                contract.setIdCustomer(resultSet.getInt("customer_id"));
                contract.setIdService(resultSet.getInt("service_id"));


                listContract.add(contract);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listContract;
    }
}
