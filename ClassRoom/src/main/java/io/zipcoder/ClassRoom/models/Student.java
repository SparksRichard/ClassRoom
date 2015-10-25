package io.zipcoder.ClassRoom.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by rsparks on 10/23/15.
 */

@Entity
@Table(name = "student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private Integer age;

    @NotNull
    private String name;

    public Student(Integer age, String name){
        this.age = age;
        this.name = name;

    }
    public Student(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }





}
