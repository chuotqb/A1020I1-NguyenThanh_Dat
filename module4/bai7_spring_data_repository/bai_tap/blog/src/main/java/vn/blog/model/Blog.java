package vn.blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String subtitle;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne(targetEntity= Category.class)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    public Blog() {
    }

    public Blog(int id, String title, String subtitle, String image, String content) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.content = content;
    }

    public Blog(String title, String subtitle, String image, String content, Category category) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
