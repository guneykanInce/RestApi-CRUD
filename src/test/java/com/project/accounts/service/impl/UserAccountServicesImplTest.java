package com.project.accounts.service.impl;

import com.project.accounts.model.UserAccountEntity;
import com.project.accounts.repository.IUserAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserAccountServicesImplTest {

    @Mock
    IUserAccountRepository accountsRepository;

    @InjectMocks
    UserAccountServicesImpl userAccountService;

    @Test
    void createAccount() {
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("99999999999").build();
        when(userAccountService.createAccount(entity)).thenReturn(entity);

        UserAccountEntity result = userAccountService.createAccount(entity);
        assertEquals(result.getId(), entity.getId());
        assertEquals(result.getName(), entity.getName());
    }

    @Test
    void updateAccount() {
    	UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("88888888888").build();
        when(userAccountService.updateAccount(entity)).thenReturn(entity);

        UserAccountEntity result = userAccountService.updateAccount(entity);
        assertEquals(result.getId(), entity.getId());
        assertEquals(result.getName(), entity.getName());
    }

    @Test
    void findById() {
    	UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("88888888888").build();
    	when(userAccountService.findById(1L)).thenReturn(Optional.of(entity));
    	assertNotNull(userAccountService.findById(1L));
    }

    @Test
    void deleteById() {
    	userAccountService.deleteById(1L);
    }

    @Test
    void deleteAccount() {
    	UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("88888888888").build();
    	userAccountService.deleteAccount(entity);
    }

    @Test
    void getAllUserAccounts() {
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("88888888888").build();
        when(userAccountService.getAllUserAccounts()).thenReturn(asList(entity));

        List<UserAccountEntity> list = userAccountService.getAllUserAccounts();

        assertEquals(entity, list.get(0));
        verify(accountsRepository).findAll();
    }
}