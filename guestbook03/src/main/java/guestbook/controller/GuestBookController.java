package guestbook.controller;

import guestbook.repository.GuestbookRepository;
import guestbook.vo.GuestbookVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class GuestBookController {

    private GuestbookRepository guestbookRepository;

    public GuestBookController(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<GuestbookVo> list = guestbookRepository.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("name") String name,
                      @RequestParam("password") String password,
                      @RequestParam("contents") String contents) {

        GuestbookVo vo = new GuestbookVo();
        vo.setName(name);
        vo.setPassword(password);
        vo.setContents(contents);

        guestbookRepository.insert(vo);

        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id) {
        return "deleteform";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id, @RequestParam("password") String password) {
        System.out.println("출력  " + id + ":" +password);

        guestbookRepository.deleteByIdAndPassword(id,password);
        return "redirect:/";
    }
}
