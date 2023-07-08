package com.theatre.booking.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="theatre")
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String moviename;
	private String time;
	private int seatsavailable;
	private int cost;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSeatsavailable() {
		return seatsavailable;
	}
	public void setSeatsavailable(int seatsavailable) {
		this.seatsavailable = seatsavailable;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
