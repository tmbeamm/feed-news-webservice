package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.FeedTopic;
import com.example.repository.FeedTopicRepository;
import com.example.services.FeedTopicService;

@SpringBootApplication
public class FeedNewsWebserviceApplication  implements CommandLineRunner{
	
	@Autowired
	FeedTopicService feedTopicService;
	public static void main(String[] args) {
		SpringApplication.run(FeedNewsWebserviceApplication.class, args);
	}
    @Override

    public void run(String... arg0) throws Exception {
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

