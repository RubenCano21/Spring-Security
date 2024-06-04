package com.example.repositories;

import com.example.models.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);   //Opcion 1 por defecto de JPA

    @Query("select u from UserEntity u where u.username = ?1")// Opcion 2 -> personalizada a traves de la consulta
    Optional<UserEntity> getName(String username);


}
