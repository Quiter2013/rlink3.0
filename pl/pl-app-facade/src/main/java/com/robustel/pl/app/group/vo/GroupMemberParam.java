package com.robustel.pl.app.group.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupMemberParam implements Serializable{

	private static final long serialVersionUID = 1L;

	private String rootGroupId;
	
	private String userId;
}
