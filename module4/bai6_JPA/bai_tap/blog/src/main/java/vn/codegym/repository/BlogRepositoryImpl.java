package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
//@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override

    public List<Blog> findALl() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b",Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void remove(int id) {
        Blog blog = entityManager.find(Blog.class,id);
        entityManager.remove(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }
}
