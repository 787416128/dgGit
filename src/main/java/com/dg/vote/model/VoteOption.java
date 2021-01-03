package com.dg.vote.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class VoteOption {
    private Integer id;
    @NonNull
    private String option;
    @NonNull
    private Integer voie_id;
    //投票数
    private Integer votes = 0;
}
