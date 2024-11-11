package ro.upt.ac.planuri.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DisciplinaController
{
	@Autowired
	DisciplinaRepository disciplinaRepository;

//	@GetMapping("/")
//	public String index()
//	{
//		return "index";
//	}

	@GetMapping("/disciplina-create")
	public String create(Disciplina disciplina)
	{
		return "disciplina-create";
	}

	@PostMapping("/disciplina-create-save")
	public String createSave(@Validated Disciplina disciplina, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "disciplina-create";
		}
		disciplinaRepository.save(disciplina);
		return "redirect:/disciplina-read";
	}
	
	@GetMapping("/disciplina-read")
	public String read(Model model) 
	{
	    model.addAttribute("disciplina", disciplinaRepository.findAll());
	    return "disciplina-read";
	}
	
	@GetMapping("/disciplina-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    Disciplina disciplina = disciplinaRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("plan", disciplina);
	    return "disciplina-update";
	}
	
	@PostMapping("/disciplina-update/{id}")
	public String update(@PathVariable("id") int id, @Validated Disciplina disciplina, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	    	disciplina.setId(id);
	        return "disciplina-update";
	    }
	        
	    disciplinaRepository.save(disciplina);
	    return "redirect:/disciplina-read";
	}
	
	@GetMapping("/disciplina-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
		Disciplina disciplina = disciplinaRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
		disciplinaRepository.delete(disciplina);
	    return "redirect:/disciplina-read";
	}	
}
