package com.michael.dansmultipro.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
	private String id;
	private String type;
	private String url;
	private String created_at;
	private String company;
	private String company_url;
	private String location;
	private String title;
	private String description;
	private String how_to_apply;
	private String company_logo;
}