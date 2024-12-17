package com.tekarch.usermanagementms.Repositories;

import com.tekarch.usermanagementms.Models.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository  extends JpaRepository<PersonalInfo, Long> {

    PersonalInfo findByUserUserId(Long userId);

}
