package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.view.topic.ViewTopic;

public class Main {
    public Main(){
        System.out.println("|______TIN_TỨC_24H_______|");
        System.out.println("1.CATEGORY MANAGER");
        int chooseHome = Config.scanner().nextInt();
        switch (chooseHome){
            case 1:
                new ViewTopic();

        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
