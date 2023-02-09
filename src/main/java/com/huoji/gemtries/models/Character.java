package com.huoji.gemtries.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(unique = true, nullable = false)
	String name;

	@Column(nullable = false)
	CharacterClass characterClass;

	double itemLevel;

	@ManyToOne
	User user;

	@OneToMany(mappedBy = "character")
	@JsonIgnore
	List<Gemtry> gemtries;

}
