package com.example.blog.controller;
import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAll() {
        List<Blog> blog = blogService.findAllBlog();
        if (blog.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
    }

    //-------------------Retrieve Single blog--------------------------------------------------------

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> get(@PathVariable("id") Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //-------------------Create a blog--------------------------------------------------------

    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + blog.getTitle());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a blog --------------------------------------------------------

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> update(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        Blog currentBlog = blogService.findById(id);

        if (currentBlog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setTitle(blog.getTitle());
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setContent(blog.getContent());
        currentBlog.setId(blog.getId());

        blogService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }

    //------------------- Delete a blog --------------------------------------------------------

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> delete(@PathVariable("id") Integer id) {

        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogService.delete(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
}