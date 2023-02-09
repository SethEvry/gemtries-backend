package com.huoji.gemtries.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(unique = true)
	String username;

	@Column(nullable = false)
	String password;

	boolean hasSubmitted = false;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Character> characters;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Gemtry> gemtries;

}
