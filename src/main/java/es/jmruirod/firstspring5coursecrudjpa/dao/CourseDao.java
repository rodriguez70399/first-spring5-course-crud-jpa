package es.jmruirod.firstspring5coursecrudjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.jmruirod.firstspring5coursecrudjpa.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer>
{
    @Query("SELECT c FROM Course c WHERE c.price BETWEEN :minPrice AND :maxPrice")
    public List<Course> getByPriceRange(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);
}
