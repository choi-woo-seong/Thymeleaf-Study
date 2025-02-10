package my.app.first_Project.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class UserData {
    private String userName;
    private int userAge;
    private String userAddress;

    public static UserData fromParams(
            String userName,
            int userAge,
            String userAddress) {
        return new UserData(userName, userAge, userAddress);
    }

//    public UserData(String userName, int userAge) {
//        this.userName = userName;
//        this.userAge = userAge;
//    }

    //    getter, setter, toString
//    기본 생성자, 전체 생성자, 일부생성자
//    @AllArgsConstructor
//    public UserData(String userName, int userAge, String userAddress) {
//        this.userName = userName;
//        this.userAge = userAge;
//        this.userAddress = userAddress;
//    }
//    @NoArgsConstructor
//    public UserData() {
//    }
//    @RequiredArgsConstructor
//    public UserData(String userName) {
//        this.userName = userName;
//    }
//    public UserData(String userName, int userAge) {
//        this.userName = userName;
//        this.userAge = userAge;
//    }
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @RequiredArgsConstructor
//    @Getter
//    @Setter
//    @Data= getter, setter, reqargcon, tostr, equ.....
//    @ToString
//    @EqualsAndHashCode
}
