package Twitter;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Template for items pushed into the engine
 */
public class tblTweet{
    
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
    String hashtag1;
    String hashtag2;
    String hashtag3;
    String hashtag4;
    String hashtag5;
    
    
    public tblTweet(String topic, String tweetlang, String created_at, String text, String source, String username, String location, String user_description, int followers, int friends, int favorites, int statuses_count, String userlang, int retweet_count, int favorit_count, int sentiment, String hashtag1, String hashtag2, String hashtag3, String hashtag4, String hashtag5){
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
        this.hashtag1 = hashtag1;
        this.hashtag2 = hashtag2;
        this.hashtag3 = hashtag3;
        this.hashtag4 = hashtag4;
        this.hashtag5 = hashtag5;
    }
    
    @Override
    public String toString(){
        return "tblTweet{" + "topic='" + topic + '\'' + ", tweetlang='" + tweetlang + '\'' + ", created_at='" + created_at + '\'' + ", text='" + text + '\'' + ", source='" + source + '\'' + ", username='" + username + '\'' + ", location='" + location + '\'' + ", user_description='" + user_description + '\'' + ", followers=" + followers + ", friends=" + friends + ", favorites=" + favorites + ", statuses_count=" + statuses_count + ", userlang='" + userlang + '\'' + ", retweet_count=" + retweet_count + ", favorit_count=" + favorit_count + ", sentiment=" + sentiment + ", hashtag1='" + hashtag1 + '\'' + ", hashtag2='" + hashtag2 + '\'' + ", hashtag3='" + hashtag3 + '\'' + ", hashtag4='" + hashtag4 + '\'' + ", hashtag5='" + hashtag5 + '\'' + '}';
    }
    
    //Getters
    public String getTopic(){
        return topic;
    }
    
    public String getTweetlang(){
        return tweetlang;
    }
    
    public String getCreated_at(){
        return created_at;
    }
    
    public String getText(){
        return text;
    }
    
    public String getSource(){
        return source;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getUser_description(){
        return user_description;
    }
    
    public int getFollowers(){
        return followers;
    }
    
    public int getFriends(){
        return friends;
    }
    
    public int getFavorites(){
        return favorites;
    }
    
    public int getStatuses_count(){
        return statuses_count;
    }
    
    public String getUserlang(){
        return userlang;
    }
    
    public int getRetweet_count(){
        return retweet_count;
    }
    
    public int getFavorit_count(){
        return favorit_count;
    }
    
    public int getSentiment(){
        return sentiment;
    }
    
    public String getHashtag1(){
        return hashtag1;
    }
    
    public String getHashtag2(){
        return hashtag2;
    }
    
    public String getHashtag3(){
        return hashtag3;
    }
    
    public String getHashtag4(){
        return hashtag4;
    }
    
    public String getHashtag5(){
        return hashtag5;
    }
}
