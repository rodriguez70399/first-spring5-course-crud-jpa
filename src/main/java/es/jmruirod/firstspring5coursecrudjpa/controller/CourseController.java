package es.jmruirod.firstspring5coursecrudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jmruirod.firstspring5coursecrudjpa.model.Course;
import es.jmruirod.firstspring5coursecrudjpa.service.CourseServiceInterface;

/**
 * Controlador Spring Boot para la gestión de cursos.
 * Este controlador proporciona endpoints para crear, eliminar, buscar y actualizar cursos.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@RestController
public class CourseController 
{
    @Autowired
    private CourseServiceInterface service;

    /**
     * Obtiene una lista de todos los cursos.
     * 
     * @return Lista de cursos en formato JSON.
     * @apiNote Método GET para obtener todos los cursos.
     * @apiNote Dirección: /courses
     */
    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getAll()
    {
        return this.service.getAll();
    }

    /**
     * Crea un nuevo curso.
     *
     * @param course El curso que se va a crear en formato JSON.
     * @return Una lista de cursos actualizada después de agregar el nuevo curso.
     * @apiNote POST /course
     */
    @PostMapping(value = "course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> create(@RequestBody Course course)
    {
        return this.service.create(course);
    }

    /**
     * Elimina un curso por su ID.
     *
     * @param id El ID del curso que se va a eliminar.
     * @return Una lista de cursos actualizada después de eliminar el curso.
     * @apiNote DELETE /course/1
     */
    @DeleteMapping(value = "course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> delete(@PathVariable int id)
    {
        return this.service.delete(id);
    }

    /**
     * Actualiza la duración de un curso por su ID.
     *
     * @param id       El ID del curso que se va a actualizar.
     * @param duration La nueva duración del curso.
     * @apiNote PUT /course/1?duration=20
     */
    @PutMapping(value = "course/{id}")
    public void updateDutation(@PathVariable int id, @RequestParam int duration)
    {
        this.service.updateDuration(id, duration);
    }

    /**
     * Busca un curso por su ID.
     *
     * @param id El ID del curso que se va a buscar.
     * @return El curso encontrado o null si no se encuentra.
     * @apiNote GET /course/1
     */
    @GetMapping(value="course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findById(@PathVariable int id)
    {
        return this.service.findById(id);
    }

    /**
     * Obtiene una lista de cursos cuyos precios se encuentran dentro de un rango
     * especificado.
     *
     * @param minPrice El precio mínimo del rango.
     * @param maxPrice El precio máximo del rango.
     * @return Una lista de cursos que cumplen con el rango de precio especificado.
     * @apiNote GET /course?minPrice=100&maxPrice=500
     */
    @GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getByPriceRange(@RequestParam("minPrice") int minPrice, @RequestParam("maxPrice") int maxPrice)
    {
        return this.service.getByPriceRange(minPrice, maxPrice);
    }    
}