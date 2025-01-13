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
public class PlanInvatamantLicentaController
{
	@Autowired
	PlanInvatamantLicentaRepository planInvatamantLicentaRepository;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "signup";
	}

	@GetMapping("/planInvatamantLicenta-create")
	public String create(PlanInvatamantLicenta planInvatamantLicenta)
	{
		return "planInvatamantLicenta-create";
	}

	@PostMapping("/planInvatamantLicenta-create-save")
	public String createSave(@Validated PlanInvatamantLicenta planInvatamantLicenta, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "planInvatamantLicenta-create";
		}
		planInvatamantLicentaRepository.save(planInvatamantLicenta);
		return "redirect:/planInvatamantLicenta-read";
	}
	
	@GetMapping("/planInvatamantLicenta-read")
	public String read(Model model) 
	{
	    model.addAttribute("planInvatamantLicenta", planInvatamantLicentaRepository.findAll());
	    return "planInvatamantLicenta-read";
	}
	
	@GetMapping("/planInvatamantLicenta-view/{id}")
	public String view(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamantLicenta planInvatamantLicenta = planInvatamantLicentaRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("planInvatamantLicenta", planInvatamantLicenta);
	    return "planInvatamantLicenta-view";
	}

	
	@GetMapping("/planInvatamantLicenta-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamantLicenta planInvatamantLicenta = planInvatamantLicentaRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("planInvatamantLicenta", planInvatamantLicenta);
	    return "planInvatamantLicenta-update";
	}
	
	@PostMapping("/planInvatamantLicenta-update/{id}")
	public String update(@PathVariable("id") int id, @Validated PlanInvatamantLicenta planInvatamantLicenta, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	        planInvatamantLicenta.setId(id);
	        return "planInvatamantLicenta-update";
	    }
	        
	    planInvatamantLicentaRepository.save(planInvatamantLicenta);
	    return "redirect:/planInvatamantLicenta-read";
	}
	
	@GetMapping("/planInvatamantLicenta-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
	    PlanInvatamantLicenta planInvatamantLicenta = planInvatamantLicentaRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    planInvatamantLicentaRepository.delete(planInvatamantLicenta);
	    return "redirect:/planInvatamantLicenta-read";
	}	
}
