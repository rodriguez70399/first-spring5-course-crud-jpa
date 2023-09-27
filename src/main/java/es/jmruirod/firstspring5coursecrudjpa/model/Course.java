package es.jmruirod.firstspring5coursecrudjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase modelo para un curso
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Entity
public class Course 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private int duration;
    private int price;

    public Course() 
    {

    }

    public Course(String name, int duration, int price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public Course(int id, String name, int duration, int price) 
    {
        Id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public int getId() 
    {
        return Id;
    }

    public void setId(int id) 
    {
        Id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getDuration() 
    {
        return duration;
    }

    public void setDuration(int duration) 
    {
        this.duration = duration;
    }

    public int getPrice() 
    {
        return price;
    }

    public void setPrice(int price) 
    {
        this.price = price;
    }   
}
