package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.FeedTopic;

public interface FeedTopicRepository extends JpaRepository<FeedTopic, Long> {

}
