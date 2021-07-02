package vn.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);

    Category findbyId(int id);

    void save(Category category);

    void remove(int id);
}
