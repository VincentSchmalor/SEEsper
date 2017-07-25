package Twitter;

public class tblNFUser {

    private long userID;
    private String username;
    private String screenname;
    private String location;
    private String lang;
    private String description;
    private int followers;
    private int friends;
    private int favourites;
    private int statuses;

    public tblNFUser(long userID, String username, String screenname, String location, String lang, String description, int followers, int friends, int favourites, int statuses) {
        this.userID = userID;
        this.username = username;
        this.screenname = screenname;
        this.location = location;
        this.lang = lang;
        this.description = description;
        this.followers = followers;
        this.friends = friends;
        this.favourites = favourites;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "tblNFUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", screenname='" + screenname + '\'' +
                ", location='" + location + '\'' +
                ", lang='" + lang + '\'' +
                ", description='" + description + '\'' +
                ", followers=" + followers +
                ", friends=" + friends +
                ", favourites=" + favourites +
                ", statuses=" + statuses +
                '}';
    }

    public long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getScreenname() {
        return screenname;
    }

    public String getLocation() {
        return location;
    }

    public String getLang() {
        return lang;
    }

    public String getDescription() {
        return description;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFriends() {
        return friends;
    }

    public int getFavourites() {
        return favourites;
    }

    public int getStatuses() {
        return statuses;
    }
}
