package com.example.spring.dao;

import com.example.spring.entity.Clerk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:24 2021/11/3
 */
public interface ClerkDao extends JpaRepository<Clerk,Integer> {
}
