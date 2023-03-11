package com.emreakin.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class TokenModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String token;
    private Date creationDate;
}
