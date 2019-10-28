package com.salon.repository.impl;


import com.salon.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findUserByEmail(String email);
    User findUserByUserId(String userId);
    User findUserByUserName(String userName);
    User findUserByPhoneNumber(String phoneNumber);

}
