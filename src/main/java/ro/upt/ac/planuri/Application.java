package ro.upt.ac.planuri;

//import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.upt.ac.planuri.plan.PlanInvatamant;
import ro.upt.ac.planuri.plan.PlanInvatamantRepository;

//import ro.upt.ac.planuri.disciplina.Disciplina;
//import ro.upt.ac.planuri.disciplina.DisciplinaRepository;

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
	public CommandLineRunner loadDataPlanInvatamant(PlanInvatamantRepository repository)
//	public CommandLineRunner loadDataDisciplina(DisciplinaRepository repository)

	{
	    return (args) -> {	
			log.info("starting initialization...");
			
			PlanInvatamant c1=new PlanInvatamant();
	        c1.setUniversitate("Universitatea Politehnica Timișoara");
	        c1.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
	        c1.setDomeniuFundamental("MATEMATICĂ ȘI ȘTIINȚE ALE NATURI");
	        c1.setRamuraDeStiinta("INFORMATICĂ");
	        c1.setDomeniuDeLicenta("INFORMATICĂ");
			c1.setProgramDeStudiiLicenta("INFORMATICĂ");
	        repository.save(c1);

			PlanInvatamant c2=new PlanInvatamant();
			c2.setUniversitate("Universitatea Politehnica Timișoara");
    		c2.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c2.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c2.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c2.setDomeniuDeLicenta("INGINERIA SISTEMELOR");
			c2.setProgramDeStudiiLicenta("AUTOMATICA SI INFORMATICA APLICATA");
    		repository.save(c2);
    		
    		PlanInvatamant c3=new PlanInvatamant();
			c3.setUniversitate("Universitatea Politehnica Timișoara");
    		c3.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c3.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c3.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c3.setDomeniuDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c3.setProgramDeStudiiLicenta("CALCULATOARE (in limba engleza)");
    		repository.save(c3);
    		
    		PlanInvatamant c4=new PlanInvatamant();
			c4.setUniversitate("Universitatea Politehnica Timișoara");
    		c4.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c4.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c4.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c4.setDomeniuDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c4.setProgramDeStudiiLicenta("CALCULATOARE");
    		repository.save(c4);
    		
    		PlanInvatamant c5=new PlanInvatamant();
			c5.setUniversitate("Universitatea Politehnica Timișoara");
    		c5.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c5.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c5.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c5.setDomeniuDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c5.setProgramDeStudiiLicenta("TEHNOLOGIA INFORMATIE");
    		repository.save(c5);
    		
//    		Disciplina d1=new Disciplina();
//    		d1.setNumeDisciplina("Analiza Matematica");
//    		d1.setCodDisciplina("L011.23.01.C1");
//    		d1.setNumarCrediteTransferabile(5);
//    		d1.setFormaEvaluare(0);
//    		d1.setNumarOreCurs(28);
//    		d1.setNumarOreSeminar(28);
//    		d1.setNumarOreLaborator(0);
//    		d1.setNumarOreProiect(0);
//    		d1.setVolumOreNecesareActivitatilorPartialAsistate(0);
//    		d1.setCategorieFormativa(0);
//    		d1.setVolumOreNecesaraPregatiriIndividuale(69);
//    		repository.save(d1);
    		

	        

			log.info("ending initialization...");
	    };
	}	
	
}
