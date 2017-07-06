package com.topic.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topic.model.Topic;
import com.topic.service.TopicService;

@RestController
public class TopicController {

	final static Logger logger = Logger.getLogger(TopicController.class);
	@Autowired
	public TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		logger.info("get all topics");
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable Long id ){
		logger.info("get topic by id :"+id);
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic){
		logger.info("add topic");
		topicService.addTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable Long id){
		logger.info("update topic id:"+id);
		topicService.updateTopic(id,topic);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable Long id){
		logger.info("delete topic by id");
		topicService.deleteTopic(id);
	}
}
