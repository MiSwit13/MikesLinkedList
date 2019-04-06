package com.solitarymonk.courses.dao;

import com.solitarymonk.courses.exc.DaoException;
import com.solitarymonk.courses.model.Course;

import java.util.List;

public interface CourseDao {
    void add(Course course) throws DaoException;

    List<Course> findAll();

    Course findById(int id);
}
