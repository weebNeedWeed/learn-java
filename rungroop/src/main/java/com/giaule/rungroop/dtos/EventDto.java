package com.giaule.rungroop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    public Long id;
    public String name;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String type;
    public String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
