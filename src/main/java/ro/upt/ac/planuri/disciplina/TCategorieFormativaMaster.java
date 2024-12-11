package ro.upt.ac.planuri.disciplina;

public enum TCategorieFormativaMaster 
{
	DA("Disciplina de aprofundare","DA"),
	DCAV("Disciplina de cunoastere avansata","DCAV"), 
	DS("Disciplina de sinteza","DS"),
	DC("Disciplina complementare","DC"); 


	private String numeLung;
	private String numeScurt;

	TCategorieFormativaMaster(String numeLung, String numeScurt)
	{
		this.numeLung=numeLung;
		this.numeScurt=numeScurt;
	}

	public String getNumeLung() 
	{
		return numeLung;
	}

	public String getNumeScurt() 
	{
		return numeScurt;
	}
}
