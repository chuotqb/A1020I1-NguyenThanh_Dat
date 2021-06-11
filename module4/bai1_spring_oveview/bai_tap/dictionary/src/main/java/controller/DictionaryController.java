package controller;

import model.Dictionary;
import model.service.DictionaryService;
import model.service.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    private DictionaryService dictionaryService = new DictionaryServiceImpl();

    @GetMapping("/search")
    public String search() {
        return "index";
    }

    @PostMapping("/result")
    public String meaning(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaries = this.dictionaryService.findALl();
        boolean check=false;
        int index=0;
        for (int i = 0; i < dictionaries.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                check=true;
                index=i;
            }
        }
        if (check){
            model.addAttribute("word", dictionaries.get(index).getVi());
            model.addAttribute("key", keyword);
            return "index";
        }else {
            model.addAttribute("msg","Not found");
            return "index";
        }
    }
}
