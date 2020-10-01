package com.example.virus.repos;

import com.example.virus.model.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepo extends CrudRepository<People,Long> {
}
