package com.dg.vote.model;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserVotes {
    private Integer id;

    @NonNull
    private String nickname;

    private String create_time;

    @NonNull
    private Integer create_vote;

    public UserVotes(String nickname, Date create_time, Integer create_vote) {
        this.nickname = nickname;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.create_time = simpleDateFormat.format(create_time);
        this.create_vote = create_vote;
    }
}
