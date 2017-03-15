package Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import Entities.Category;
import Entities.Content;
import Entities.Genre;


import Entities.User;




/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Utilities() {
	}

	@PostConstruct
	public void initDb() {
		User admin=new User();
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setUsername("admin");
		admin.setPassword("admin");
		Date naissanceadmin;
		try {
			naissanceadmin = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			admin.setDateOfBirth(naissanceadmin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		admin.setEmail("admin@esprit.tn");
		admin.setRole("admin");
		admin.setEnabled(true);
		admin.setResponsibleOf("All");
		User moderator=new User();
		moderator.setFirstName("moderator");
		moderator.setLastName("moderator");
		moderator.setUsername("moderator");
		moderator.setPassword("moderator");
		Date naissancemod;
		try {
			naissancemod = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator.setDateOfBirth(naissancemod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator.setEmail("moderator@esprit.tn");
		moderator.setRole("moderator");
		moderator.setResponsibleOf("Movies");
		moderator.setEnabled(true);
		User moderator1=new User();
		moderator1.setFirstName("moderator1");
		moderator1.setLastName("moderator1");
		moderator1.setUsername("moderator1");
		moderator1.setPassword("moderator1");
		Date naissancemod1;
		try {
			naissancemod1 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator1.setDateOfBirth(naissancemod1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator1.setEmail("moderator1@esprit.tn");
		moderator1.setRole("moderator");
		moderator1.setResponsibleOf("Games");
		moderator1.setEnabled(true);
		User moderator2=new User();
		moderator2.setFirstName("moderator2");
		moderator2.setLastName("moderator2");
		moderator2.setUsername("moderator2");
		moderator2.setPassword("moderator2");
		Date naissancemod2;
		try {
			naissancemod2 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator2.setDateOfBirth(naissancemod2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator2.setEmail("moderator2@esprit.tn");
		moderator2.setRole("moderator");
		moderator2.setResponsibleOf("TV");
		moderator2.setEnabled(true);

		User moderator3=new User();
		moderator3.setFirstName("moderator3");
		moderator3.setLastName("moderator3");
		moderator3.setUsername("moderator3");
		moderator3.setPassword("moderator3");
		Date naissancemod3;
		try {
			naissancemod3 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator3.setDateOfBirth(naissancemod3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		moderator3.setEmail("moderator3@esprit.tn");
		moderator3.setRole("moderator");
		moderator3.setResponsibleOf("Music");
		moderator3.setEnabled(true);
		User user =new User();
		user.setFirstName("Makni");
		user.setLastName("Ali");
		user.setUsername("alimakni");
		user.setPassword("M11015485");
		Date naissance;
		try {
			naissance = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			user.setDateOfBirth(naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		user.setRole("User");
		user.setEmail("ali.makni@esprit.tn");
		user.setEnabled(true);
		
		User user1 =new User();
		user1.setFirstName("Attallah");
		user1.setLastName("Marween");
		user1.setUsername("marweenattallah");
		user1.setPassword("Matt");
		Date naissance1;
		try {
			naissance1 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			user1.setDateOfBirth(naissance1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user1.setRole("User");
		user1.setEmail("marween.attallah@esprit.tn");
		user1.setEnabled(true);
		
		entityManager.persist(admin);
		entityManager.persist(moderator);
		entityManager.persist(moderator1);
		entityManager.persist(moderator2);
		entityManager.persist(moderator3);
		entityManager.persist(user);
		entityManager.persist(user1);
	////////////////////////////////////////////////////////////
	
		
		
		
		
		
		
////////////////////////////////////////////////////////////
		
		Content content1 =new Content();
		content1.setTitle("Shutter Island");
		content1.setDescription("mind blowing");
		content1.setRating(8.1);
		content1.setTrailer("www.IMDB.comSI");
		content1.setGenre(Genre.THRILLER);
		content1.setYearReleased(2007);
		content1.setCategory(Category.MOVIES);
		
		Content content2 = new Content("The Ring",Genre.HORROR,"HORRIFIC","www.youtube",2004, 7.4,
				Category.MOVIES);
		
		Content content3 = new Content("The Hangover",Genre.COMEDY,"FUNNY","YTS",2009, 8.0,
				Category.MOVIES);
		
		Content content4 = new Content("Minions",Genre.ADVENTURE,"KIDS","Metacritics",2013, 9.0,
				Category.MOVIES);
		
		Content content5 = new Content("HER",Genre.ROMANCE,"OS coming to life","www.youtube.com/HER",2012, 8.0,
				Category.MOVIES);
		
		Content content6 = new Content("Shadow Of Mordor",Genre.ADVENTURE,"Lord Of The Rings","www.youtube.com/Lord Of The Rings",2003, 9.5,
				Category.GAMES);
		
		Content content7 = new Content("Guns And Roses",Genre.DRAMA,"Lord Of The Rings","https://www.youtube.com/watch?v=8SbUC-UaAxE",1992, 2.0,
				Category.MUSIC);
		
		Content content8 = new Content("My Happy Ending",Genre.DRAMA,"Avril Lavigne","https://www.youtube.com/watch?v=afefae",1999, 8.0,
				Category.MUSIC);
		Content content9= new Content("Big Bang Theory",Genre.COMEDY,"Sitcom","https://www.youtube.com/watch?v=aggdsdsae",2010, 8.0,
				Category.TV);
		Content content10= new Content("Vikings",Genre.ACTION,"Scandinavian History","https://www.youtube.com/watch?v=a4455zae",2015, 8.5,
				Category.TV);
		Content content11= new Content("Game Of Thrones",Genre.ADVENTURE,"7 Kingdoms","https://www.youtube.com/watch?v=a4455zae",2011, 9.5,
				Category.TV);
		
		entityManager.persist(content1);
		entityManager.persist(content2);
		entityManager.persist(content3);
		entityManager.persist(content4);
		entityManager.persist(content5);
		entityManager.persist(content6);
		entityManager.persist(content7);
		entityManager.persist(content8);
		entityManager.persist(content9);
		entityManager.persist(content10);
		entityManager.persist(content11);
	
	}
	
	
}