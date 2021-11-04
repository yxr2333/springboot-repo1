package com.example.spring.dao;

import com.example.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 21:59 2021-11-02
*/
@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    /**
     * Created by Intellij IDEA
     * @Author: Xinrui Yu
     * @Date: Created in 16:40 2021-11-03
     * @param studentId  学生id
     * @param teacherId  小导师id
     * */
    @Modifying
    @Query(value = "insert into t_students_teachers(student_id,teachers_id) values (?2,?1)", nativeQuery = true)
    void addTeacher(Integer teacherId,Integer studentId);

    /**
     * 给学生添加班级
     * @param studentId 学生id
     * @param classId 班级id
     */
    @Modifying
    @Query(value = "insert into t_students_classes(student_id,classes_id) values(?1,?2)",nativeQuery = true)
    void addClass(Integer studentId,Integer classId);
}
