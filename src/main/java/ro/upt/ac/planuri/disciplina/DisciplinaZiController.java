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
public class DisciplinaZiController
{
	@Autowired
	DisciplinaZiRepository disciplinaZiRepository;

	@GetMapping("/disciplinaZi-create")
	public String create(DisciplinaZi disciplinaZi)
	{
		return "disciplinaZi-create";
	}

	@PostMapping("/disciplinaZi-create-save")
	public String createSave(@Validated DisciplinaZi disciplinaZi, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "disciplinaZi-create";
		}
		disciplinaZiRepository.save(disciplinaZi);
		return "redirect:/disciplinaZi-read";
	}
	
	@GetMapping("/disciplinaZi-read")
	public String read(Model model) 
	{
	    model.addAttribute("disciplinaZi", disciplinaZiRepository.findAll());
	    return "disciplinaZi-read";
	}
	
	@GetMapping("/disciplinaZi-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    DisciplinaZi disciplinaZi = disciplinaZiRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("disciplinaZi", disciplinaZi);
	    return "disciplinaZi-update";
	}
	
	@PostMapping("/disciplinaZi-update/{id}")
	public String update(@PathVariable("id") int id, @Validated DisciplinaZi disciplinaZi, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	    	disciplinaZi.setId(id);
	        return "disciplinaZi-update";
	    }
	        
	    disciplinaZiRepository.save(disciplinaZi);
	    return "redirect:/disciplinaZi-read";
	}
	
	@GetMapping("/disciplinaZi-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
		DisciplinaZi disciplinaZi = disciplinaZiRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
		disciplinaZiRepository.delete(disciplinaZi);
	    return "redirect:/disciplinaZi-read";
	}	
}
