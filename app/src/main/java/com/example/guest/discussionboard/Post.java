package com.example.guest.discussionboard;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String body;
    private String category;
    private List<String> responses = new ArrayList<>();

    public Post() { }

    public Post(String title, String body, String category, ArrayList<String> responses) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.responses = responses;
    }

    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public String getCategory() {
        return category;
    }
    public List<String> getResponses() {
        return responses;
    }
}
