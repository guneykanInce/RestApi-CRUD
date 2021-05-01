package com.project.accounts;

import com.project.accounts.controller.UserAccountController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountsApplicationTests {

	@InjectMocks
	private UserAccountController userAccountController;

	@Test
	void contextLoads() {
		assertThat(userAccountController).isNotNull();
	}

}
