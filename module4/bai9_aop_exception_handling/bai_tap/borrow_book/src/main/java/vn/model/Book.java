package vn.model;

import org.aspectj.apache.bcel.classfile.Code;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull
    @Min(0)
    private int quatity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    Set<CodeBook> codeSet = new LinkedHashSet<>();

    public Book() {
    }

    public void generateCode(CodeBook codeBook){
        codeSet.add(codeBook);
    }

    public void borrow(){
        if (quatity>0) quatity--;
    }

    public void returnBook(){
        quatity++;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public Set<CodeBook> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(Set<CodeBook> codeSet) {
        this.codeSet = codeSet;
    }
}
