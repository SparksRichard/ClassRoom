package io.zipcoder.ClassRoom.models;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by rsparks on 10/23/15.
 */
public interface StudentDAO extends CrudRepository<Student, Long> {
    Student findByName(String name);
}
