package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int FilmId;
	private String FilmTitle;
	private String FilmDescription;
	private short FilmRelsYear;
	private int FilmLangId;
	private int FilmRentDur;
	private double FilmRate;
	private int FilmLength;
	private double FilmRepCost;
	private String FilmRating;
	private String FilmFeature;
	
	private List<Actor>actors;
	
	public int getFilmId() {
		return FilmId;
	}
	public void setFilmId(int filmId) {
		FilmId = filmId;
	}
	public String getFilmTitle() {
		return FilmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		FilmTitle = filmTitle;
	}
	public String getFilmDescription() {
		return FilmDescription;
	}
	public void setFilmDescription(String filmDescription) {
		FilmDescription = filmDescription;
	}
	public short getFilmRelsYear() {
		return FilmRelsYear;
	}
	public void setFilmRelsYear(short filmRelsYear) {
		FilmRelsYear = filmRelsYear;
	}
	public int getFilmLangId() {
		return FilmLangId;
	}
	public void setFilmLangId(int filmLangId) {
		FilmLangId = filmLangId;
	}
	public int getFilmRentDur() {
		return FilmRentDur;
	}
	public void setFilmRentDur(int filmRentDur) {
		FilmRentDur = filmRentDur;
	}
	public double getFilmRate() {
		return FilmRate;
	}
	public void setFilmRate(double filmRate) {
		FilmRate = filmRate;
	}
	public int getFilmLength() {
		return FilmLength;
	}
	public void setFilmLength(int filmLength) {
		FilmLength = filmLength;
	}
	public double getFilmRepCost() {
		return FilmRepCost;
	}
	public void setFilmRepCost(double filmRepCost) {
		FilmRepCost = filmRepCost;
	}
	public String getFilmRating() {
		return FilmRating;
	}
	public void setFilmRating(String filmRating) {
		FilmRating = filmRating;
	}
	public String getFilmFeature() {
		return FilmFeature;
	}
	public void setFilmFeature(String filmFeature) {
		FilmFeature = filmFeature;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	@Override
	public String toString() {
		return "Film [FilmId=" + FilmId + ", FilmTitle=" + FilmTitle + ", FilmDescription=" + FilmDescription
				+ ", FilmRelsYear=" + FilmRelsYear + ", FilmLangId=" + FilmLangId + ", FilmRentDur=" + FilmRentDur
				+ ", FilmRate=" + FilmRate + ", FilmLength=" + FilmLength + ", FilmRepCost=" + FilmRepCost
				+ ", FilmRating=" + FilmRating + ", FilmFeature=" + FilmFeature + ", actors=" + actors + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(FilmDescription, FilmFeature, FilmId, FilmLangId, FilmLength, FilmRate, FilmRating,
				FilmRelsYear, FilmRentDur, FilmRepCost, FilmTitle, actors);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(FilmDescription, other.FilmDescription) && Objects.equals(FilmFeature, other.FilmFeature)
				&& FilmId == other.FilmId && FilmLangId == other.FilmLangId && FilmLength == other.FilmLength
				&& Double.doubleToLongBits(FilmRate) == Double.doubleToLongBits(other.FilmRate)
				&& Objects.equals(FilmRating, other.FilmRating) && FilmRelsYear == other.FilmRelsYear
				&& FilmRentDur == other.FilmRentDur
				&& Double.doubleToLongBits(FilmRepCost) == Double.doubleToLongBits(other.FilmRepCost)
				&& Objects.equals(FilmTitle, other.FilmTitle) && Objects.equals(actors, other.actors);
	}
	
	public Film() {}
	public Film(int filmId, String filmTitle, String filmDescription, short filmRelsYear, int filmLangId,
			int filmRentDur, double filmRate, int filmLength, double filmRepCost, String filmRating,
			String filmFeature) {
		super();
		FilmId = filmId;
		FilmTitle = filmTitle;
		FilmDescription = filmDescription;
		FilmRelsYear = filmRelsYear;
		FilmLangId = filmLangId;
		FilmRentDur = filmRentDur;
		FilmRate = filmRate;
		FilmLength = filmLength;
		FilmRepCost = filmRepCost;
		FilmRating = filmRating;
		FilmFeature = filmFeature;
	}
	
	
}
