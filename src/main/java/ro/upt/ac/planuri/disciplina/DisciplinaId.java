package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaId extends Disciplina 
{
	private String categorieFormativaLicenta;
	private String numarOreActivitatiAutoinstruire;
	private String numarOreActivitatiTutorat;
	private String numarTemeDeControl;
	private String numarActivitatiAplicativeAsistate;
	
	public DisciplinaId()
	{
	}

	public String getNumarOreActivitatiAutoinstruire() {
		return numarOreActivitatiAutoinstruire;
	}

	public void setNumarOreActivitatiAutoinstruire(String numarOreActivitatiAutoinstruire) {
		this.numarOreActivitatiAutoinstruire = numarOreActivitatiAutoinstruire;
	}

	public String getNumarOreActivitatiTutorat() {
		return numarOreActivitatiTutorat;
	}

	public void setNumarOreActivitatiTutorat(String numarOreActivitatiTutorat) {
		this.numarOreActivitatiTutorat = numarOreActivitatiTutorat;
	}

	public String getNumarTemeDeControl() {
		return numarTemeDeControl;
	}

	public void setNumarTemeDeControl(String numarTemeDeControl) {
		this.numarTemeDeControl = numarTemeDeControl;
	}

	public String getNumarActivitatiAplicativeAsistate() {
		return numarActivitatiAplicativeAsistate;
	}

	public void setNumarActivitatiAplicativeAsistate(String numarActivitatiAplicativeAsistate) {
		this.numarActivitatiAplicativeAsistate = numarActivitatiAplicativeAsistate;
	}

	public String getCategorieFormativaLicenta() {
		return categorieFormativaLicenta;
	}

	public void setCategorieFormativaLicenta(String categorieFormativaLicenta) {
		this.categorieFormativaLicenta = categorieFormativaLicenta;
	}
}
