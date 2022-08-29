package rikkei.academy.service.content;

import rikkei.academy.model.news.Content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContentServiceIMPL implements IContentService {
    public List<Content> contentList = new ArrayList<>();

    static {
        System.out.println("Bóng đá quốc tế");
    }

    @Override
    public List<Content> findALl() {
        return contentList;
    }

    @Override
    public void save(Content content) {
        contentList.add(content);
    }
}
