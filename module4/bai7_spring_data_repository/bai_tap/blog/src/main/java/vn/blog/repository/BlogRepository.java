package vn.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
