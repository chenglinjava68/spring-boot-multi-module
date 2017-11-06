package com.xym.springboot.dao;

import com.xym.springboot.domain.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * jpa根据方法的特殊名称创建sql语句
 */
public interface UserRepository extends JpaRepository<JPAUser, Long> {

    JPAUser findByName(String name);

    JPAUser findByNameAndAge(String name, Integer age);

    @Query("from JPAUser u where u.name=:name")
    JPAUser findJPAUser(@Param("name") String name);

}
