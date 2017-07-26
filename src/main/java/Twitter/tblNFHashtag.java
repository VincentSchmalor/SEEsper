package Twitter;

/**
 * Created by Vincent Schmalor on 25.07.2017.
 * Template for items pushed into the engine
 */
public class tblNFHashtag{
    
    private long tweetID;
    private String hashtag;
    
    public tblNFHashtag(long tweetID, String hashtag){
        this.tweetID = tweetID;
        this.hashtag = hashtag;
    }
    
    @Override
    public String toString(){
        return "tblNFHashtag{" + "tweetID=" + tweetID + ", hashtag='" + hashtag + '\'' + '}';
    }
    
    //Getters
    public long getTweetID(){
        return tweetID;
    }
    
    public String getHashtag(){
        return hashtag;
    }
}
