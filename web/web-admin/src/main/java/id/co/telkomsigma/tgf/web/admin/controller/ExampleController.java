package id.co.telkomsigma.tgf.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Controller
public class ExampleController {

    @GetMapping("/example")
    public ModelAndView examplePage() {

        return new ModelAndView("example", "exampleObj", "Example Page");
    }
}
