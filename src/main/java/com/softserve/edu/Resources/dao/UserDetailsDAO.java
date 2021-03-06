package com.softserve.edu.Resources.dao;

import com.softserve.edu.Resources.dto.UserProfileDTO;
import com.softserve.edu.Resources.entity.UserDetails;

import java.util.Optional;

public interface UserDetailsDAO extends GenericDAO<UserDetails, Long>{
    Optional<UserDetails> findByEmail(String email);
    UserDetails findById(long id);
//    void save(UserProfileDTO userDetails);
    void save(UserDetails userDetails);

//    UserDetails makePersistent(UserProfileDTO userDetails);
}



