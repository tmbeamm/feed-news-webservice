package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.FeedTopic;

@Repository
public interface FeedTopicRepository extends JpaRepository<FeedTopic, Long> {

	public List<FeedTopic> findAllOrderByTitle();
}
