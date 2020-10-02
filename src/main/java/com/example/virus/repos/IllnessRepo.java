package com.example.virus.repos;

import com.example.virus.model.Illness;
import org.springframework.data.repository.CrudRepository;

public interface IllnessRepo extends CrudRepository<Illness,Long> {
}
