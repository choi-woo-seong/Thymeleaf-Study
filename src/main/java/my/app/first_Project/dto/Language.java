package my.app.first_Project.dto;

import lombok.Getter;

@Getter
// Enum : 상수(변하지 않는 고정 값)들의 집합)
public enum Language {
    JAVA("자바"), C("C언어"), CPP("C++"),PYTHON("파이썬");

    private  final String description;

    Language(String description) {
        this.description = description;
    }
}
