package rikkei.academy.view.topic;

import rikkei.academy.config.Config;
import rikkei.academy.controller.TopicController;
import rikkei.academy.model.news.Topic;

import java.util.ArrayList;
import java.util.List;

public class ViewTopic {
    public TopicController topicController = new TopicController();
    public List<Topic> topicList = topicController.showListTopic();

    public ViewTopic() {
        System.out.println("****** TOPIC MANAGER ******");
        System.out.println("1.Create Topic");
        System.out.println("2.Show List Topic");
        System.out.println("3.Detail Topic");
        System.out.println("4.Edit Topic");
        System.out.println("5.Delete Topic");
        System.out.println("6.Add Topic");
        int chooseTopic = Config.scanner().nextInt();
        switch (chooseTopic) {
            case 1:
                newsCreateTopic();
                break;
            case 2:
                newsShowListTopic();
                break;
            case 3:
                newsDetailTopic();
                break;
            case 4:
                newsEditTopic();
                break;
            case 5:
                newsDeleteTopic();
                break;

        }
    }

    public void newsCreateTopic() {
        System.out.println("|________ CREATE TOPIC ________|");
        while (true) {
            int idTopic;
            if (topicList.size() == 0) {
                idTopic = 1;
            } else {
                idTopic = topicList.get(topicList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập vào tên chủ đề :");
            String name = Config.scanner().nextLine();
            Topic topic = new Topic(idTopic, name);
            topicController.createTopic(topic);
            System.out.println("Thêm thành công!!!");
            System.out.println("Nhập phím bất kỳ đề tiếp tục - out để thoát");
            String outHome = Config.scanner().nextLine();
            if (outHome.equalsIgnoreCase("out")) {
                new ViewTopic();
                break;

            }
        }
    }

    public void newsShowListTopic() {
        System.out.println("|     STT     CHỦ DỀ     |");
        for (int i = 0; i < topicList.size(); i++) {
            int j = i + 1;
            System.out.println("|     " + j + "     " + topicList.get(i).getName() + "      |");
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewTopic();
        }
    }

    public void newsDetailTopic() {
        System.out.println("Nhập id:");
        int idTopic = Config.scanner().nextInt();
        if (topicController.detailTopic(idTopic) == null) {
            System.out.println("Không có id này");
        } else {
            Topic topic = topicController.detailTopic(idTopic);
            System.out.println(topic);
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewTopic();
        }
    }

    public void newsEditTopic() {
        System.out.println("Nhập id để sửa");
        int idTopic = Config.scanner().nextInt();
        if (topicController.detailTopic(idTopic) == null) {
            System.out.println("Không có id này");
        } else {
            Topic topic = topicController.detailTopic(idTopic);
            System.out.println("Old name :" + topic.getName());
            System.out.println("Nhập để sửa :");
            String newName = Config.scanner().nextLine();
            if (newName.trim().equals("")) {
                newName = topic.getName();
            }
            Topic newTopic = new Topic(newName);
            topicController.updateTopic(idTopic, newTopic);
            System.out.println("Sửa thành công !!!!!!");
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewTopic();
        }
    }

    public void newsDeleteTopic() {
        System.out.println("Nhập id để xóa");
        int idTopic = Config.scanner().nextInt();
        if (topicController.detailTopic(idTopic) == null) {
            System.out.println("Không có id này");
        } else {
            System.out.println("Nhập 1 để xóa - Nhập 2 để không xóa");
            int chooseDelete = Config.scanner().nextInt();
            switch (chooseDelete) {
                case 1:
                    System.out.println("Xóa thành công!!!!");
                    topicController.deleteTopic(idTopic);
                    newsShowListTopic();
                    break;
                case 2:
                    new ViewTopic();
                    break;
            }
        }

    }
}
