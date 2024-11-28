package ro.upt.ac.planuri.disciplina;

public enum TCategorieFormativa 
{
	DC("Disciplina complementara","DC"),
	DD("Disciplina in domeniu","DD"), 
	DF("Disciplina fundamentala",("DF")),
	DS("Disciplina de specialitate","DS"); 


	private String numeLung;
	private String numeScurt;

	TCategorieFormativa(String numeLung, String numeScurt)
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
