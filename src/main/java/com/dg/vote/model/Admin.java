package com.dg.vote.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Admin {
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String roles;
}
