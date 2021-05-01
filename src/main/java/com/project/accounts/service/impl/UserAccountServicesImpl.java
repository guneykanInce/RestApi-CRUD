package com.project.accounts.service.impl;

import com.project.accounts.model.UserAccountEntity;
import com.project.accounts.repository.IUserAccountRepository;
import com.project.accounts.service.IUserAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServicesImpl implements IUserAccountServices {

	@Autowired
	IUserAccountRepository accountsRepository;

	@Override
	public UserAccountEntity createAccount(UserAccountEntity entity) {
		return accountsRepository.save(entity);
	}

	@Override
	public UserAccountEntity updateAccount(UserAccountEntity entity) {
		return accountsRepository.save(entity);
	}

	@Override
	public Optional<UserAccountEntity> findById(Long id) {
		return accountsRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		accountsRepository.deleteById(id);
	}

	@Override
	public void deleteAccount(UserAccountEntity entity) {
		accountsRepository.delete(entity);
	}

	@Override
	public List<UserAccountEntity> getAllUserAccounts() {
		return accountsRepository.findAll();
	}

}
