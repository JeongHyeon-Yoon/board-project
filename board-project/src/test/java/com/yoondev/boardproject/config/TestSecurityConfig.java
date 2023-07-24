package com.yoondev.boardproject.config;

import com.yoondev.boardproject.domain.UserAccount;
import com.yoondev.boardproject.repository.UserAccountRepository;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetup() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
                "yoondevTest",
                "pw",
                "yoondev-test@email.com",
                "yoondev-test",
                "test memo"
        )));

    }
}
