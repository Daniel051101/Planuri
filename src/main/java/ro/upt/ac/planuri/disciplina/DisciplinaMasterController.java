package ro.upt.ac.planuri.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ro.upt.ac.planuri.plan.PlanInvatamantMaster;
import ro.upt.ac.planuri.plan.PlanInvatamantMasterRepository;

@Controller
public class DisciplinaMasterController
{
	@Autowired
	DisciplinaMasterRepository disciplinaMasterRepository;

	@Autowired
	PlanInvatamantMasterRepository planInvatamantMasterRepository;

	@GetMapping("/disciplinaMaster-create")
	public String create(DisciplinaMaster disciplinaMaster)
	{
		return "disciplinaMaster-create";
	}

	@PostMapping("/disciplinaMaster-create-save")
	public String createSave(@Validated DisciplinaMaster disciplinaMaster, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "disciplinaMaster-create";
		}
		disciplinaMasterRepository.save(disciplinaMaster);
		return "redirect:/disciplinaMaster-read";
	}
	
	@GetMapping("/disciplinaMaster-read")
	public String read(Model model) 
	{
	    model.addAttribute("disciplinaMaster", disciplinaMasterRepository.findAll());
	    return "disciplinaMaster-read";
	}

	@GetMapping("/disciplinaMaster-read/{id}")
	public String readByPlan(@PathVariable("id") int id, Model model) 
	{
		PlanInvatamantMaster pim = planInvatamantMasterRepository.findById(id);
	    model.addAttribute("disciplinaMaster",pim.getListaDisciplinaMaster());
	    return "disciplinaMaster-read";
	}

	@GetMapping("/disciplinaMaster-edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) 
	{
	    DisciplinaMaster disciplinaMaster = disciplinaMasterRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
	    model.addAttribute("disciplinaMaster", disciplinaMaster);
	    return "disciplinaMaster-update";
	}
	
	@PostMapping("/disciplinaMaster-update/{id}")
	public String update(@PathVariable("id") int id, @Validated DisciplinaMaster disciplinaMaster, BindingResult result, Model model) 
	{
	    if(result.hasErrors()) 
	    {
	    	disciplinaMaster.setId(id);
	        return "disciplinaMaster-update";
	    }
	        
	    disciplinaMasterRepository.save(disciplinaMaster);
	    return "redirect:/disciplinaMaster-read";
	}
	
	@GetMapping("/disciplinaMaster-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) 
	{
		DisciplinaMaster disciplinaMaster = disciplinaMasterRepository.findById(id);
	    //.orElseThrow(() -> new IllegalArgumentException("Invalid plan Id:" + id));
	    
		disciplinaMasterRepository.delete(disciplinaMaster);
	    return "redirect:/disciplinaMaster-read";
	}	
}
