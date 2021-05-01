package com.project.accounts.repository;

import com.project.accounts.model.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
}