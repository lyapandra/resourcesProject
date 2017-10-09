package com.softserve.edu.Resources.service.impl;

import com.softserve.edu.Resources.dao.RoleDAO;
import com.softserve.edu.Resources.dao.UserDetailsDAO;
import com.softserve.edu.Resources.dto.UserProfileDTO;
import com.softserve.edu.Resources.entity.User;
import com.softserve.edu.Resources.entity.UserDetails;
import com.softserve.edu.Resources.service.UserDetailsService;
import com.softserve.edu.Resources.service.UserProfileService;
import com.softserve.edu.Resources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserDetailsDAO userDetailsDAO;
//    @Autowired
//    UserProfileDTO userProfileDTO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails getUserDetailsByDTO(UserProfileDTO userProfileDTO) {
        long id = userProfileDTO.getId();
        UserDetails createdUserDetailsEntity = userDetailsDAO.findById(id);
        createdUserDetailsEntity.setFirstName(userProfileDTO.getFirstName());

        return createdUserDetailsEntity;
    }

    @Override
    @Transactional
    public UserProfileDTO createUserProfileDTO(Principal principal){
        String userName = principal.getName();
        User user = userService.findByEmail(userName);
        Optional<UserDetails> details = userDetailsService.getUserDetailsByUserId(user.getId());
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setId(details.get().getId());
        userProfileDTO.setFirstName(details.get().getFirstName());
//        System.out.println("");

        return userProfileDTO;
    }

//    @Override
//    public UserProfileDTO createUserProfileDTO(long id) {
//        return null;
//    }

    @Transactional
    public UserProfileDTO getUserProfileByEmail(String email){
        UserProfileDTO userProfileDTO = new UserProfileDTO();

        System.out.println("Privileges extracted (commented)");

        return userProfileDTO;
    }

    @Transactional
    public UserProfileDTO getUserProfileByUserId(Long id){
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setFirstName("String");

//        userProfileDTO.getFirstName(user.getFirstName(id));
        return userProfileDTO;
    }

//    @Override
//    public void saveOrUpdate(UserProfileDTO userProfileDTO) {
//        userProfileDTO.setFirstName(userProfileDTO.getFirstName());
//        System.out.println("======UserDetailsServiceImpl=========");
//        System.out.println(userProfileDTO);
//    }
    @Override
    @Transactional
    public void saveUserProfile(UserProfileDTO userProfileDTO) {
        UserDetails userDetails = getUserDetailsByDTO(userProfileDTO);
        userDetails.setFirstName(userProfileDTO.getFirstName());
//        getUserProfileByUserId(10L);
//        userDetailsDAO.makePersistent(UserProfileDTO);
        System.out.println("UserProfileServiceImpl.saveUserProfile");
    }
}
