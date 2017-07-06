package Moduled;

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
    int followers;
    int friends;
    int favorites;
    int statuses_count;
    String userlang;
    int retweet_count;
    int favorit_count;
    int sentiment;

    public tblTweet(String topic, String tweetlang, String created_at, String text, String source, String username, String location, String user_description, int followers, int friends, int favorites, int statuses_count, String userlang, int retweet_count, int favorit_count, int sentiment) {
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
        this.sentiment = sentiment;
    }

    @Override
    public String toString(){
        return topic+tweetlang+created_at+text+source+username+location+user_description+followers+friends+favorites+statuses_count+userlang+retweet_count+favorit_count+sentiment;
    }

    public String getTopic() {
        return topic;
    }

    public String getTweetlang() {
        return tweetlang;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

    public String getUser_description() {
        return user_description;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFriends() {
        return friends;
    }

    public int getFavorites() {
        return favorites;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public String getUserlang() {
        return userlang;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public int getFavorit_count() {
        return favorit_count;
    }

    public int getSentiment() {
        return sentiment;
    }
}
