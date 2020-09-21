package com.koki.dao.studentDao;

import com.koki.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询student表的所有数据
    public List<Student> selectStudents();
}
