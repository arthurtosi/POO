package simulado_q1;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Tweet> tweets = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
}