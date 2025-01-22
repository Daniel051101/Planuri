package ro.upt.ac.planuri.plan;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import ro.upt.ac.planuri.disciplina.DisciplinaId;
import ro.upt.ac.planuri.disciplina.DisciplinaZi;

@Entity
public class PlanInvatamantLicenta extends PlanInvatamant 
{
	private String domeniuDeLicenta;
	private String programDeStudiiLicenta;
	private int codDomeniuDeLicenta;
	private int codStudii;
	private int durataStudiiLicenta;

	// un plan de invatamant are mai multe discipline
	@OneToMany
	private List<DisciplinaZi> listaDisciplinaZi=new ArrayList<DisciplinaZi>();
	
	@OneToMany
	private List<DisciplinaId> listaDisciplinaId=new ArrayList<DisciplinaId>();

	public List<DisciplinaZi> getListaDisciplinaZi() {
		return listaDisciplinaZi;
	}

	public void setListaDisciplinaZi(List<DisciplinaZi> listaDisciplinaZi) {
		this.listaDisciplinaZi = listaDisciplinaZi;
	}

	public List<DisciplinaId> getListaDisciplinaId() {
		return listaDisciplinaId;
	}

	public void setListaDisciplinaId(List<DisciplinaId> listaDisciplinaId) {
		this.listaDisciplinaId = listaDisciplinaId;
	}

	public PlanInvatamantLicenta() {
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

	public int getCodDomeniuDeLicenta() {
		return codDomeniuDeLicenta;
	}

	public void setCodDomeniuDeLicenta(int codDomeniuDeLicenta) {
		this.codDomeniuDeLicenta = codDomeniuDeLicenta;
	}

	public int getCodStudii() {
		return codStudii;
	}

	public void setCodStudii(int codStudii) {
		this.codStudii = codStudii;
	}

	public int getDurataStudiiLicenta() {
		return durataStudiiLicenta;
	}

	public void setDurataStudiiLicenta(int durataStudiiLicenta) {
		this.durataStudiiLicenta = durataStudiiLicenta;
	}

}
