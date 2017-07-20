package Twitter;

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

    public String getPolitician() {
        return politician;
    }

    public String getHashtag() {
        return hashtag;
    }
}
