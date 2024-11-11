package ro.upt.ac.planuri.discipline;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discipline
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	
}