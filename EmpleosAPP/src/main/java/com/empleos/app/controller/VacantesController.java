package com.empleos.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empleos.app.model.Vacante;
import com.empleos.app.service.ICategoriasService;
import com.empleos.app.service.IVacantesService;
import com.empleos.app.util.Utils;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacantesService serviceVacantes;

    @Autowired
    private ICategoriasService serviceCategorias;

    @GetMapping("/index")
    public String showIndex(Model model) {
        List<Vacante> vacantes = serviceVacantes.getAll();
        model.addAttribute("vacantes", vacantes);
        return "vacantes/listVacantes";
    }

    @GetMapping("/create")
    public String create(Vacante vacante, Model model) {
        model.addAttribute("categorias", serviceCategorias.getAll());
        return "vacantes/formVacante";
    }

    //Implementando Data Binding
    @PostMapping("/save")
    public String save(Vacante vacante, BindingResult result, RedirectAttributes attributes,
                       @RequestParam("archivoImagen") MultipartFile multiPart) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }

        if (!multiPart.isEmpty()) {
            String ruta = "/empleos/img-vacantes/"; // Linux/MAC
            //String ruta = "c:/empleos/img-vacantes/"; // Windows
            String nombreImagen = Utils.saveArchive(multiPart, ruta);
            if (nombreImagen != null) { // La imagen si se subio
                // Procesamos la variable nombreImagen
                vacante.setImagen(nombreImagen);
            }
        }

        serviceVacantes.save(vacante);
        System.out.println(vacante);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/vacantes/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int idVacante, Model model) {
        System.out.println("Borrando vacante con id: " + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String viewDetails(@PathVariable("id") int idVacante, Model model) {

        Vacante vacante = serviceVacantes.getById(idVacante);

        System.out.println("Vacante: " + vacante);
        model.addAttribute("vacante", vacante);

        //Buscar los detalles de la vacante en la base de datos

        return "detalle";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
