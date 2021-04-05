package blog.blog.service;

import blog.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);
}
