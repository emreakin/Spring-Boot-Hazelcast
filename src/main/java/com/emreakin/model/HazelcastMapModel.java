package com.emreakin.model;

import lombok.Data;

@Data
public class HazelcastMapModel {
    private String key;
    private String name;
    private int ttl;
}
