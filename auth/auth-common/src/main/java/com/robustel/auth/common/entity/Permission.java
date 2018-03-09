package com.robustel.auth.common.entity;

import lombok.Data;

import java.util.UUID;


@Data
public class Permission {

    private String id;

    private String permission;

    private String description;
}
