package com.emreakin.configuration;

import com.emreakin.model.HazelcastMapModel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "hazelcast")
public class HazelcastMapProperties {
    private List<HazelcastMapModel> maps;
}
