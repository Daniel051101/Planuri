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
public class PlanInvatamantMasterController
{
	@Autowired
	PlanInvatamantMasterRepository planInvatamantMasterRepository;

	@GetMapping("/planInvatamantMaster-create")
	public String create(PlanInvatamantMaster planInvatamantMaster)
	{
		return "planInvatamantMaster-create";
	}

	@PostMapping("/planInvatamantMaster-create-save")
	public String createSave(@Validated PlanInvatamantMaster planInvatamantMaster, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "planInvatamantMaster-create";
		}
		planInvatamantMasterRepository.save(planInvatamantMaster);
		return "redirect:/planInvatamantMaster-read";
	}
	
	@GetMapping("/planInvatamantMaster-read")
	public String read(Model model) 
	{
	    model.addAttribute("planInvatamantMaster", planInvatamantMasterRepository.findAll());
	    return "planInvatamantMaster-read";
	}
	
	@GetMapping("/planInvatamantMaster-view/{id}")
	public String view(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamantMaster planInvatamantMaster = planInvatamantMasterRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("planInvatamantMaster", planInvatamantMaster);
	    return "planInvatamantMaster-view";
	}

	
	@GetMapping("/planInvatamantMaster-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamantMaster planInvatamantMaster = planInvatamantMasterRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("planInvatamantMaster", planInvatamantMaster);
	    return "planInvatamantMaster-update";
	}
	
	@PostMapping("/planInvatamantMaster-update/{id}")
	public String update(@PathVariable("id") int id, @Validated PlanInvatamantMaster planInvatamantMaster, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	        planInvatamantMaster.setId(id);
	        return "planInvatamantMaster-update";
	    }
	        
	    planInvatamantMasterRepository.save(planInvatamantMaster);
	    return "redirect:/planInvatamantMaster-read";
	}
	
	@GetMapping("/planInvatamantMaster-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamantMaster planInvatamantMaster = planInvatamantMasterRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    planInvatamantMasterRepository.delete(planInvatamantMaster);
	    return "redirect:/planInvatamantMaster-read";
	}	
}
