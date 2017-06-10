package javasrc.web;

/**
 * Created by Artem on 28.11.2016.
 */
import javasrc.hiber.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javasrc.service.UsersService;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class Registration {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/registration")
    public String listContacts(Map<String, Object> map) {

        map.put("user", new UsersEntity());
        map.put("registrationList", usersService.listContact());
        return "registration";
    }

    @RequestMapping("///")
    public String home() {
        return "redirect:/registration";
    }

    @RequestMapping(value = "/registration", params = "registration", method = POST)
    public String addContact(@ModelAttribute("user") @Valid UsersEntity user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setPassword("");
            model.addAttribute("user", user);
            return "registration";
        }
        usersService.addUser(user);
        return "redirect:/index.jsp";
    }


}
