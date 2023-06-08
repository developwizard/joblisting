package com.dewiz.joblisting;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
@Data
@ToString
@NoArgsConstructor
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}
