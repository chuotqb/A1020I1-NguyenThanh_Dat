package controller;

import model.MailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MailBoxService;

@Controller
public class MailBoxController {

    @Autowired
    MailBoxService mailBoxService;

    @GetMapping(value = "/")
    public ModelAndView listMailbox(){
        return new ModelAndView("list", "mailboxList", mailBoxService.findAll());
    }

    @GetMapping(value = "/create")
    public String viewCreate(Model model){
        model.addAttribute("mailbox", new MailBox());
        return "create";
    }

    @PostMapping(value = "create")
    public String saveCreate(@ModelAttribute("mailbox") MailBox mailbox){
        mailBoxService.save(mailbox);
        return "redirect:/";
    }
}
