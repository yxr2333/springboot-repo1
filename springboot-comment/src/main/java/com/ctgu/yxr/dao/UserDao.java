package com.ctgu.yxr.dao;

import com.ctgu.yxr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    @Query(value = "select pwd from t_users where name = ?1",nativeQuery = true)
    public String getPwdByName(String name);

    @Query(value = "select * from t_users where name = ?1",nativeQuery = true)
    public User getUserByName(String name);
}
