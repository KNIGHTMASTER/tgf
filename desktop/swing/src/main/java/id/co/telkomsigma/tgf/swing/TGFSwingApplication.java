package id.co.telkomsigma.tgf.swing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
public class TGFSwingApplication {

    /**
     * Application main() method.
     *
     * Uses the fluent {@link org.springframework.boot.builder.SpringApplicationBuilder} to create and run the
     * {@link SpringApplication} object.
     *
     * The options specified:
     *
     * <ul>
     * <li>headless(false) - allow AWT classes to be instantiated</li>
     * <li>web(false) - prevents the bundling of Tomcat or other Web components
     * </ul>
     *
     * Execution is picked up by the {@link Runner} class, which implements
     * {@link org.springframework.boot.CommandLineRunner}.
     *
     * @param args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(TGFSwingApplication.class)
                .headless(false)
                .web(false)
                .run(args);
    }
}
