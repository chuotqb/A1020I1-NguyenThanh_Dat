package vn.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.model.CodeBook;
import vn.repository.CodeBookRepository;
import vn.service.CodeBookService;

import java.util.List;
@Service
public class CodeBookServicempl implements CodeBookService {
    @Autowired
    CodeBookRepository codeBookRepository;
    @Override
    public List<CodeBook> findAll() {
        return codeBookRepository.findAll();
    }

    @Override
    public void save(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
    }

    @Override
    public CodeBook findById(int id) {
        return codeBookRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        codeBookRepository.deleteById(id);
    }

    @Override
    public List<CodeBook> findCodeBookByBook_Id(int id) {
        return codeBookRepository.findCodeBookByBook_Id(id);
    }

    @Override
    public List<CodeBook> findAllByBook_IdAndStatus(int id, String status) {
        return codeBookRepository.findAllByBook_IdAndStatus(id,status);
    }

    @Override
    public CodeBook findByBook_IdAndCode(int id, int codeBook) {
        return codeBookRepository.findByBook_IdAndCode(id,codeBook);
    }
}
