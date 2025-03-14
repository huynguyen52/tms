package icu.nguyenquochuy.tms.vo;

import icu.nguyenquochuy.tms.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public static UserVO from(User user) {
        return UserVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
