package com.yoondev.boardproject.repository;

import com.yoondev.boardproject.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository <UserAccount, Long> {
}
