package az.atl.dto.userdto;

import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {

    private String username;

    private String email;
}
