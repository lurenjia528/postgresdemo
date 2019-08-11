package com.example.postgres.demo.repository;

import com.example.postgres.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanggt
 * @date 19-8-8
 */
@Repository
public interface ContactRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {


    @Query(value = "SELECT * FROM cloud.USER", nativeQuery = true)
    User get();

    User getOneById(int id);

    @Query(value = "INSERT INTO cloud.USER(ID,NAME,ADDRESS) VALUES(:id,:name,:address)", nativeQuery = true)
    @Modifying
    @Transactional(rollbackFor = {Exception.class})
    int insert(@Param("id") Integer id,
               @Param("name") String name,
               @Param("address") String address);


}
