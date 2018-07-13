package com.springboot.lock;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.net.URI;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class BusinessDataTester extends BaseTest {
	
	
	
	@Test
	public void testAddBusinessTransactionHash() {
		
		String uri = "/v1/base";
		
				
		this.post(uri, null);
	}
	
	private String post(String uri, String jsonBody) {
		
        try {
			String resBody = mvc.perform(MockMvcRequestBuilders.post(new URI(uri)).contentType(MediaType.APPLICATION_JSON))
									.andDo(print())
									.andReturn()
									.getResponse()
									.getContentAsString();
			
			return resBody;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
}
