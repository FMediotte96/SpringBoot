package com.jpa.demo.service;

import com.jpa.demo.model.Perfil;
import com.jpa.demo.model.Usuario;
import com.jpa.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuariosServices {

    @Autowired
    private UsuariosRepository repoUsuarios;

    /**
     * Crear un usuario con 2 perfiles ("ADMINISTRADOR", "USUARIO")
     */
    public void createUsuarioConDosPerfiles() {
        Usuario user = new Usuario();
        user.setNombre("Facundo Mediotte");
        user.setEmail("facumediotte@gmail.com");
        user.setFechaRegistro(new Date());
        user.setUsername("fmediotte");
        user.setPassword("12345");
        user.setStatus(1);

        Perfil per1 = new Perfil();
        per1.setId(2);

        Perfil per2 = new Perfil();
        per2.setId(3);

        user.agregar(per1);
        user.agregar(per2);

        repoUsuarios.save(user);
    }

    /**
     * Método para buscar un usuario y desplegar sus perfiles asociados
     */
    public void findById() {
        Optional<Usuario> optional = repoUsuarios.findById(1);
        if(optional.isPresent()) {
            Usuario u = optional.get();
            System.out.println("Usuario: " + u.getNombre());
            System.out.println("Perfiles asignados:");
            for(Perfil p : u.getPerfiles()) {
                System.out.println(p.getPerfil());
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
}
