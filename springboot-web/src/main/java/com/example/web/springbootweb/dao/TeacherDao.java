package com.example.web.springbootweb.dao;

import com.example.web.springbootweb.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:26 2021/11/4
 */
@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    /**
     * 通过学号查询人数，判断该学号是否存在
     * @param number 学号
     * @return 查询到的人数
     */
    @Query(value = "select count(*) from t_teachers where number = ?1",nativeQuery = true)
    public Integer findByNumber(String number);
}
