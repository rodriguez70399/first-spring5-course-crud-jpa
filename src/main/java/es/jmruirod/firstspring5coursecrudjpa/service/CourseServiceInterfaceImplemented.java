package es.jmruirod.firstspring5coursecrudjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring5coursecrudjpa.dao.CourseDao;
import es.jmruirod.firstspring5coursecrudjpa.model.Course;


/**
 * Implementación de la interfaz CourseServiceInterface que gestiona la lógica de los cursos.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Service
public class CourseServiceInterfaceImplemented implements CourseServiceInterface
{
    @Autowired
    private CourseDao courseDao;
    
    @Override
    public List<Course> create(Course course) 
    {
        this.courseDao.save(course);
        return this.courseDao.findAll();
    }

    @Override
    public List<Course> delete(int id) 
    {
        this.courseDao.deleteById(id);
        return this.courseDao.findAll();
    }

    @Override
    public Course findById(int id) 
    {
        return this.courseDao.findById(id).orElse(null);
    }

    @Override
    public void updateDuration(int id, int duration) 
    {
        Course course = this.findById(id);
        course.setDuration(duration);
    }

    @Override
    public List<Course> getByPriceRange(int minPrice, int maxPrice) 
    {
        return this.courseDao.getByPriceRange(minPrice, maxPrice);
    }
}