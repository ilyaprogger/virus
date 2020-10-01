package com.example.virus.repos;

import com.example.virus.model.Viruses;
import org.springframework.data.repository.CrudRepository;

public interface VirusesRepo extends CrudRepository<Viruses, Long> {
}
