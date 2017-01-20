package pl.edu.pwr.carrierrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by lukasz on 12/15/16.
 */
@SpringBootApplication(scanBasePackages = {"pl.edu.pwr.carrierrental"})
@EnableScheduling
@EnableCaching
public class AppInit {
    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);
    }
}
