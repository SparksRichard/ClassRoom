package io.zipcoder.ClassRoom.controllers;

import io.zipcoder.ClassRoom.models.Student;
import io.zipcoder.ClassRoom.models.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

/**
 * Created by rsparks on 10/23/15.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping("/create")
    @ResponseBody
    public String create(Integer age, String name){
        Student student = null;
        try{
            student = new Student(age, name);
            studentDAO.save(student);
        }catch(Exception ex){
            return "Error created student: "+ex.toString();
        }
        return "Student Successfully Created: (id = " + student.getId() + ")";
    }

    @RequestMapping("/read")
    @ResponseBody
    public String read() {
        try {
            List<Student> studentList = (List<Student>) studentDAO.findAll();
            String outputTable = "";
            for (Student student : studentList) {
                outputTable += "The student with ID: " + student.getId() + " has name: " + student.getName() + " and is " + student.getAge() + " years old.<br/>";
            }
            return outputTable;
        }catch(Exception ex){
            return "There are no entries in your table!";
        }
    }
    @RequestMapping(value = "/read", params="id")
    @ResponseBody
    public String read(long id){
        try {
            Student student = studentDAO.findOne(id);
            String output = "The student with ID: " + student.getId() + " has name: " + student.getName() + " and is " + student.getAge() + " years old.<br/>";
            return output;
        }catch(Exception ex){
            return "Either you entered incompatible types or no person exists with that ID, please try again.";
        }
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(long id, String name, Integer age){
        try {
            Student student = studentDAO.findOne(id);
            Integer oldAge = student.getAge();
            String oldName = student.getName();
            student.setAge(age);
            student.setName(name);
            studentDAO.save(student);
            return "You changed student with ID: " + student.getId() + "<br/><b>NAME: </b>from " + oldName + " to " + student.getName() + "<br/><b>AGE: </b> from " + oldAge + " to " + student.getAge();
        }catch(Exception ex){
            return "No such person exists, sorry.";
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id){
        try {
            Student student = studentDAO.findOne(id);
            studentDAO.delete(id);
            return "You just deleted " + student.getAge() + " year old " + student.getName() + "!" + " You're a horrible person! (oh and btw he was id:" + student.getId() + ")";
        }catch(Exception ex){
            return "No such person exists! Maybe you already deleted them, jerk...";
        }
    }
}
