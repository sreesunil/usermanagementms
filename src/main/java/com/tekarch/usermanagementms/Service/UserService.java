package com.tekarch.usermanagementms.Service;


import com.tekarch.usermanagementms.Models.Accounts;
import com.tekarch.usermanagementms.Models.PersonalInfo;
import com.tekarch.usermanagementms.Models.Users;


import java.util.List;
import java.util.Optional;


public interface UserService {


    public Users createUser(Users user);
    public List<Users> getAllUsers();
    public Optional<Users> getUserById(Long userId);
    public Optional<PersonalInfo> getPersonalInfoByUserId(Long userId);
   public Object addLinkedAccount(String userId, Accounts account);
}
