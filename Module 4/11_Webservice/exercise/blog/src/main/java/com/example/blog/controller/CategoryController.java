package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAll() {
        List<Category> customers = categoryService.findAllCategory();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(customers, HttpStatus.OK);
    }

    //-------------------Retrieve Single category--------------------------------------------------------

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> get(@PathVariable("id") Integer id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    //-------------------Create a category--------------------------------------------------------

    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(category.getCategoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a category --------------------------------------------------------

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@PathVariable("id") Integer id, @RequestBody Category category) {

        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setBlog(category.getBlog());
        currentCategory.setCategoryId(category.getCategoryId());

        categoryService.save(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }

    //------------------- Delete a category --------------------------------------------------------

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCustomer(@PathVariable("id") Integer id) {

        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.delete(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}