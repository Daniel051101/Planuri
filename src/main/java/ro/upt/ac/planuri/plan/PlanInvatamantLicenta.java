package ro.upt.ac.planuri.plan;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import ro.upt.ac.planuri.disciplina.DisciplinaZi;

@Entity
public class PlanInvatamantLicenta extends PlanInvatamant {
	private String domeniuDeLicenta;
	private String programDeStudiiLicenta;
	private int codDomeniuDeLicenta;
	private int codStudii;

	// un plan de invatamant are mai multe discipline
	@OneToMany
	private List<DisciplinaZi> listaDisciplina=new ArrayList<DisciplinaZi>();

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

	public List<DisciplinaZi> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<DisciplinaZi> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}
}
