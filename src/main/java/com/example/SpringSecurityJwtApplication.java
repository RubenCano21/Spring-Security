package com.example;

import com.example.models.ERole;
import com.example.models.RoleEntity;
import com.example.models.UserEntity;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {

			UserEntity userEntity = UserEntity.builder()
					.email("juan@gmail.com")
					.username("juan")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			UserEntity userEntity1 = UserEntity.builder()
					.email("pedro@gmail.com")
					.username("pedro")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();

			UserEntity userEntity2 = UserEntity.builder()
					.email("carlos@gmail.com")
					.username("carlos")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.INVITAD.name()))
							.build()))
					.build();

			userRepository.save(userEntity);
			userRepository.save(userEntity1);
			userRepository.save(userEntity2);
		};
	}

}
