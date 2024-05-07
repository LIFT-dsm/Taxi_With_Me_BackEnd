package com.example.texiwithme.domain.user.dto.request;

import com.example.texiwithme.domain.user.model.Gender;
import lombok.Data;

@Data
public class SignupRequestDto {
    private int studentId;
    private String name;
    private String nickname;
    private String password;
    private String gender;
}
