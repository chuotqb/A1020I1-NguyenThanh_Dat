package vn.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
