package com.example.web.springbootweb.dao;


import com.example.web.springbootweb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    /**
     * 根据学号查询对应的人数
     * @param number 学号
     * @return 对应的人数
     */
    @Query(value = "select count(*) from t_student where number = ?1",nativeQuery = true)
    public Integer findByNumber(String number);

    /**
     * 根据学生的姓名筛选所有相近姓名的学生
     *
     * @param name 学生的姓名
     * @return 学生列表
     */
    @Query(value = "select * from t_student where name like %?1%",nativeQuery = true)
    public List<Student> getStudentsByName(String name);

    /**
     * 根据学院查询对应的所有学生
     *
     * @param name 学院名称
     * @return 学生列表
     */
    @Query(value = "select * from t_student where college = ?1",nativeQuery = true)
    public List<Student> getStudentsByCollege(String name);
}
