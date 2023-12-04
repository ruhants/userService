package com.userService.entities;

import java.util.ArrayList;
import java.util.List;

import com.userService.dto.Rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "micro_users")
public class User {

	@Id
	private String userId;

	@Column(name = "user_name", length = 25)
	private String userName;

	@Column(name = "email_id", length = 15)
	private String email;

	private String about;

	@Transient
	private List<Rating> rating = new ArrayList<>();

}