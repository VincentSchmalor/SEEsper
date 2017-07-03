package Moduled;

import java.util.Date;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class tblTweet {
    String topic;
    String tweetlang;
    String created_at;
    String text;
    String source;
    String username;
    String location;
    String user_description;
    String followers;
    String friends;
    String favorites;
    String statuses_count;
    String userlang;
    String retweet_count;
    String favorit_count;

    public tblTweet(String topic, String tweetlang, String created_at, String text, String source, String username, String location, String user_description, String followers, String friends, String favorites, String statuses_count, String userlang, String retweet_count, String favorit_count) {
        this.topic = topic;
        this.tweetlang = tweetlang;
        this.created_at = created_at;
        this.text = text;
        this.source = source;
        this.username = username;
        this.location = location;
        this.user_description = user_description;
        this.followers = followers;
        this.friends = friends;
        this.favorites = favorites;
        this.statuses_count = statuses_count;
        this.userlang = userlang;
        this.retweet_count = retweet_count;
        this.favorit_count = favorit_count;
    }

    @Override
    public String toString(){
        return topic+tweetlang+created_at+text+source+username+location+user_description+followers+friends+favorites+statuses_count+userlang+retweet_count+favorit_count;
    }
}
