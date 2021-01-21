package com.localhost.starter2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {

    @InjectMocks
    TestServiceImpl testService;

    @Test
    void GivenTwoNumbers_WhenCallingAdd_ThenShouldReturnSum() {
        long actual = testService.add(1,2);
        assertEquals(3,actual);
    }
}