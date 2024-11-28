package ro.upt.ac.planuri.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanInvatamant 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	private String universitate;
	private String facultate;
	private String domeniuFundamental;
	private String ramuraDeStiinta;
	private String domeniuDeLicenta;
	private String programDeStudiiLicenta;
	private int codDomeniuFundamental;
	private int codRamuraDeStiinta;
	private int codDomeniuDeLicenta;
	private int codStudii;
	private String ciclu;
	//c1c2c3  codul programului de studii sau al domeniului de licență din care face parte programul; codul va fi furnizat;
	private int codulProgramuluiDeStudii; 
	//ultimele 2 cifre ale primului an calendaristic al anului universitar
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

	public String getProgramDeStudiiLicenta() {
		return programDeStudiiLicenta;
	}

	public void setProgramDeStudiiLicenta(String programDeStudiiLicenta) {
		this.programDeStudiiLicenta = programDeStudiiLicenta;
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

	public int getCodStudii() {
		return codStudii;
	}

	public void setCodStudii(int codStudii) {
		this.codStudii = codStudii;
	}

	public String getCiclu() {
		return ciclu;
	}

	public void setCiclu(String ciclu) {
		this.ciclu = ciclu;
	}

	public int getCodulProgramuluiDeStudii() {
		return codulProgramuluiDeStudii;
	}

	public void setCodulProgramuluiDeStudii(int codulProgramuluiDeStudii) {
		this.codulProgramuluiDeStudii = codulProgramuluiDeStudii;
	}

	public int getAnCalendaristic() {
		return anCalendaristic;
	}

	public void setAnCalendaristic(int anCalendaristic) {
		this.anCalendaristic = anCalendaristic;
	}

	public int getCodDomeniuDeLicenta() {
		return codDomeniuDeLicenta;
	}

	public void setCodDomeniuDeLicenta(int codDomeniuDeLicenta) {
		this.codDomeniuDeLicenta = codDomeniuDeLicenta;
	}
}
