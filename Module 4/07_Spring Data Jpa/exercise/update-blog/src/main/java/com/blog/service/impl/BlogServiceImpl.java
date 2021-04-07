package com.blog.service.impl;

import com.blog.entity.Blog;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(name, pageable);
    }

    @Override
    public Page<Blog> sort(Pageable pageable) {
        return blogRepository.findByOrderByTitleAsc(pageable);
    }


}
