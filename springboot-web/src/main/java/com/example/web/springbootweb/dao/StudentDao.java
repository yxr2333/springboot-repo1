package com.example.web.springbootweb.dao;


import com.example.web.springbootweb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    /**
     * 根据学号查询对应的人数
     * @param number 学号
     * @return 对应的人数
     */
    @Query(value = "select count(*) from t_student where number = ?1",nativeQuery = true)
    public Integer findByNumber(String number);
}
