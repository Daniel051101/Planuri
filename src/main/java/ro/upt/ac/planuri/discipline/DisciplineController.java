package ro.upt.ac.planuri.discipline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DisciplineController
{
	@Autowired
	DisciplineRepository disciplineRepository;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}

	@GetMapping("/discipline-create")
	public String create(Discipline discipline)
	{
		return "discipline-create";
	}

	@PostMapping("/discipline-create-save")
	public String createSave(@Validated Discipline discipline, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "discipline-create";
		}
		disciplineRepository.save(discipline);
		return "redirect:/discipline-read";
	}
	
	@GetMapping("/discipline-read")
	public String read(Model model) 
	{
	    model.addAttribute("discipline", disciplineRepository.findAll());
	    return "discipline-read";
	}
	
	@GetMapping("/discipline-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    Discipline discipline = disciplineRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("plan", discipline);
	    return "discipline-update";
	}
	
	@PostMapping("/discipline-update/{id}")
	public String update(@PathVariable("id") int id, @Validated Discipline discipline, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	    	discipline.setId(id);
	        return "discipline-update";
	    }
	        
	    disciplineRepository.save(discipline);
	    return "redirect:/discipline-read";
	}
	
	@GetMapping("/discipline-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
		Discipline discipline = disciplineRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
		disciplineRepository.delete(discipline);
	    return "redirect:/discipline-read";
	}	
}
