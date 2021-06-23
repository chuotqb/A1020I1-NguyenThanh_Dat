package vn.codegym.repository;

import vn.codegym.model.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findALl();
    void save(Blog blog);
    Blog findById(int id);
    void remove(int id);
    void update(Blog blog);
}
