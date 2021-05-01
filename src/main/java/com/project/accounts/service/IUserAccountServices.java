package com.project.accounts.service;

import com.project.accounts.model.UserAccountEntity;

import java.util.List;
import java.util.Optional;

public interface IUserAccountServices {
    UserAccountEntity createAccount(UserAccountEntity entity);

    UserAccountEntity updateAccount(UserAccountEntity entity);

    Optional<UserAccountEntity> findById(Long id);

    void deleteById(Long id);

    void deleteAccount(UserAccountEntity entity);

    List<UserAccountEntity> getAllUserAccounts();
}
