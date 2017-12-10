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
import Entities.ResponsibilityOf;
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
			naissanceadmin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-14 17:05:14");
			admin.setDateOfBirth(naissanceadmin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		admin.setEmail("admin@esprit.tn");
		admin.setRole("admin");
		admin.setEnabled(true);
		User moderator=new User();
		moderator.setFirstName("moderator");
		moderator.setLastName("moderator");
		moderator.setUsername("moderator");
		moderator.setPassword("moderator");
		Date naissancemod;
		try {
			naissancemod = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:05:17");
			moderator.setDateOfBirth(naissancemod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator.setEmail("moderator@esprit.tn");
		moderator.setRole("moderator");
		moderator.setResponsibleOf(ResponsibilityOf.MOVIES);
		moderator.setEnabled(true);
		User moderator1=new User();
		moderator1.setFirstName("moderator1");
		moderator1.setLastName("moderator1");
		moderator1.setUsername("moderator1");
		moderator1.setPassword("moderator1");
		Date naissancemod1;
		try {
			naissancemod1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-18 17:05:55");
			moderator1.setDateOfBirth(naissancemod1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator1.setEmail("moderator1@esprit.tn");
		moderator1.setRole("moderator");
		moderator1.setResponsibleOf(ResponsibilityOf.GAMES);
		moderator1.setEnabled(true);
		User moderator2=new User();
		moderator2.setFirstName("moderator2");
		moderator2.setLastName("moderator2");
		moderator2.setUsername("moderator2");
		moderator2.setPassword("moderator2");
		Date naissancemod2;
		try {
			naissancemod2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-25 17:05:50");
			moderator2.setDateOfBirth(naissancemod2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator2.setEmail("moderator2@esprit.tn");
		moderator2.setRole("moderator");
		moderator2.setResponsibleOf(ResponsibilityOf.TV);
		moderator2.setEnabled(true);

		User moderator3=new User();
		moderator3.setFirstName("moderator3");
		moderator3.setLastName("moderator3");
		moderator3.setUsername("moderator3");
		moderator3.setPassword("moderator3");
		Date naissancemod3;
		try {
			naissancemod3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-28 17:08:50");
			moderator3.setDateOfBirth(naissancemod3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		moderator3.setEmail("moderator3@esprit.tn");
		moderator3.setRole("moderator");
		moderator3.setResponsibleOf(ResponsibilityOf.MUSIC);
		moderator3.setEnabled(true);
		User user =new User();
		user.setFirstName("Makni");
		user.setLastName("Ali");
		user.setUsername("alimakni");
		user.setPassword("alimakni");
		Date naissance;
		try {
			naissance = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-08-14 17:08:45");
			user.setDateOfBirth(naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		user.setRole("user");
		user.setEmail("ali.makni@esprit.tn");
		user.setEnabled(true);
		
		User user1 =new User();
		user1.setFirstName("Attallah");
		user1.setLastName("Marween");
		user1.setUsername("marweenattallah");
		user1.setPassword("marweenattallah");
		Date naissance1;
		try {
			naissance1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:08:45");
			user1.setDateOfBirth(naissance1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user1.setRole("user");
		user1.setEmail("marween.attallah@esprit.tn");
		user1.setEnabled(true);
		User user2 =new User();
		user2.setFirstName("Nasri");
		user2.setLastName("Mohamed");
		user2.setUsername("mohamednasri");
		user2.setPassword("mohamednasri");
		Date naissance2;
		try {
			naissance2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-07 17:08:40");
			user2.setDateOfBirth(naissance2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user2.setRole("user");
		user2.setEmail("marween.attallah@esprit.tn");
		user2.setEnabled(true);
		
		User user3 =new User();
		user3.setFirstName("Maghraoui");
		user3.setLastName("Sana");
		user3.setUsername("maghraouiSana");
		user3.setPassword("maghraouiSana");
		Date naissance3;
		try {
			naissance3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:08:40");
			user3.setDateOfBirth(naissance3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user3.setRole("user");
		user3.setEmail("sana.maghraoui@esprit.tn");
		user3.setEnabled(true);
		User user4 =new User();
		user4.setFirstName("Aissa");
		user4.setLastName("Fidee");
		user4.setUsername("fideeaissa");
		user4.setPassword("fideeaissa");
		Date naissance4;
		try {
			naissance4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-07 17:08:35");
			user4.setDateOfBirth(naissance4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user4.setRole("user");
		user4.setEmail("marween.attallah@esprit.tn");
		user4.setEnabled(true);
		entityManager.persist(admin);
		entityManager.persist(moderator);
		entityManager.persist(moderator1);
		entityManager.persist(moderator2);
		entityManager.persist(moderator3);
		entityManager.persist(user);
		entityManager.persist(user1);
		entityManager.persist(user2);
		entityManager.persist(user3);
		entityManager.persist(user4);
	////////////////////////////////////////////////////////////
	
		
		
		
		
		
		
////////////////////////////////////////////////////////////
		
		Content content1 =new Content();
		content1.setTitle("Shutter Island");
		content1.setDescription("mind blowing");
		content1.setRating(8.1);
		content1.setImage("shutter.jpg");
		content1.setTrailer("https://www.youtube.com/v/5iaYLCiq5RM");
		content1.setGenre(Genre.THRILLER);
		content1.setYearReleased(2007);
		content1.setCategory(Category.MOVIES);
		
		Content content9 =new Content();
		content9.setTitle("Arrival");
		content9.setDescription("ALIEN");
		content9.setRating(8.1);
		content9.setImage("arrival.jpg");
		content9.setTrailer("https://www.youtube.com/v/tFMo3UJ4B4g");
		content9.setGenre(Genre.SCIFI);
		content9.setYearReleased(2016);
		content9.setCategory(Category.MOVIES);
		
		Content content2 = new Content("The Ring",Genre.HORROR,"The Ring is a horror movie","https://www.youtube.com/v/NFB4eZSVgBE",2004, 7.4,
				Category.MOVIES,"thering.jpg");
		
		Content content3 = new Content("The Hangover",Genre.COMEDY,"FUNNY","https://www.youtube.com/v/tcdUhdOlz9M",2009, 8.0,
				Category.MOVIES,"The Hangover.jpg");
		
		Content content4 = new Content("Minions",Genre.ADVENTURE,"KIDS","https://www.youtube.com/v/eisKxhjBnZ0",2013, 9.0,
				Category.MOVIES,"Minions.jpg");
		
		Content content5 = new Content("HER",Genre.ROMANCE,"OS coming to life","https://www.youtube.com/v/WzV6mXIOVl4",2012, 8.0,
				Category.MOVIES,"HER.jpg");
		
		Content content6 = new Content("Shadow Of Mordor",Genre.ADVENTURE,"Lord Of The Rings","https://www.youtube.com/v/4rbOTQhasnM",2003, 9.5,
				Category.GAMES,"SOM.jpg");
		
		Content content7 = new Content("Guns And Roses",Genre.DRAMA,"ROck and Roll","https://www.youtube.com/v/8SbUC-UaAxE",1992, 2.0,
				Category.MUSIC,"gnr.jpg");
		
		Content content8 = new Content("My Happy Ending",Genre.DRAMA,"Avril Lavigne","https://www.youtube.com/v/s8QYxmpuyxg",1999, 8.0,
				Category.MUSIC,"avril.jpg");
		Content content12= new Content("Big Bang Theory",Genre.COMEDY,"Sitcom","https://www.youtube.com/v/WBb3fojgW0Q",2010, 8.0,
				Category.TV,"BBT.jpg");
		Content content10= new Content("Vikings",Genre.ACTION,"Scandinavian History","https://www.youtube.com/v/G3DwTh_aPKw",2015, 8.5,
				Category.TV,"vikings.jpg");
		Content content11= new Content("Game Of Thrones",Genre.ADVENTURE,"7 Kingdoms","https://www.youtube.com/v/JxWfvtnHtS0",2011, 9.5,
				Category.TV,"GOT.jpg");
		
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