package ro.upt.ac.planuri.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlanInvatamantController
{
	@Autowired
	PlanInvatamantRepository planInvatamantRepository;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}

	@GetMapping("/PlanInvatamant-create")
	public String create(PlanInvatamant planInvatamant)
	{
		return "PlanInvatamant-create";
	}

	@PostMapping("/PlanInvatamant-create-save")
	public String createSave(@Validated PlanInvatamant planInvatamant, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "PlanInvatamant-create";
		}
		planInvatamantRepository.save(planInvatamant);
		return "redirect:/PlanInvatamant-read";
	}
	
	@GetMapping("/PlanInvatamant-read")
	public String read(Model model) 
	{
	    model.addAttribute("PlanInvatamant", planInvatamantRepository.findAll());
	    return "PlanInvatamant-read";
	}
	
	@GetMapping("/PlanInvatamant-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamant planInvatamant = planInvatamantRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("PlanInvatamant", planInvatamant);
	    return "PlanInvatamant-update";
	}
	
	@PostMapping("/PlanInvatamant-update/{id}")
	public String update(@PathVariable("id") int id, @Validated PlanInvatamant planInvatamant, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	        planInvatamant.setId(id);
	        return "PlanInvatamant-update";
	    }
	        
	    planInvatamantRepository.save(planInvatamant);
	    return "redirect:/PlanInvatamant-read";
	}
	
	@GetMapping("/PlanInvatamant-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamant planInvatamant = planInvatamantRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    planInvatamantRepository.delete(planInvatamant);
	    return "redirect:/PlanInvatamant-read";
	}	
}
