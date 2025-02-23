package com.luv2code.crud_demo.dao;

import com.luv2code.crud_demo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
