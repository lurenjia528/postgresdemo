package com.example.postgres.demo.repository;

import com.example.postgres.demo.model.BcContact;
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
public interface ContactRepository extends JpaRepository<BcContact,Long> , CrudRepository<BcContact,Long> {

    /**
     * 附近地址查询
     * @return
     */
    @Query(value = "SELECT * FROM \"bc_contact\"",nativeQuery = true)
    BcContact get();

    BcContact getAllById(int id);

    @Query(value = "INSERT INTO bc_contact(id,name,quality,type) VALUES(:id,:name,:quality,:type)",nativeQuery = true)
    @Modifying
    @Transactional(rollbackFor = {})
    int insert(@Param("id") Integer id,
                      @Param("name")String name,
                      @Param("quality")Integer quality,
                      @Param("type")Integer type);

}
