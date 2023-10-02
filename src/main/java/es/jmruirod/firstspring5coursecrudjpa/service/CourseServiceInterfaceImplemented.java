package es.jmruirod.firstspring5coursecrudjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring5coursecrudjpa.dao.CourseDao;
import es.jmruirod.firstspring5coursecrudjpa.model.Course;

/**
 * Implementación de la interfaz CourseServiceInterface que gestiona la lógica de los cursos.
 * Proporciona operaciones CRUD para cursos y una consulta personalizada para buscar cursos por rango de precio.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Service
public class CourseServiceInterfaceImplemented implements CourseServiceInterface
{
    @Autowired
    private CourseDao courseDao;

    /**
     * Obtiene una lista de todos los cursos.
     * 
     * @return Lista de cursos.
     */
    @Override
    public List<Course> getAll() 
    {
        return this.courseDao.findAll();
    }
    
    /**
     * Crea un nuevo curso.
     *
     * @param course El curso que se va a crear.
     * @return Una lista de cursos actualizada después de agregar el nuevo curso.
     */
    @Override
    public List<Course> create(Course course) 
    {
        this.courseDao.save(course);
        return this.courseDao.findAll();
    }

    /**
     * Elimina un curso por su ID.
     *
     * @param id El ID del curso que se va a eliminar.
     * @return Una lista de cursos actualizada después de eliminar el curso.
     */
    @Override
    public List<Course> delete(int id) 
    {
        this.courseDao.deleteById(id);
        return this.courseDao.findAll();
    }

    /**
     * Actualiza la duración de un curso por su ID.
     *
     * @param id       El ID del curso que se va a actualizar.
     * @param duration La nueva duración del curso.
     */
    @Override
    public void updateDuration(int id, int duration) 
    {
        Course course = this.findById(id);
        course.setDuration(duration);
        this.courseDao.save(course);
    }

    /**
     * Busca un curso por su ID.
     *
     * @param id El ID del curso que se va a buscar.
     * @return El curso encontrado o null si no se encuentra.
     */
    @Override
    public Course findById(int id) 
    {
        return this.courseDao.findById(id).orElse(null);
    }

    /**
     * Obtiene una lista de cursos cuyos precios se encuentran dentro de un rango especificado.
     *
     * @param minPrice El precio mínimo del rango.
     * @param maxPrice El precio máximo del rango.
     * @return Una lista de cursos que cumplen con el rango de precio especificado.
     */
    @Override
    public List<Course> getByPriceRange(int minPrice, int maxPrice) 
    {
        return this.courseDao.getByPriceRange(minPrice, maxPrice);
    }
}
