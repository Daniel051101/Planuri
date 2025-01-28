package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaId extends Disciplina 
{
	private String categorieFormativaLicenta;
	private int numarOreActivitatiAutoinstruire;
	private int numarOreActivitatiTutorat;
	private int numarTemeDeControl;
	private int numarActivitatiAplicativeAsistate;
	
	public DisciplinaId()
	{
	}

	public int getNumarOreActivitatiAutoinstruire() {
		return numarOreActivitatiAutoinstruire;
	}

	public void setNumarOreActivitatiAutoinstruire(int numarOreActivitatiAutoinstruire) {
		this.numarOreActivitatiAutoinstruire = numarOreActivitatiAutoinstruire;
	}

	public int getNumarOreActivitatiTutorat() {
		return numarOreActivitatiTutorat;
	}

	public void setNumarOreActivitatiTutorat(int numarOreActivitatiTutorat) {
		this.numarOreActivitatiTutorat = numarOreActivitatiTutorat;
	}

	public int getNumarTemeDeControl() {
		return numarTemeDeControl;
	}

	public void setNumarTemeDeControl(int numarTemeDeControl) {
		this.numarTemeDeControl = numarTemeDeControl;
	}

	public int getNumarActivitatiAplicativeAsistate() {
		return numarActivitatiAplicativeAsistate;
	}

	public void setNumarActivitatiAplicativeAsistate(int numarActivitatiAplicativeAsistate) {
		this.numarActivitatiAplicativeAsistate = numarActivitatiAplicativeAsistate;
	}

	public String getCategorieFormativaLicenta() {
		return categorieFormativaLicenta;
	}

	public void setCategorieFormativaLicenta(String categorieFormativaLicenta) {
		this.categorieFormativaLicenta = categorieFormativaLicenta;
	}
	
	public String toString()
	{
		return ""+categorieFormativaLicenta+" "+numarOreActivitatiAutoinstruire+" "+numarOreActivitatiTutorat+" "+numarTemeDeControl+" "+numarActivitatiAplicativeAsistate;
	}
}
