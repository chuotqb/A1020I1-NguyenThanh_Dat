package vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.model.CodeBook;

import java.util.List;

public interface CodeBookRepository extends JpaRepository<CodeBook,Integer> {
    List<CodeBook> findCodeBookByBook_Id(int id);
    List<CodeBook> findAllByBook_IdAndStatus(int id,String status);
    CodeBook findByBook_IdAndCode(int id,int codeBook);
}
