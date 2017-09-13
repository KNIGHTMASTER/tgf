package id.co.telkomsigma.tgf.web.admin.vaadin;

import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@ComponentScan(basePackages = "id.co.telkomsigma.tgf")
@EnableVaadin
@EnableAutoConfiguration
@SpringBootApplication
public class WebAdminVaadin {

    public static void main(String [] p_Args) {
        SpringApplication.run(WebAdminVaadin.class, p_Args);
    }
}
