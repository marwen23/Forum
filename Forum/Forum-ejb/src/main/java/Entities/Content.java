package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Content
 *
 */
@Entity

public class Content implements Serializable {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Genre genre;
	private String description;
	private String trailer;
	private int yearReleased;
	private Double rating;
	private Category category;
	@OneToMany(mappedBy="content")
	private List<FC> fcs;
	
	
	
	@OneToMany(mappedBy="content")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy="content")
	private List<Comment> comments;
	
	@OneToMany(mappedBy="content")
	private List<Award>awards;
	@ManyToOne
	private Admin admin;
	
	@OneToOne
	private Moderator moderator;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Moderator getModerator() {
		return moderator;
	}
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	public List<FC> getFcs() {
		return fcs;
	}
	public void setFcs(List<FC> fcs) {
		this.fcs = fcs;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Award> getAwards() {
		return awards;
	}
	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	private static final long serialVersionUID = 1L;

	public Content() {
		super();
	}   
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	
	public Genre getGenre() {
        return genre;
    
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public Content(String title, Genre genre, String description, String trailer, Category category) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Content(Integer id, String title, Genre genre, String description, String trailer) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
	}
	public Content(String title, Genre genre, String description, String trailer) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
	}
	public Content(String title, Genre genre, String description, String trailer, int yearReleased,
			Category category) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
		this.yearReleased = yearReleased;
		this.category = category;
	}
	
	public Content(String title, Genre genre, String description, String trailer, int yearRleased) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
		this.yearReleased = yearReleased;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Content(String title, Genre genre, String description, String trailer, int yearReleased, Double rating,
			Category category) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
		this.yearReleased = yearReleased;
		this.rating = rating;
		this.category = category;
	}
	public Content(Integer id, String title, Genre genre, String description, String trailer, int yearReleased,
			Double rating, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.trailer = trailer;
		this.yearReleased = yearReleased;
		this.rating = rating;
		this.category = category;
	}
	
	
	
	
	
	
	
}
