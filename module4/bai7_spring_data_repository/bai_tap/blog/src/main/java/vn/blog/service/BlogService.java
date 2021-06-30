package vn.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.blog.model.Blog;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findbyId(int id);

    void save(Blog blog);

    void remove(int id);
}
