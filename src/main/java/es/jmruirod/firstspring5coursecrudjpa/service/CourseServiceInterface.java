package es.jmruirod.firstspring5coursecrudjpa.service;

import java.util.List;

import es.jmruirod.firstspring5coursecrudjpa.model.Course;


/**
 * Interfaz que define los métodos para el servicio de gestión de cursos.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public interface CourseServiceInterface 
{
    /**
     * Obtiene una lista de todos los cursos.
     * 
     * @return Lista de cursos.
     */
    public List<Course> getAll();

    /**
     * Crea un nuevo curso.
     *
     * @param course El curso que se va a crear.
     * @return Una lista de cursos actualizada después de agregar el nuevo curso.
     */
    public List<Course> create(Course course);

    /**
     * Elimina un curso por su ID.
     *
     * @param id El ID del curso que se va a eliminar.
     * @return Una lista de cursos actualizada después de eliminar el curso.
     */
    public List<Course> delete(int id);

    /**
     * Actualiza la duración de un curso por su ID.
     *
     * @param id       El ID del curso que se va a actualizar.
     * @param duration La nueva duración del curso.
     */
    public void updateDuration(int id, int duration);

    /**
     * Busca un curso por su ID.
     *
     * @param id El ID del curso que se va a buscar.
     * @return El curso encontrado o null si no se encuentra.
     */
    public Course findById(int id);
    
    /**
     * Obtiene una lista de cursos cuyos precios se encuentran dentro de un rango
     * especificado.
     *
     * @param minPrice El precio mínimo del rango.
     * @param maxPrice El precio máximo del rango.
     * @return Una lista de cursos que cumplen con el rango de precio especificado.
     */
    public List<Course> getByPriceRange(int minPrice, int maxPrice);
}