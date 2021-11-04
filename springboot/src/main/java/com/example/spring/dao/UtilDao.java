package com.example.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 16:31 2021/11/4
 */
@Mapper
public interface UtilDao{
    /**
     * 判断班级内是否已经有该学生
     * @param studentId  学生id
     * @param classId 班级id
     * @return 数目，如果大于0则表示已经存在，等于0则表示不存在
     */
    @Select(value = "select * from t_class_students where students_id = #{studentId} and small_class_id = #{classId}")
    Integer checkClassStudent(Integer studentId,Integer classId);

    /**
     * 判断班级内是否已经有该学生
     * @param studentId 学生id
     * @param classId 班级id
     * @return 数目，如果大于0则表示已经存在，等于0则表示不存在
     */
    @Select(value = "select * from t_students_classes where student_id = #{studentId} and classes_id = #{classId}")
    Integer checkStudentClass(Integer studentId,Integer classId);
}
