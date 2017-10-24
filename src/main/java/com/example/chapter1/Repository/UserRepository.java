package com.example.chapter1.Repository;

import com.example.chapter1.Entry.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntry, Long> {

    UserEntry findOne(Long aLong);

    UserEntry findByNamAndAge(String name, Integer age);

//    @Query("from UserEntry u where u.name=:name")
//    @Query("select u from UserEntry u where u.name=:name")
//    UserEntry findUser(@Param("name") String name);

}
