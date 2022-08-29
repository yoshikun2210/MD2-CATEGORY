package rikkei.academy.service.topic;

import rikkei.academy.config.Config;
import rikkei.academy.model.news.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TopicServiceIMPL implements ITopicService {
    public static final String PATH_TOPIC = "D:\\New folder\\untitled8\\src\\rikkei\\academy\\database\\topic.txt";
    public static List<Topic> topicList = new Config<Topic>().readFile(PATH_TOPIC);

//    static {
//        topicList.add(new Topic(1, "Xã Hội"));
//        topicList.add(new Topic(2, "Văn Hóa"));
//        topicList.add(new Topic(2, "Giáo dục"));
//
//    }

    @Override
    public List <Topic> findALl() {
        new Config<Topic>().writeFile(PATH_TOPIC,topicList);
        return topicList;

    }

    @Override
    public void save(Topic topic) {
        topicList.add(topic);

    }

    @Override
    public Topic findById(int id) {
        for (int i = 0; i < topicList.size(); i++) {
            if (id == topicList.get(i).getId()) {
                return topicList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < topicList.size(); i++) {
            if (id == topicList.get(i).getId()) {
                topicList.remove(i);
                break;
            }
        }
    }




}
