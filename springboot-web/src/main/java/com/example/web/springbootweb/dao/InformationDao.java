package com.example.web.springbootweb.dao;

import com.example.web.springbootweb.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Xinrui Yu
 * @date 2021-11-6 10:34
 */
@Repository
public interface InformationDao extends JpaRepository<Information,Integer> {
}
