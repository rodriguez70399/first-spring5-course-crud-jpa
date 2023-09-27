package es.jmruirod.firstspring5coursecrudjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.jmruirod.firstspring5coursecrudjpa.model.Course;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Course.
 * Utiliza Spring Data JPA para proporcionar operaciones CRUD básicas.
 * Además, incluye una consulta personalizada para buscar cursos por rango de precio.
 */
public interface CourseDao extends JpaRepository<Course, Integer>
{
    /**
     * Busca cursos cuyo precio esté en el rango especificado.
     *
     * @param minPrice El precio mínimo del rango.
     * @param maxPrice El precio máximo del rango.
     * @return Una lista de cursos que cumplen con el rango de precio especificado.
     */
    @Query("SELECT c FROM Course c WHERE c.price BETWEEN :minPrice AND :maxPrice")
    public List<Course> getByPriceRange(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);
}