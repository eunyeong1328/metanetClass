package org.zerock.domain;

import lombok.Data;

@Data
public class PostVO {
	private int post_seq;
	private String post_title;
	private String post_job;
	private String post_career;
	private String post_emptype;
	private String post_add;
}

