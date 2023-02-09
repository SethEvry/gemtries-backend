package com.huoji.gemtries.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "gemtries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gemtry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne
	Character character;

	@ManyToOne
	User user;

	LocalDate localDate;

	int firstRun;
	int secondRun;
	int bossRush;

	int rested;
	int redRoomOne;
	int redRoomTwo;
}
