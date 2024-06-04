package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Size(max = 80)
    private String email;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, /* trae todo los roles */
            targetEntity = RoleEntity.class, //realciona con la clase
            cascade = CascadeType.PERSIST) //solo elimina cuando se invoque al usuario

    @JoinTable(name = "user_roles", //nombre de la tabla intermedia entre User y Rol
    joinColumns = @JoinColumn(name ="userId"), //capta el id de la tabla USER
    inverseJoinColumns = @JoinColumn(name = "roleId")) //capta el ID de la tabla ROL
    private Set<RoleEntity> roles;
}
