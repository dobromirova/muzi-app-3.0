package bg.project.muziapp2.model.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewProfileDTO {

    private String username;

    private long addedSongsCount;
    private long favouriteSongsCount;


    public ViewProfileDTO(String username, long addedSongsCount, long favouriteSongsCount) {
        this.username = username;
        this.addedSongsCount = addedSongsCount;
        this.favouriteSongsCount = favouriteSongsCount;
    }
}
