package com.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer id;

    @Column(name = "blog_title", nullable = false, length = 45)
    private String title;

    @Column(name = "blog_content", nullable = false, length = 45)
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
