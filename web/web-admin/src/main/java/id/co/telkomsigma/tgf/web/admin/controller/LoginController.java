package id.co.telkomsigma.tgf.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String displayLoginPage(){
        return "login";
    }
}
