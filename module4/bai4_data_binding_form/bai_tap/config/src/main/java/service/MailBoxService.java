package service;

import model.MailBox;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface MailBoxService {
    List<MailBox> findAll();
    void save(MailBox mailBox);
}
