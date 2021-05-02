package com.project.accounts.controller;

import com.project.accounts.dto.UserAccountRequestDto;
import com.project.accounts.dto.UserAccountResponseDto;
import com.project.accounts.model.UserAccountEntity;
import com.project.accounts.repository.IUserAccountRepository;
import com.project.accounts.service.IUserAccountServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserAccountControllerTest {

    @Mock
    IUserAccountServices userAccountServices;
    
    @Mock
    ModelMapper modelMapper;
    
    @Mock
    IUserAccountRepository accountsRepository;

    @InjectMocks
    UserAccountController userAccountController;
    
    @Test
    void getAllAccounts() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("99999999999").build();
        
        when(userAccountServices.getAllUserAccounts()).thenReturn(asList(entity));
        
		ResponseEntity<List<UserAccountResponseDto>> responseEntityList = userAccountController.getAllAccounts();
         
        assertEquals(responseEntityList.getStatusCodeValue(),200);
    }

    @Test
    void findAccountById() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("99999999999").build();
        
        when(userAccountServices.findById(entity.getId())).thenReturn(Optional.of(entity));
        
		ResponseEntity<UserAccountResponseDto> responseEntity = userAccountController.findAccountById(entity.getId());
         
        assertEquals(responseEntity.getStatusCodeValue(),200);
    }

    @Test
    void createAccount() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("99999999999").build();
        
        when(userAccountServices.createAccount(any(UserAccountEntity.class))).thenReturn(entity);
         
        UserAccountRequestDto requestEntity = UserAccountRequestDto.builder().id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("99999999999").build();

        when(modelMapper.map(requestEntity, UserAccountEntity.class)).thenReturn(entity);
        
		@SuppressWarnings("unchecked")
		ResponseEntity<Object> responseEntity = userAccountController.createAccount(requestEntity);
         
        assertEquals(responseEntity.getStatusCodeValue(),201);
        assertEquals(responseEntity.getHeaders().getLocation().getPath(),"/1");
    }

    @Test
    void updateAccount() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@update.com")
                .name("Guneykan")
                .phone("99999999999").build();
        
        when(userAccountServices.updateAccount(any(UserAccountEntity.class))).thenReturn(entity);
         
        UserAccountRequestDto requestEntity = UserAccountRequestDto.builder().id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@update.com")
                .name("Guneykan")
                .phone("99999999999").build();

        when(modelMapper.map(requestEntity, UserAccountEntity.class)).thenReturn(entity);
        
		@SuppressWarnings("unchecked")
		ResponseEntity<Object> responseEntity = userAccountController.updateAccount(requestEntity);
         
        assertEquals(responseEntity.getStatusCodeValue(),201);
        assertEquals(responseEntity.getHeaders().getLocation().getPath(),"/1");
    }
    
    @Test
    void deleteAccount() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        UserAccountEntity entity = UserAccountEntity.builder()
                .id(1L)
                .address("Merdivenkoy")
                .country("TR")
                .department("IT")
                .email("test@test.com")
                .name("Guneykan")
                .phone("99999999999").build();
        
        when(userAccountServices.findById(entity.getId())).thenReturn(Optional.of(entity));
        
		@SuppressWarnings("unchecked")
		ResponseEntity<Object> responseEntity = userAccountController.deleteAccount(entity.getId());
         
        assertEquals(responseEntity.getStatusCodeValue(),200);
    }
}