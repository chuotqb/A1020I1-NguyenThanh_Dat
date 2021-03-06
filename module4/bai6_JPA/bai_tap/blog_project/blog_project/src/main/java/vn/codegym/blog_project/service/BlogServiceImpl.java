package vn.codegym.blog_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.blog_project.model.Blog;
import vn.codegym.blog_project.repository.BlogRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findALl() {
        return blogRepository.findALl();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }

    @Override
    public void update(Blog blog) {
        update(blog);
    }
}
