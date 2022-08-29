package rikkei.academy.controller;

import rikkei.academy.model.news.Topic;
import rikkei.academy.service.topic.ITopicService;
import rikkei.academy.service.topic.TopicServiceIMPL;

import java.util.List;

public class TopicController {
    ITopicService topicService = new TopicServiceIMPL();

    public List<Topic> showListTopic() {
        return topicService.findALl();
    }

    public void createTopic(Topic topic) {
        topicService.save(topic);

    }

    public Topic detailTopic(int id) {
        return topicService.findById(id);
    }

    public void updateTopic(int id, Topic newTopic) {
        Topic topic1 = topicService.findById(id);
        topic1.setName(newTopic.getName());
    }

    public void deleteTopic(int id) {
        topicService.deleteById(id);
    }



}
