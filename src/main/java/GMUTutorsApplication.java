import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Andrew on 4/22/2017.
 */

@SpringBootApplication(scanBasePackages = {"controllers","repository","services","transfer","util"})
@EnableCaching
@EnableWebMvc
@ComponentScan(value = {"controllers","repository","services","transfer","util"})
public class GMUTutorsApplication extends SpringBootServletInitializer{
    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(GMUTutorsApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(GMUTutorsApplication.class);
    }
}
