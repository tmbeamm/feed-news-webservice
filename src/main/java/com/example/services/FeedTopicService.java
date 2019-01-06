package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.FeedTopic;
import com.example.repository.FeedTopicRepository;

@Component
public class FeedTopicService {
	
	@Autowired
	private FeedTopicRepository feedTopicRepository;
	
	public List<FeedTopic> listData(){
		
		return feedTopicRepository.findAll();
	}
	
}
