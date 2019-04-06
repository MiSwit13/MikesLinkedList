package com.solitarymonk.courses.dao;

import com.solitarymonk.courses.exc.DaoException;
import com.solitarymonk.courses.model.Review;

import java.util.List;

public interface ReviewDao {
    void add(Review review) throws DaoException;

    List<Review> findAll();

    List<Review> findByCourseId(int courseId);
}
