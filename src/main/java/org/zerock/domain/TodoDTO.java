package org.zerock.domain;

import lombok.Data;

import java.util.Date;

// 135page
@Data
public class TodoDTO {
    private String title;
    private Date dueDate;
}
