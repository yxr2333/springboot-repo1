package com.example.web.springbootweb.dao;


import com.example.web.springbootweb.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yxr
 * @date 2021-11-6 0:42
 */
@Repository
public interface SubjectDao extends JpaRepository<Subject,Integer> {
    /**
     * 根据名称查询对应的学科数目
     * @param name 学科名称
     * @return 学科数目
     */
    @Query(value = "select count(*) from t_subject where name = ?1",nativeQuery = true)
    public Integer findByName(String name);

    /**
     * 删除学科的时候同时需要删除该学科和学生之间的关联
     * @param id 学科id
     */
    @Modifying
    @Query(value = "delete from t_students_subjects where subjects_id = ?1",nativeQuery = true)
    public void deleteStudentKey(@Param(value = "subjects_id") Integer id);

    /**
     * 删除学科的时候同时需要删除该学科和小导师之间的关联
     * @param id 学科id
     */
    @Modifying
    @Query(value = "delete from t_teachers_subjects where subjects_id = ?1",nativeQuery = true)
    public void deleteTeacherKey(@Param(value = "subjects_id") Integer id);
}
