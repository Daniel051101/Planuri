package ro.upt.ac.planuri.plan;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import ro.upt.ac.planuri.disciplina.DisciplinaMaster;

@Entity
public class PlanInvatamantMaster extends PlanInvatamant
{
	private String programMaster; // numeProgram
	private String formatInvatamant;
	private String durataStudiilor; // 2 ani sa fie intreg
	private String domeniuStudiiMaster;
	private int codDomeniuStudiiMaster;
	
	// un plan de invatamant are mai multe discipline
	@OneToMany
	private List<DisciplinaMaster> listaDisciplina=new ArrayList<DisciplinaMaster>();

	public PlanInvatamantMaster()
	{
	}
	
	public String getProgramMaster() {
		return programMaster;
	}
	
	public void setProgramMaster(String programMaster) {
		this.programMaster = programMaster;
	}
	
	public String getFormatInvatamant() {
		return formatInvatamant;
	}
	
	public void setFormatInvatamant(String formatInvatamant) {
		this.formatInvatamant = formatInvatamant;
	}
	
	public String getDurataStudiilor() {
		return durataStudiilor;
	}
	
	public void setDurataStudiilor(String durataStudiilor) {
		this.durataStudiilor = durataStudiilor;
	}
	
	public String getDomeniuStudiiMaster() {
		return domeniuStudiiMaster;
	}
	
	public void setDomeniuStudiiMaster(String domeniuStudiiMaster) {
		this.domeniuStudiiMaster = domeniuStudiiMaster;
	}
	
	public int getCodDomeniuStudiiMaster() {
		return codDomeniuStudiiMaster;
	}
	
	public void setCodDomeniuStudiiMaster(int codDomeniuStudiiMaster) {
		this.codDomeniuStudiiMaster = codDomeniuStudiiMaster;
	}

	public List<DisciplinaMaster> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<DisciplinaMaster> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}
}
