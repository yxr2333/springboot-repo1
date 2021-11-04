package com.example.spring.dao;

import com.example.spring.entity.Clerk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:24 2021/11/3
 */
public interface ClerkDao extends JpaRepository<Clerk,Integer> {

    /**
     * 给干事添加班级
     * @param clerkId 干事id
     * @param classId 班级id
     */
    @Modifying
    @Query(value = "insert into t_clerk_small_classes(clerk_id,small_classes_id) values (?1,?2)",nativeQuery = true)
    void addClass(Integer clerkId,Integer classId);
}
