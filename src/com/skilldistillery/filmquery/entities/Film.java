package com.skilldistillery.filmquery.entities;

public class Film {
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageID;
	private int rentalDureantion;
	private int length;
	private double replaementCost;
	private String rating;
	private String specialFeatures;
//	list of actors
	

	public Film() {
		super();
	}

	public Film(int id, String title, String description, Integer releaseYear, int languageID, int rentalDureantion,
			int length, double replaementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageID = languageID;
		this.rentalDureantion = rentalDureantion;
		this.length = length;
		this.replaementCost = replaementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageID() {
		return languageID;
	}

	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public int getRentalDureantion() {
		return rentalDureantion;
	}

	public void setRentalDureantion(int rentalDureantion) {
		this.rentalDureantion = rentalDureantion;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplaementCost() {
		return replaementCost;
	}

	public void setReplaementCost(double replaementCost) {
		this.replaementCost = replaementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=").append(id).append(", title=").append(title).append(", description=")
				.append(description).append(", releaseYear=").append(releaseYear).append(", languageID=")
				.append(languageID).append(", rentalDureantion=").append(rentalDureantion).append(", length=")
				.append(length).append(", replaementCost=").append(replaementCost).append(", rating=").append(rating)
				.append(", specialFeatures=").append(specialFeatures).append("]");
		return builder.toString();
	}

}
