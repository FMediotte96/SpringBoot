package com.jpa.demo.service;

import com.jpa.demo.model.Categoria;
import com.jpa.demo.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository repoCategorias;

    /**
     * Método save - Interfaz CrudRepository
     */
    public void save() {
        Categoria cat = new Categoria();
        cat.setNombre("Finanzas");
        cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
        repoCategorias.save(cat);
        System.out.println(cat);
    }

    /**
     * Método findById - Interfaz CrudRepository
     */
    public void getById() {
        Optional<Categoria> optional = repoCategorias.findById(1);
        if(optional.isPresent())
            System.out.println(optional.get());
        else
            System.out.println("Categoria no encontrada");
    }

    /**
     * Método update - save Interfaz CrudRepository
     */
    public void update() {
        Optional<Categoria> optional = repoCategorias.findById(2);
        if(optional.isPresent()) {
            Categoria catTmp = optional.get();
            catTmp.setNombre("Ing. de Software");
            catTmp.setDescripcion("Desarrollo de sistemas");
            repoCategorias.save(catTmp);
            System.out.println(optional.get());
        }
        else
            System.out.println("Categoria no encontrada");
    }

    /**
     * Método deleteById - Interfaz CrudRepository
     */
    public void delete() {
        int idCategoria = 1;
        repoCategorias.deleteById(idCategoria);
    }

    /**
     * Método count - Interfaz CrudRepository
     */
    public void count() {
        long count = repoCategorias.count();
        System.out.println("Total Categorias: " + count);
    }

    /**
     * Método deleteAll - Interfaz CrudRepository
     */
    public void deleteAll() {
        repoCategorias.deleteAll();
    }

    /**
     * Método findAllById - Interfaz CrudRepository
     */
    public void findAllByIds() {
        List<Integer> ids = new LinkedList<Integer>();
        ids.add(1);
        ids.add(4);
        ids.add(10);
        Iterable<Categoria> categorias = repoCategorias.findAllById(ids);
        for(Categoria cat : categorias) {
            System.out.println(cat);
        }
    }

    /**
     * Método findAll - Interfaz CrudRepository
     */
    public void getAll() {
        Iterable <Categoria> categorias = repoCategorias.findAll();
        for(Categoria cat : categorias) {
            System.out.println(cat);
        }
    }

    /**
     * Método existsById - Interfaz CrudRepository
     */
    public void existsById() {
        boolean existe = repoCategorias.existsById(50);
        System.out.println("La categoria existe: " + existe);
    }

    /**
     * Método saveAll - Interfaz CrudRepository
     */
    public void saveAll() {
        List<Categoria> categorias = getListaCategorias();
        repoCategorias.saveAll(categorias);
    }

    /**
     * Método que regresa una lista de 3 Categorias
     * @return
     */
    public List<Categoria> getListaCategorias() {
        List<Categoria> lista = new LinkedList<Categoria>();
        //Categoria 1
        Categoria cat1 = new Categoria();
        cat1.setNombre("Programador de Blockchain");
        cat1.setDescripcion("Trabajos relacionados con Bitcoin y Criptomonedas");

        //Categoria 2
        Categoria cat2 = new Categoria();
        cat2.setNombre("Soldador/Pintura");
        cat2.setDescripcion("Trabajos relacionados con soldadura, pintura y enderezado");

        //Categoria 3
        Categoria cat3 = new Categoria();
        cat3.setNombre("Ingeniero Industrial");
        cat3.setDescripcion("Trabajos relacionados con Ingenieria Industrial.");

        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);

        return lista;
    }

    /**
     * Método findAll - Interfaz JpaRepository
     */
    public void findAllJpa() {
        List<Categoria> categorias = repoCategorias.findAll();
        for(Categoria c : categorias) {
            System.out.println(c.getId() + " " + c.getNombre());
        }
    }

    /**
     * Método deleteAllInBatch [Usar con precaución] - Interfaz JpaRepository
     */
    public void deleteAllInBlock() {
        repoCategorias.deleteAllInBatch();
    }

    /**
     * Método findAll [Ordenados por un campo] - Interfaz PagingAndSortingRepository
     */
    public void findAllOrdered() {
        List<Categoria> categorias = repoCategorias.findAll(Sort.by("nombre").descending());
        for(Categoria c : categorias) {
            System.out.println(c.getId() + " " + c.getNombre());
        }
    }

    /**
     * Método findAll [Con paginación] - Interfaz PagingAndSortingRepository
     */
    public void findAllPaginated() {
        Page<Categoria> page = repoCategorias.findAll(PageRequest.of(0, 5));
        System.out.println("Total Registros: " + page.getTotalElements());
        System.out.println("Total Páginas: " + page.getTotalPages());
        for(Categoria c : page.getContent()) {
            System.out.println(c.getId() + " " + c.getNombre());
        }
    }

    /**
     * Método findAll [Con Paginación y Ordenados] - Interfaz PagingAndSortingRepository
     */
    public void findAllPaginatedAndOrdered() {
        Page<Categoria> page = repoCategorias.findAll(PageRequest.of(0, 5, Sort.by("nombre").descending()));
        System.out.println("Total Registros: " + page.getTotalElements());
        System.out.println("Total Páginas: " + page.getTotalPages());
        for(Categoria c : page.getContent()) {
            System.out.println(c.getId() + " " + c.getNombre());
        }
    }
}
