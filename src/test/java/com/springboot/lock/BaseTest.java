package com.springboot.lock;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public abstract class BaseTest {

	@Autowired
	private WebApplicationContext context;
	
	protected MockMvc mvc;

	@Before
	public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();  //初始化MockMvc对象
    }
}
