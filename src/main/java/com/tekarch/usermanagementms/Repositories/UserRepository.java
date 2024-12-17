package com.tekarch.usermanagementms.Repositories;

import com.tekarch.usermanagementms.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users , Long> {

}
