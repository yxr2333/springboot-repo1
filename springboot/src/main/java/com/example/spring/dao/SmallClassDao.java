package com.example.spring.dao;

import com.example.spring.entity.SmallClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:24 2021/11/3
 */
public interface SmallClassDao extends JpaRepository<SmallClass,Integer> {
    /**
     * 给班级添加学生
     * @param smallClassId 班级id
     * @param studentId 学生id
     */
    @Modifying
    @Query(value = "insert into t_class_students(small_class_id,students_id) values (?1,?2)",nativeQuery = true)
    void addStudent(Integer smallClassId,Integer studentId);

    /**
     * 给班级设置小导师
     * @param classId 班级id
     * @param teacherId 小导师id
     */
    @Modifying
    @Query(value = "update t_class set teacher_id = ?2 where id = ?1",nativeQuery = true)
    void setTeacher(Integer classId,Integer teacherId);

    /**
     * 给班级设置干事
     * @param classId 班级id
     * @param clerkId 干事id
     */
    @Modifying
    @Query(value = "update t_class set clerk_id =?2 where id = ?1",nativeQuery = true)
    void setClerk(Integer classId,Integer clerkId);
}
