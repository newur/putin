import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruwen on 20.08.17.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class Main {

    @GetMapping
    public String sayHelloWorld() {
        return "Hello World";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}
