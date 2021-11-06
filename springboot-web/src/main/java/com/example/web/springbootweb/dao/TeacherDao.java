package com.example.web.springbootweb.dao;

import com.example.web.springbootweb.entity.Student;
import com.example.web.springbootweb.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据导师的姓名筛选所有相近姓名的导师
     *
     * @param name 导师的姓名
     * @return 导师列表
     */
    @Query(value = "select * from t_teachers where name like %?1%",nativeQuery = true)
    public List<Teacher> getTeachersByName(String name);

    /**
     * 根据学院查询对应的所有导师
     *
     * @param name 学院名称
     * @return 导师列表
     */
    @Query(value = "select * from t_teachers where college = ?1",nativeQuery = true)
    public List<Teacher> getTeachersByCollege(String name);
}
