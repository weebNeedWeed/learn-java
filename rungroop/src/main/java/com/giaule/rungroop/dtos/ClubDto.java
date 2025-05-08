package com.giaule.rungroop.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Title couldn't be empty")
    private String title;
    @NotEmpty(message = "Photo Url couldn't be empty")
    private String photoUrl;
    @NotEmpty(message = "Content couldn't be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
