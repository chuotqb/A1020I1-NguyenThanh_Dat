package vn.codegym.quan_ly_tinh.service;

import vn.codegym.quan_ly_tinh.model.Customer;
import vn.codegym.quan_ly_tinh.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
