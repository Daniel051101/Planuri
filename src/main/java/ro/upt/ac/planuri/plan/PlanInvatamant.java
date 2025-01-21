package ro.upt.ac.planuri.plan;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class PlanInvatamant 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String universitate;
	private String facultate;
	private String domeniuFundamental;
	private String ramuraDeStiinta;
	private String domeniuDeLicenta;
	private int codDomeniuFundamental;
	private int codRamuraDeStiinta;
	private String ciclu;
	private String codulProgramuluiDeStudii; 
	private int anCalendaristic;
	
	public PlanInvatamant()
	{
	}

	public String getUniversitate() {
		return universitate;
	}

	public void setUniversitate(String universitate) {
		this.universitate = universitate;
	}

	public String getFacultate() {
		return facultate;
	}

	public void setFacultate(String facultate) {
		this.facultate = facultate;
	}

	public String getDomeniuFundamental() {
		return domeniuFundamental;
	}

	public void setDomeniuFundamental(String domeniuFundamental) {
		this.domeniuFundamental = domeniuFundamental;
	}

	public String getRamuraDeStiinta() {
		return ramuraDeStiinta;
	}

	public void setRamuraDeStiinta(String ramuraDeStiinta) {
		this.ramuraDeStiinta = ramuraDeStiinta;
	}

	public String getDomeniuDeLicenta() {
		return domeniuDeLicenta;
	}

	public void setDomeniuDeLicenta(String domeniuDeLicenta) {
		this.domeniuDeLicenta = domeniuDeLicenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodDomeniuFundamental() {
		return codDomeniuFundamental;
	}

	public void setCodDomeniuFundamental(int codDomeniuFundamental) {
		this.codDomeniuFundamental = codDomeniuFundamental;
	}

	public int getCodRamuraDeStiinta() {
		return codRamuraDeStiinta;
	}

	public void setCodRamuraDeStiinta(int codRamuraDeStiinta) {
		this.codRamuraDeStiinta = codRamuraDeStiinta;
	}

	public String getCiclu() {
		return ciclu;
	}

	public void setCiclu(String ciclu) {
		this.ciclu = ciclu;
	}

	public String getCodulProgramuluiDeStudii() {
		return codulProgramuluiDeStudii;
	}

	public void setCodulProgramuluiDeStudii(String codulProgramuluiDeStudii) {
		this.codulProgramuluiDeStudii = codulProgramuluiDeStudii;
	}

	public int getAnCalendaristic() {
		return anCalendaristic;
	}

	public void setAnCalendaristic(int anCalendaristic) {
		this.anCalendaristic = anCalendaristic;
	}
	
}
