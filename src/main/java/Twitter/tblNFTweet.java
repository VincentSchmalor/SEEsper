package Twitter;

public class tblNFTweet {

    private long tweetID;
    private long userID;
    private String text;
    private String lang;
    private long quotedStatus;

    public tblNFTweet(long tweetID, long userID, String text, String lang, long quotedStatus) {
        this.tweetID = tweetID;
        this.userID = userID;
        this.text = text;
        this.lang = lang;
        this.quotedStatus = quotedStatus;
    }

    @Override
    public String toString() {
        return "tblNFTweet{" +
                "tweetID=" + tweetID +
                ", userID=" + userID +
                ", text='" + text + '\'' +
                ", lang='" + lang + '\'' +
                ", quotedStatus=" + quotedStatus +
                '}';
    }

    public long getTweetID() {
        return tweetID;
    }

    public long getUserID() {
        return userID;
    }

    public String getText() {
        return text;
    }

    public String getLang() {
        return lang;
    }

    public long getQuotedStatus() {
        return quotedStatus;
    }
}
