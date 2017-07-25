package Twitter;

public class tblNFHashtag {

    private long tweetID;
    private String hashtag;

    public tblNFHashtag(long tweetID, String hashtag) {
        this.tweetID = tweetID;
        this.hashtag = hashtag;
    }

    @Override
    public String toString() {
        return "tblNFHashtag{" +
                "tweetID=" + tweetID +
                ", hashtag='" + hashtag + '\'' +
                '}';
    }

    public long getTweetID() {
        return tweetID;
    }

    public String getHashtag() {
        return hashtag;
    }
}
