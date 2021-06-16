package repository;

import model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface MailBoxRepository {
    List<MailBox> findAll();
    void save(MailBox mailBox);
}
