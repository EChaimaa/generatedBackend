package  com.cc.projetX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ProjetXApplication {

public static ConfigurableApplicationContext ctx;
public static void main(String[] args) {
ctx=SpringApplication.run(ProjetXApplication.class, args);
}
public static ConfigurableApplicationContext getCtx() {
return ctx;
}


}
