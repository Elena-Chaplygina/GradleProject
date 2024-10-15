package dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DTOUser {
    String username;
    String password;

    public DTOUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
