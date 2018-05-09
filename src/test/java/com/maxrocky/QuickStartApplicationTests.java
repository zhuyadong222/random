package com.maxrocky;

import com.maxrocky.controller.UserController;
import com.maxrocky.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuickStartApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void contextLoads() throws Exception {

		String str = mvc.perform(MockMvcRequestBuilders
							.get("/user/get")		//请求方法post
							.accept(MediaType.APPLICATION_JSON)	//数据格式
							/*.param("id")*/)							//添加参数，只能是request请求
				.andExpect(status().isOk())							//返回状态是200
				.andExpect(content().string(equalTo("SUCCESS")))
				.andDo(print())										//打印出请求和响应的内容
				.andReturn().getResponse().getContentAsString()
				;
		System.err.println(str);
	}

}
