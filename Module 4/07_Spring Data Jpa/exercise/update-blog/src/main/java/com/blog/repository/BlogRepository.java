package com.blog.repository;

import com.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    @Query("select b from Blog b where concat(b.title,b.content,b.category.name) like %?1%")
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findByOrderByTitleAsc(Pageable pageable);
}
