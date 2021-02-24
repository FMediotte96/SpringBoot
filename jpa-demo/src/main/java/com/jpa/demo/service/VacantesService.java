package com.jpa.demo.service;

import com.jpa.demo.model.Categoria;
import com.jpa.demo.model.Vacante;
import com.jpa.demo.repository.VacantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VacantesService {

    @Autowired
    private VacantesRepository repoVacantes;

    /**
     * Método findAll() - Interfaz JpaRepository
     */
    public void getAllVacantes() {
        List<Vacante> lista = repoVacantes.findAll();
        for (Vacante v : lista) {
            System.out.println(v.getId() + " " + v.getNombre() + "->" + v.getCategoria().getNombre());
        }
    }

    /**
     * Método save() - Interfaz CrudRepository
     */
    public void saveVacante() {
        Vacante vacante = new Vacante();
        vacante.setNombre("Profesor de Matemática");
        vacante.setDescripcion("Escuela primaria solicita profesor para curso de Matemáticas");
        vacante.setFecha(new Date());
        vacante.setSalario(85000.0);
        vacante.setStatus("Aprobada");
        vacante.setDestacado(0);
        vacante.setImagen("escuela.png");
        vacante.setDetalles("<h1>Los requisitos para profesor de Matemáticas</h1>");
        Categoria cat = new Categoria();
        cat.setId(15);
        vacante.setCategoria(cat);

        repoVacantes.save(vacante);
    }

    /**
     * Query Method: buscar vacantes por status
     */
    public void findByStatus() {
        List<Vacante> lista = repoVacantes.findByStatus("Eliminada");
        System.out.println("Registros encontrados: " + lista.size());
        for(Vacante v : lista) {
            System.out.println(v.getId() + ": " + v.getNombre() + ": " + v.getStatus());
        }
    }

    /**
     * Query Method: Buscar Vacantes por Destacado y Status Ordenado por Id Desc
     */
    public void getVacantesByDestacadoAndStatus() {
        List<Vacante> lista = repoVacantes.findByDestacadoAndStatusOrderByIdDesc(1, "Aprobada");
        System.out.println("Registros encontrados: " + lista.size());
        for(Vacante v : lista) {
            System.out.println(v.getId() + ": " + v.getNombre() + ": " + v.getStatus() + ": " + v.getDestacado());
        }
    }

    /**
     * Query Method: Buscar Vacantes rango de Salario (Between)
     */
    public void getVacantesSalario() {
        List<Vacante> lista = repoVacantes.findBySalarioBetweenOrderBySalarioDesc(7000, 14000);
        System.out.println("Registros encontrados: " + lista.size());
        for(Vacante v : lista) {
            System.out.println(v.getId() + ": " + v.getNombre() + ": $" + v.getSalario());
        }
    }

    /**
     * Query Method: Buscar Vacantes por varios Status (In)
     */
    public void getVacantesVariosStatus() {
        String[] status = new String[]{"Eliminada", "Aprobada"};
        List<Vacante> lista = repoVacantes.findByStatusIn(status);
        System.out.println("Registros encontrados: " + lista.size());
        for(Vacante v : lista) {
            System.out.println(v.getId() + ": " + v.getNombre() + ": " + v.getStatus());
        }
    }

}
