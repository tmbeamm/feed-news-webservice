package com.example.repository;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.FeedTopic;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FeedTopicRepositoryTests {

	@Autowired
	FeedTopicRepository feedTopicRepository;
	
	@Test
	public void testConnection(){
		try {
			Long total = feedTopicRepository.count();
			System.out.println("Pass");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fail");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllFeedTopic(){
		List<FeedTopic> listData = feedTopicRepository.findAllOrderByTitle();
		if(listData.size()>0){
			System.out.println("Pass");
		}
	}
}
