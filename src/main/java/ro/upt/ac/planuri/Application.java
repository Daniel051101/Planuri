package ro.upt.ac.planuri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.upt.ac.planuri.extractori.ExtractorMaster;
import ro.upt.ac.planuri.extractori.ExtractorLicenta;
import ro.upt.ac.planuri.extractori.ExtractorLicentaCalcEn;
import ro.upt.ac.planuri.extractori.ExtractorLicentaInfoID;
import ro.upt.ac.planuri.extractori.ExtractorLicentaInfoZi;

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
	public CommandLineRunner runExtractorLicenta (ExtractorLicenta extractorLicenta, ExtractorLicentaCalcEn extractorLicentaCalcEn, ExtractorLicentaInfoID extractorLicentaInfoID, ExtractorLicentaInfoZi extractorLicentaInfoZi)
	{
	    return (args) -> {	
			log.info("Starting extractor licenta...");
			
			extractorLicenta.extract();
			
			extractorLicentaCalcEn.extract();
			
//			extractorLicentaInfoID.extract();
			
//			extractorLicentaInfoZi.extract();

			log.info("Stopping extractor...");
	    };
	}
	
	@Bean
	public CommandLineRunner runExtractorMaster (ExtractorMaster extractorMaster)
	{
	    return (args) -> {	
			log.info("Starting extractor master...");
			
			extractorMaster.extract();

			log.info("Stopping extractor...");
	    };
	}	
}
