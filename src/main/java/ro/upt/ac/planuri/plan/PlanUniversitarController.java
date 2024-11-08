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
public class PlanUniversitarController
{
	@Autowired
	PlanUniversitarRepository planUniversitarRepository;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}

	@GetMapping("/plan-create")
	public String create(PlanUniversitar planUniversitar)
	{
		return "plan-create";
	}

	@PostMapping("/plan-create-save")
	public String createSave(@Validated PlanUniversitar planUniversitar, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "plan-create";
		}
		planUniversitarRepository.save(planUniversitar);
		return "redirect:/plan-read";
	}
	
	@GetMapping("/plan-read")
	public String read(Model model) 
	{
	    model.addAttribute("plan", planUniversitarRepository.findAll());
	    return "plan-read";
	}
	
	@GetMapping("/plan-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    PlanUniversitar planUniversitar = planUniversitarRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("plan", planUniversitar);
	    return "plan-update";
	}
	
	@PostMapping("/plan-update/{id}")
	public String update(@PathVariable("id") int id, @Validated PlanUniversitar planUniversitar, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	        planUniversitar.setId(id);
	        return "companie-update";
	    }
	        
	    planUniversitarRepository.save(planUniversitar);
	    return "redirect:/plan-read";
	}
	
	@GetMapping("/plan-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
	    PlanUniversitar planUniversitar = planUniversitarRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    planUniversitarRepository.delete(planUniversitar);
	    return "redirect:/plan-read";
	}	
}
