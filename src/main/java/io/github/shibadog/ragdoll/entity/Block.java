package io.github.shibadog.ragdoll.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAccessor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Block {
    private long index;
    private long generateTime;
    private String previousHash;
    private String data;
    private String hash;
}