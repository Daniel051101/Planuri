package ro.upt.ac.planuri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.upt.ac.planuri.extractori.ExtractorLicenta;
import ro.upt.ac.planuri.extractori.ExtractorLicentaCalcEn;
import ro.upt.ac.planuri.extractori.ExtractorLicentaInfoID;
import ro.upt.ac.planuri.extractori.ExtractorLicentaInfoZi;
import ro.upt.ac.planuri.extractori.ExtractorMaster;
//import ro.upt.ac.planuri.plan.PlanInvatamantLicenta;
//import ro.upt.ac.planuri.plan.PlanInvatamantLicentaRepository;
//import ro.upt.ac.planuri.plan.PlanInvatamantMasterRepository;
//import ro.upt.ac.planuri.disciplina.DisciplinaZi;
//import ro.upt.ac.planuri.disciplina.DisciplinaZiRepository;


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
//	public CommandLineRunner loadDataPlanInvatamantLicenta(PlanInvatamantLicentaRepository planInvatamantLicentaRepository,DisciplinaZiRepository disciplinaZiRepository)
//	{
//	    return (args) -> {	
//			log.info("starting initialization...");
//			
//			
//			DisciplinaZi dz1=new DisciplinaZi();
//			dz1.setCod("L012.23.05.F1");
//			dz1.setNume("Securitatea Informatiei");
//			dz1.setNumarCrediteTransferabile(5);
//			
//			disciplinaZiRepository.save(dz1);
//
//			DisciplinaZi dz2=new DisciplinaZi();
//			dz2.setCod("L012.23.01.C1");
//			dz2.setNume("Analiza matematica");
//			dz2.setNumarCrediteTransferabile(5);
//			disciplinaZiRepository.save(dz2);
//			
//			PlanInvatamantLicenta pil1=new PlanInvatamantLicenta();
//			pil1.setAnCalendaristic(2025);
//			pil1.setCodulProgramuluiDeStudii("002");
//			
//			pil1.getListaDisciplinaZi().add(dz1);
//			pil1.getListaDisciplinaZi().add(dz2);
//			planInvatamantLicentaRepository.save(pil1);
//
//			log.info("ending initialization...");
//	    };
//	}
		
	@Bean
	public CommandLineRunner runExtractorLicenta (ExtractorLicenta extractorLicenta, ExtractorLicentaCalcEn extractorLicentaCalcEn, ExtractorLicentaInfoID extractorLicentaInfoID, ExtractorLicentaInfoZi extractorLicentaInfoZi)
	{
	    return (args) -> {	
			log.info("Starting extractor...");
			
			extractorLicenta.extract();
			
			extractorLicentaCalcEn.extract();
			
			extractorLicentaInfoID.extract();
			
			extractorLicentaInfoZi.extract();

			log.info("Extractor finished");
	    };
	}
	
	@Bean
	public CommandLineRunner runExtractorMaster (ExtractorMaster extractorMaster)
	{
	    return (args) -> {	
			log.info("Starting extractor...");
			
			extractorMaster.extract();

			log.info("Extractor finished");
	    };
	}
	
}
