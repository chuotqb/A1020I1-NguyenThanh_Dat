package vn.codegym.quan_ly_tinh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.quan_ly_tinh.model.Customer;
import vn.codegym.quan_ly_tinh.model.Province;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname,Pageable pageable);
}
