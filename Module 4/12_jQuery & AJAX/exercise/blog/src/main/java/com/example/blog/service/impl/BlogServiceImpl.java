package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findBlogById(Integer id) {
        return blogRepository.findById( id );
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById( id );
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save( blog );
    }

    @Override
    public Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable) {
        return blogRepository.findBlogByCategory_Id( id,pageable );
    }

    @Override
    public List<Blog> findBlogByNameContains(String search, Integer number) {
        List<Blog> list;
        if (search.equals("")){
            return findAllBlogByNumber( number );
        }
        list = blogRepository.findBlogByNameContains( search );
        if ((list.size()-number)<1){
            return list;
        }else {
            return list.subList( 0,number );
        }

    }

    @Override
    public Page<Blog> findBlogByOrderByDateAsc(Pageable pageable) {
        return blogRepository.findBlogByOrderByDateAsc( pageable );
    }

    @Override
    public List<Blog> findAllBlogByNumber(Integer number) {
        List<Blog> list = findAllBlog();
        if ((list.size()-number)<1){
            return list;
        }else {
            return list.subList( 0,number );
        }
    }


}