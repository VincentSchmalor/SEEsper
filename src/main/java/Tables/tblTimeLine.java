package Tables;

import java.util.Date;

/**
 * Grundgerüst der "Tabelle" TimeLine, in der Informationen über die Timeline gesoeichert werden
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class tblTimeLine {
    private Date createdAt;
    private String userName = "";
    private String status = "";
    private int followerCount;

    public tblTimeLine(Date createdAt, String userName, String status, int followerCount){
        this.createdAt = createdAt;
        this.userName = userName;
        this.status = status;
        this.followerCount = followerCount;
    }

    @Override public String toString(){
        return "\n" +
                createdAt+
                "\nUser: " + userName +
                "\n" + status +
                "\nFollowers:" + followerCount + "\n\n";
    }

    //Getter, Setter
    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public int getFollowerCount() {
        return followerCount;
    }
}
