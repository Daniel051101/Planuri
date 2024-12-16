package ro.upt.ac.planuri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.upt.ac.planuri.plan.PlanInvatamantRepository;

//import ro.upt.ac.planuri.plan.PlanInvatamantLicenta;
//import ro.upt.ac.planuri.disciplina.Disciplina;
//import ro.upt.ac.planuri.disciplina.DisciplinaId;
//import ro.upt.ac.planuri.disciplina.DisciplinaRepository;
//import ro.upt.ac.planuri.disciplina.DisciplinaZi;
//import ro.upt.ac.planuri.disciplina.TCategorieFormativaLicenta;
//import ro.upt.ac.planuri.disciplina.TCategorieFormativaMaster;
//import ro.upt.ac.planuri.disciplina.TFormaEvaluare;

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

			log.info("ending initialization...");
	    };
	}
	
}
