package com.tekarch.usermanagementms.Service;


import com.tekarch.usermanagementms.Models.Accounts;
import com.tekarch.usermanagementms.Models.PersonalInfo;
import com.tekarch.usermanagementms.Models.Users;
import com.tekarch.usermanagementms.Repositories.PersonalInfoRepository;
import com.tekarch.usermanagementms.Repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PersonalInfoRepository personalInfoRepository;
    private final UserService userService;

    public UserServiceImpl(UserRepository userRepository, PersonalInfoRepository personalInfoRepository, UserService userService) {
        this.userRepository = userRepository;
        this.personalInfoRepository = personalInfoRepository;
        this.userService = userService;
    }


    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<PersonalInfo> getPersonalInfoByUserId(Long userId) {
        return Optional.ofNullable(personalInfoRepository.findByUserUserId(userId));
    }

    @Override
    public Object addLinkedAccount(String userId, Accounts account) {
        return ResponseEntity.ok(userService.addLinkedAccount(userId, account));
    }
}
