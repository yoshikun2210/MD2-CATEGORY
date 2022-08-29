package rikkei.academy.model.news;

public class Content {
    String name;

    public Content(String name) {
        this.name = name;
    }

    public Content() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Content{" +
                "name='" + name + '\'' +
                '}';
    }
}
