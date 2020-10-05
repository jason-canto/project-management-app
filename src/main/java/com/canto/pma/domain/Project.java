package com.canto.pma.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Identifier is mandatory")
	private String identifier;

	@NotBlank(message = "Description is mandatory")
	private String description;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedDate;
}
