package ro.upt.ac.planuri;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.upt.ac.planuri.plan.PlanUniversitar;
import ro.upt.ac.planuri.plan.PlanUniversitarRepository;

@EnableWebMvc
@SpringBootApplication
public class Application 
{	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
	}

	
//	@Bean
//	public CommandLineRunner loadDataCompanii(PlanUniversitarRepository repository)
//	{
//	    return (args) -> {	
//			log.info("starting initialization...");
//			
//			PlanUniversitar c1=new PlanUniversitar();
//	        c1.setNume("Continental");
//	        c1.setReprezentant("Christian von Albrichsfeld");
//	        c1.setCalitate("CEO");
//	        c1.setAdresa("str. Siemens nr. 1, Timisoara");
//	        c1.setTelefon("0700123456");
//	        repository.save(c1);
//
//	        PlanUniversitar c2=new PlanUniversitar();
//	        c2.setNume("Nokia");
//	        c2.setReprezentant("Florin-Costin Ciocan");
//	        c2.setCalitate("PMP");
//	        c2.setAdresa("Splaiul Nicolae Titulescu nr. 8, Timisoara");
//	        c2.setTelefon("0700123456");
//	        repository.save(c2);
//
//			log.info("ending initialization...");
//	    };
//	}	
	
}
