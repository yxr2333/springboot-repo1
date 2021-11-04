package com.example.spring.dao;

import com.example.spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:14 2021/11/3
 */
@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    /**
     * 给小导师添加学生
     * @param teacherId 小导师id
     * @param studentId 学生id
     */
    @Modifying
    @Query(value = "insert into t_teachers_students(teacher_id,students_id) values (?1,?2)", nativeQuery = true)
    void addStudent(Integer teacherId,Integer studentId);

    /**
     * 给小导师添加班级
     * @param teacherId 小导师id
     * @param classId 班级id
     */
    @Modifying
    @Query(value = "insert into t_teachers_classes(teacher_id,classes_id) values(?1,?2)",nativeQuery = true)
    void addClass(Integer teacherId,Integer classId);
}
