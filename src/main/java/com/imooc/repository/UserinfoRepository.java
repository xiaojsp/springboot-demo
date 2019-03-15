package com.imooc.repository;

import com.imooc.entity.Userinfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="userinfo")
@Qualifier("userinfoRepository")
public interface UserinfoRepository extends CrudRepository<Userinfo, Integer > {

    public Userinfo findOne(Integer id);

    public Userinfo save(Userinfo u);

    @Query("select t from Userinfo t where t.name=:name")
    public Userinfo findUserByName(@Param("name") String name);
}
