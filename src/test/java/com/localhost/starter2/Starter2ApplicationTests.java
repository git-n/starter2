package com.localhost.starter2;

import com.localhost.starter2.api.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Starter2ApplicationTests {

	@Autowired
	TestController testController;

	@Test
	void contextLoads() {
		assertNotNull(testController);
	}

}
