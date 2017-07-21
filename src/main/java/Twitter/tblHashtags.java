package Twitter;

/**
 * Created by Vincent Schmalor on 20.07.2017.
 * Template for items pushed into the engine
 */
public class tblHashtags {

    private String politician;
    private String hashtag;

    public tblHashtags(String politician, String hashtag) {
        this.politician = politician;
        this.hashtag = hashtag;
    }

    @Override
    public String toString() {
        return "tblHashtags{" +
                "politician='" + politician + '\'' +
                ", hashtag='" + hashtag + '\'' +
                '}';
    }

    //Getters
    public String getPolitician() {
        return politician;
    }

    public String getHashtag() {
        return hashtag;
    }
}
