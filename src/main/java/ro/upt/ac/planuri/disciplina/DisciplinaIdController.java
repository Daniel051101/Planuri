package ro.upt.ac.planuri.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ro.upt.ac.planuri.plan.PlanInvatamantLicenta;
import ro.upt.ac.planuri.plan.PlanInvatamantLicentaRepository;

@Controller
public class DisciplinaIdController
{
	@Autowired
	DisciplinaIdRepository disciplinaIdRepository;
	
	@Autowired
	PlanInvatamantLicentaRepository planInvatamantLicentaRepository;

	@GetMapping("/disciplinaId-create")
	public String create(DisciplinaId disciplinaId)
	{
		return "disciplinaId-create";
	}

	@PostMapping("/disciplinaId-create-save")
	public String createSave(@Validated DisciplinaId disciplinaId, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "disciplinaId-create";
		}
		disciplinaIdRepository.save(disciplinaId);
		return "redirect:/disciplinaId-read";
	}
	
	@GetMapping("/disciplinaId-read")
	public String read(Model model) 
	{
	    model.addAttribute("disciplinaId", disciplinaIdRepository.findAll());
	    return "disciplinaId-read";
	}
	
	@GetMapping("/disciplinaId-read/{id}")
	public String readByPlan(@PathVariable("id") int id, Model model) 
	{
		PlanInvatamantLicenta pil = planInvatamantLicentaRepository.findById(id);
	    model.addAttribute("disciplinaMaster",pil.getListaDisciplinaId());
	    return "disciplinaMaster-read";
	}
	
	@GetMapping("/disciplinaId-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    DisciplinaId disciplinaId = disciplinaIdRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("disciplinaId", disciplinaId);
	    return "disciplinaId-update";
	}
	
	@PostMapping("/disciplinaId-update/{id}")
	public String update(@PathVariable("id") int id, @Validated DisciplinaId disciplinaId, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	    	disciplinaId.setId(id);
	        return "disciplinaId-update";
	    }
	        
	    disciplinaIdRepository.save(disciplinaId);
	    return "redirect:/disciplinaId-read";
	}
	
	@GetMapping("/disciplinaId-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
		DisciplinaId disciplinaId = disciplinaIdRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
		disciplinaIdRepository.delete(disciplinaId);
	    return "redirect:/disciplinaId-read";
	}	
}
