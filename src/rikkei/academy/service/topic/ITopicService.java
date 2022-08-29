package rikkei.academy.service.topic;

import rikkei.academy.model.news.Topic;
import rikkei.academy.service.IGenericService;

import java.util.List;

public interface ITopicService extends IGenericService<Topic>{
    Topic findById(int id);

    void deleteById(int id);


}
