package com.topic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic.model.Topic;
@Service
public class TopicService {
	
	@Autowired
	public TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic>topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public Topic getTopicById(Long id) {
		return  topicRepository.findOne(id);
		
	}

	public void updateTopic(Long id, Topic topic) {
		topic.setId(id);
		topicRepository.save(topic);
	}

	public void deleteTopic(Long id) {
		topicRepository.delete(id);
		
	}

}
