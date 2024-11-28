package ro.upt.ac.planuri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ro.upt.ac.planuri.plan.PlanInvatamant;
import ro.upt.ac.planuri.plan.PlanInvatamantRepository;
import ro.upt.ac.planuri.disciplina.Disciplina;
import ro.upt.ac.planuri.disciplina.DisciplinaId;
import ro.upt.ac.planuri.disciplina.DisciplinaZiRepository;
import ro.upt.ac.planuri.disciplina.DisciplinaZi;
import ro.upt.ac.planuri.disciplina.TCategorieFormativa;
import ro.upt.ac.planuri.disciplina.TFormaEvaluare;

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
			c1.setCodDomeniuFundamental(10);
			c1.setCodRamuraDeStiinta(50);
			c1.setCodDomeniuDeLicenta(40);
			c1.setCodStudii(10);
			c1.setCiclu("L");
			c1.setCodulProgramuluiDeStudii(011);
			c1.setAnCalendaristic(23);
	        repository.save(c1);

	        PlanInvatamant c2=new PlanInvatamant();
			c2.setUniversitate("Universitatea Politehnica Timișoara");
    		c2.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c2.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c2.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c2.setDomeniuDeLicenta("INGINERIA SISTEMELOR");
			c2.setProgramDeStudiiLicenta("AUTOMATICA SI INFORMATICA APLICATA");
			c2.setCodDomeniuFundamental(10);
			c2.setCodRamuraDeStiinta(50);
			c2.setCodDomeniuDeLicenta(40);
			c2.setCodStudii(10);
			c2.setCiclu("L");
			c2.setCodulProgramuluiDeStudii(011);
			c2.setAnCalendaristic(23);
    		repository.save(c2);
    		
    		PlanInvatamant c3=new PlanInvatamant();
			c3.setUniversitate("Universitatea Politehnica Timișoara");
    		c3.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c3.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c3.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c3.setDomeniuDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c3.setProgramDeStudiiLicenta("CALCULATOARE (in limba engleza)");
			c3.setCodDomeniuFundamental(10);
			c3.setCodRamuraDeStiinta(50);
			c3.setCodDomeniuDeLicenta(40);
			c3.setCodStudii(10);
			c3.setCiclu("L");
			c3.setCodulProgramuluiDeStudii(011);
			c3.setAnCalendaristic(23);
    		repository.save(c3);
    		
    		PlanInvatamant c4=new PlanInvatamant();
			c4.setUniversitate("Universitatea Politehnica Timișoara");
    		c4.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c4.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c4.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c4.setDomeniuDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c4.setProgramDeStudiiLicenta("CALCULATOARE");
			c4.setCodDomeniuFundamental(10);
			c4.setCodRamuraDeStiinta(50);
			c4.setCodDomeniuDeLicenta(40);
			c4.setCodStudii(10);
			c4.setCiclu("L");
			c4.setCodulProgramuluiDeStudii(011);
			c4.setAnCalendaristic(23);
    		repository.save(c4);
    		
    		PlanInvatamant c5=new PlanInvatamant();
			c5.setUniversitate("Universitatea Politehnica Timișoara");
    		c5.setFacultate("Facultatea de AUTOMATICĂ ȘI CALCULATOARE");
 		    c5.setDomeniuFundamental("ȘTIINȚE INGINEREȘTI");
 		    c5.setRamuraDeStiinta("INGINERIA SISTEMELOR, CALCULATOARELOR ȘI TEHNOLOGIA INFORMAȚIEI");
 		    c5.setDomeniuDeLicenta("CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI");
			c5.setProgramDeStudiiLicenta("TEHNOLOGIA INFORMATIE");
			c5.setCodDomeniuFundamental(10);
			c5.setCodRamuraDeStiinta(50);
			c5.setCodDomeniuDeLicenta(40);
			c5.setCodStudii(10);
			c5.setCiclu("L");
			c5.setCodulProgramuluiDeStudii(011);
			c5.setAnCalendaristic(23);
    		repository.save(c5);

			log.info("ending initialization...");
	    };
	}
	
	@Bean
	public CommandLineRunner loadDataDisciplina(DisciplinaZiRepository repository)
	{
		 return (args) -> {	
				log.info("starting initialization...");
	    		
				DisciplinaZi d1=new DisciplinaZi();
	    		d1.setNumeDisciplina("Analiza Matematica");
	    		d1.setCodDisciplina("L011.23.01.C1");
	    		d1.setNumarCrediteTransferabile(5);
	    		d1.setFormaEvaluare(TFormaEvaluare.C.getNumeLung());
	    		d1.setNumarOreCurs(28);
	    		d1.setNumarOreSeminar(28);
	    		d1.setNumarOreLaborator(0);
	    		d1.setNumarOreProiect(0);
	    		d1.setVolumOreNecesareActivitatilorPartialAsistate(0);
	    		d1.setCategorieFormativa(TCategorieFormativa.DD.getNumeLung());
	    		d1.setVolumOreNecesaraPregatiriIndividuale(69);
	    		repository.save(d1);      

				/*
	    		DisciplinaId d2=new DisciplinaId();
	    		d2.setNumeDisciplina("Analiza Matematica");
	    		d2.setCodDisciplina("L011.23.01.C1");
	    		d2.setNumarCrediteTransferabile(5);
	    		d2.setFormaEvaluare(TFormaEvaluare.C.getNumeLung());
	    		d2.setNumarOreActivitatiAutoinstruire(28);
	    		d2.setNumarOreActivitatiTutorat(28);
	    		d2.setNumarTemeDeControl(0);;
	    		d2.setNumarActivitatiAplicativeAsistate(0);
	    		d2.setVolumOreNecesareActivitatilorPartialAsistate(0);
	    		d2.setCategorieFormativa(TCategorieFormativa.DD.getNumeLung());
	    		d2.setVolumOreNecesaraPregatiriIndividuale(69);
	    		repository.save(d2);
	    		*/      

	    		log.info("ending initialization...");
		};
	}
}
