package com.example.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.FeedTopic;
import com.example.services.FeedTopicService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FeedTopicRepositoryTests {


	@Autowired
	FeedTopicService feedTopicService;
	
	@Test
	public void testConnection(){
		try {
    		List<FeedTopic> list = feedTopicService.listData();
			System.out.println("Pass");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fail");
			e.printStackTrace();
		}
	}
}
