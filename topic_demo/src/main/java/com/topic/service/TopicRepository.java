package com.topic.service;

import org.springframework.data.repository.CrudRepository;

import com.topic.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {

}
