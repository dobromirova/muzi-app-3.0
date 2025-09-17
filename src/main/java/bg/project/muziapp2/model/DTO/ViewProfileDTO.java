package bg.project.muziapp2.model.DTO;

public class ViewProfileDTO {

    private String username;

    private long addedSongsCount;
    private long favouriteSongsCount;


    public ViewProfileDTO(String username, long addedSongsCount, long favouriteSongsCount) {
        this.username = username;
        this.addedSongsCount = addedSongsCount;
        this.favouriteSongsCount = favouriteSongsCount;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getAddedSongsCount() {
        return addedSongsCount;
    }

    public void setAddedSongsCount(long addedSongsCount) {
        this.addedSongsCount = addedSongsCount;
    }

    public long getFavouriteSongsCount() {
        return favouriteSongsCount;
    }

    public void setFavouriteSongsCount(long favouriteSongsCount) {
        this.favouriteSongsCount = favouriteSongsCount;
    }
}
