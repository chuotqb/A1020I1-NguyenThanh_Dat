package vn.codegym.quan_ly_tinh.service;

import vn.codegym.quan_ly_tinh.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
