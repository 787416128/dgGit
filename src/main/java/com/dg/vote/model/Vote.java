package com.dg.vote.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Vote {
    private Integer id;

    @NonNull
    private String subject;

    @JsonIgnore
    private String content = "";

    private Integer is_over = 0;

    @JsonIgnore
    @NonNull
    private Integer selection_type;

    @JsonIgnore
    @NonNull
    private Integer user_id;

    @NonNull
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date start_time;

    @NonNull
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date end_time;

    //审核是否通过 0-未通过 1-已通过 2-等待审核
    @JsonIgnore
    private Integer is_approve = 2;

    public Vote(String subject, String content, Integer selection_type, Integer user_id, Date start_time, Date end_time) {
        this.subject = subject;
        this.content = content;
        this.selection_type = selection_type;
        this.user_id = user_id;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
