package Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Category;
import Entities.Content;
import Entities.Genre;

/**
 * Session Bean implementation class ContentServices
 */
@Stateless
public class ContentServices implements ContentServicesRemote, ContentServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ContentServices() {
	}

	@Override
	public void addContent(String title, Genre genre, String description, String trailer, int yearReleased,Double rating
			,Category category) {
		// TODO Auto-generated method stub
		Content content = new Content(title, genre, description, trailer, yearReleased,rating, category);
		entityManager.persist(content);
	}
	
	@Override
	public void addContentWeb(Content content) {
		// TODO Auto-generated method stub
		entityManager.persist(content);
	}

	@Override
	public Content findContentById(Integer id) {
		return entityManager.find(Content.class, id);
	}
	
	@Override
	public List<Content> findContentByTitle(String title) {
		Query query = entityManager.createQuery("select c from Content c where c.title=:tit");
		query.setParameter("tit", title);
		
		return query.getResultList();

		// query.setParameter("cat", category);
		// return query;

	}

	@Override
	public void deleteContent(Content content) {
		entityManager.remove(entityManager.merge(content));

	}

	@Override
	public void deleteContentById(Integer id) {
		entityManager.remove(findContentById(id));
	}

	@Override
	public void updateContent(Content content) {
		entityManager.merge(content);

	}

	@Override
	public List<Content> findAllContents() {
		return entityManager.createQuery("select c from Content c ").getResultList();
	}

	@Override
	public List<Content> findContentByCategory(Category category) {
		Query query = entityManager.createQuery("select c from Content c where c.category=:cat");
		query.setParameter("cat", category);
		return query.getResultList();

		// query.setParameter("cat", category);
		// return query;

	}
	
	@Override
	public List<Content> searchContent(String keyword) {
		Query query = entityManager.createQuery("select c from Content c where c.title LIKE :key");
		query.setParameter("key", '%' + keyword + '%');
		
		return query.getResultList();

	}

	@Override
	public Category findCategoryById(int id) {
		return entityManager.find(Category.class, id);

	}

	public ArrayList<Content> listAlphabetically(ArrayList<Content> contents) {
		class AlphabeticalComparator implements Comparator<Content> {
			@Override
			public int compare(Content cnt1, Content cnt2) {
				return cnt1.getTitle().compareTo(cnt2.getTitle());
			}
		}
		Collections.sort(contents, new AlphabeticalComparator());
		return contents;
	}

	public ArrayList<Content> listByGenre(ArrayList<Content> contents) {
		class GenreComparator implements Comparator<Content> {
			@Override
			public int compare(Content cnt1, Content cnt2) {
				return cnt1.getGenre().toString().compareTo(cnt2.getGenre().toString());
			}

		}
		Collections.sort(contents, new GenreComparator());
		return contents;
	}
	
	

	// @Override
	// public Category findCategoryById(int id) {
	// return entityManager.find(Category.class, id);

	// }

	/*
	 * @Override public void deleteContent(Content content) {
	 * entityManager.remove(entityManager.merge(content)); }
	 * 
	 * @Override public void updateContent(Content content) {
	 * entityManager.merge(content);
	 * 
	 * }
	 * 
	 * @Override public Player findPlayerById(Integer id) { return
	 * entityManager.find(Player.class, id); }
	 * 
	 * @Override public Team findTeamById(Integer id) { return
	 * entityManager.find(Team.class, id); }
	 * 
	 * @Override public void deletePlayer(Player player) {
	 * entityManager.remove(entityManager.merge(player)); }
	 * 
	 * @Override public List<Team> findAllTeams() { return
	 * entityManager.createQuery("select t from Team t ").getResultList(); }
	 */

}
