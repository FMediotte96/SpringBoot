package com.jpa.demo.service;

import com.jpa.demo.model.Perfil;
import com.jpa.demo.repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PerfilesService {

    @Autowired
    private PerfilesRepository repoPerfiles;

    /**
     * Método para crear Perfiles/Roles
     */
    public void savePerfilesApplication() {
        repoPerfiles.saveAll(getPerfilesApplication());
    }

    /**
     * Método que regresa una lista de objetos de tipo Perfil que representa los diferentes PERFILES
     * o ROLES que tendremos en nuestra aplicación de Empleos
     * @return
     */
    private List<Perfil> getPerfilesApplication() {
        List<Perfil> lista = new LinkedList<Perfil>();
        Perfil per1 = new Perfil();
        per1.setPerfil("SUPERVISOR");

        Perfil per2 = new Perfil();
        per2.setPerfil("ADMINISTRADOR");

        Perfil per3 = new Perfil();
        per3.setPerfil("USUARIO");

        lista.add(per1);
        lista.add(per2);
        lista.add(per3);

        return lista;
    }
}
