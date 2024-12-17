package com.tekarch.usermanagementms.Repositories;

import com.tekarch.usermanagementms.Models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts , Long> {
}
