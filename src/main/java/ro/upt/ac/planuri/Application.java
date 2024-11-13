package ro.upt.ac.planuri;

//import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.upt.ac.planuri.plan.PlanInvatamant;
import ro.upt.ac.planuri.plan.PlanInvatamantRepository;

@EnableWebMvc
@SpringBootApplication
public class Application 
{	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
	public CommandLineRunner loadDataCompanii(PlanInvatamantRepository repository)
	{
	    return (args) -> {	
			log.info("starting initialization...");
			
			PlanInvatamant c1=new PlanInvatamant();
	        c1.setUniversitate("Universitatea Politehnica Timișoara");
	        c1.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
	        c1.setDomeniuFundamental("MATEMATICĂ ȘI ȘTIINȚE ALE NATURI");
	        c1.setRamuraDeStiinte("INFORMATICĂ");
	        c1.setDomeniulDeLicenta("INFORMATICĂ");
			c1.setProgramulDeStudiiLicenta("INFORMATICĂ");
	        repository.save(c1);

			PlanInvatamant c2=new PlanInvatamant();
			c1.setUniversitate("Universitatea Politehnica Timișoara");
    		c1.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c1.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c1.setRamuraDeStiinte("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c1.setDomeniulDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c1.setProgramulDeStudiiLicenta("CALCULATOARE");
    		repository.save(c2);

	        

			log.info("ending initialization...");
	    };
	}	
	
}
