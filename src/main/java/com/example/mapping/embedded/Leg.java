package com.example.mapping.embedded;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@Embeddable
public class Leg {

	private int kneePowerLeft;
	private int kneePowerRight;

}
