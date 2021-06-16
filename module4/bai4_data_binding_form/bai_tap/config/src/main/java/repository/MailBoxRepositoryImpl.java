package repository;

import model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailBoxRepositoryImpl implements MailBoxRepository{
    private static List<MailBox> mailBoxList = new ArrayList<>();

    static {
        mailBoxList.add(new MailBox("English","5",true,"Thor\nKing Asgard"));
        mailBoxList.add(new MailBox("Vietnamese","10",false,"Thor\nKing Asgard"));
        mailBoxList.add(new MailBox("Japansese","15",false,"Thor\nKing Asgard"));
        mailBoxList.add(new MailBox("Chinese","20",false,"Thor\nKing Asgard"));
    }
    @Override
    public List<MailBox> findAll() {
        return mailBoxList;
    }

    @Override
    public void save(MailBox mailBox) {
        mailBoxList.add(mailBox);
    }
}
