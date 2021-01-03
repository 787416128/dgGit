package com.dg.vote.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    private Integer id;
    @NonNull
    private String nickname;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String perms = "";
}


