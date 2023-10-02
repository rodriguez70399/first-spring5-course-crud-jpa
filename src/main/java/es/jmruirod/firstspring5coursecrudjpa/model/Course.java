package es.jmruirod.firstspring5coursecrudjpa.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase modelo para un curso.
 * Representa un curso con sus atributos básicos.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Entity
public class Course 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;
    private int price;

    /**
     * Constructor por defecto de la clase Course.
     */
    public Course() 
    {

    }

    /**
     * Constructor de la clase Course con parámetros.
     *
     * @param name     El nombre del curso.
     * @param duration La duración del curso en horas.
     * @param price    El precio del curso.
     */
    public Course(String name, int duration, int price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    /**
     * Constructor de la clase Course con parámetros que incluyen el ID.
     *
     * @param id       El ID del curso.
     * @param name     El nombre del curso.
     * @param duration La duración del curso en horas.
     * @param price    El precio del curso.
     */
    public Course(int id, String name, int duration, int price) 
    {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    /**
     * Obtiene el ID del curso.
     *
     * @return El ID del curso.
     */
    public int getId() 
    {
        return this.id;
    }

    /**
     * Establece el ID del curso.
     *
     * @param id El ID del curso.
     */
    public void setId(int id) 
    {
        this.id = id;
    }

    /**
     * Obtiene el nombre del curso.
     *
     * @return El nombre del curso.
     */
    public String getName() 
    {
        return this.name;
    }

    /**
     * Establece el nombre del curso.
     *
     * @param name El nombre del curso.
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Obtiene la duración del curso en horas.
     *
     * @return La duración del curso en horas.
     */
    public int getDuration() 
    {
        return this.duration;
    }

    /**
     * Establece la duración del curso en horas.
     *
     * @param duration La duración del curso en horas.
     */
    public void setDuration(int duration) 
    {
        this.duration = duration;
    }

    /**
     * Obtiene el precio del curso.
     *
     * @return El precio del curso.
     */
    public int getPrice() 
    {
        return this.price;
    }

    /**
     * Establece el precio del curso.
     *
     * @param price El precio del curso.
     */
    public void setPrice(int price) 
    {
        this.price = price;
    }

    @Override
    public String toString() 
    {
        return "Course [Id=" + id + ", name=" + name + ", duration=" + duration + ", price=" + price + "]";
    }

    /**
     * Calcula el hash code del objeto Course basado en el id.
     */
    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }

    /**
     * Compara dos objetos Course para determinar si son iguales.
     * Dos cursos son iguales si tienen el mismo id, nombre, duración y precio.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Course other = (Course) obj;

        if (id != other.id)
            return false;

        if (name == null) 
        {
            if (other.name != null)
                return false;
        } 
        else if (!name.equals(other.name))
            return false;

        if (duration != other.duration)
            return false;

        if (price != other.price)
            return false;

        return true;
    }    
}