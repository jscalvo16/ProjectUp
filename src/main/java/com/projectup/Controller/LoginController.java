 package com.projectup.Controller;
import com.projectup.exceptions.ApplicatioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.projectup.beans.Login;
import com.projectup.beans.User;
import com.projectup.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;

 @Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String index(Model model) {
        return "login";
    }

}
