package vn.codegym.quan_ly_tinh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.quan_ly_tinh.model.Customer;
import vn.codegym.quan_ly_tinh.model.Province;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
