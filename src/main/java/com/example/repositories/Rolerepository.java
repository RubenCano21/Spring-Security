package com.example.repositories;

import com.example.models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rolerepository extends CrudRepository<RoleEntity, Long> {



}
