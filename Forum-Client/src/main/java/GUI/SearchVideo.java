package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class SearchVideo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	

	
	
	
	
	 /** Global instance properties filename. */
	  private static String PROPERTIES_FILENAME = "youtube.properties";

	  /** Global instance of the HTTP transport. */
	  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	  /** Global instance of the JSON factory. */
	  private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	  /** Global instance of the max number of videos we want returned (50 = upper limit per page). */
	  private static final long NUMBER_OF_VIDEOS_RETURNED = 4;

	  /** Global instance of Youtube object to make all API requests. */
	  private static YouTube youtube;
	  private JTextField textField_1;
	  private JTextField textField_2;
	  private JTextField textField_3;
	  private JLabel lblResult_1;
	  private JLabel lblResult_2;
	  private JLabel r1;
	  private JLabel r2;
	  private JLabel r3;
	  private JLabel lblResult_3;
	  private JLabel r4;
	  private JTextField textField_4;
	  private JLabel lblLink;
	  private JLabel label;
	  private JLabel label_1;
	  private JLabel label_2;
	  private JLabel lblNewLabel;
	  private JLabel label_3;
	  private JLabel label_4;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchVideo frame = new SearchVideo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public SearchVideo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_3 = new JLabel("YOUTUBE");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(170, 21, 102, 48);
		contentPane.add(label_3);
		
		label_4 = new JLabel("UPLOAD");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(274, 21, 102, 48);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(136, 70, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String queryTerm = textField.getText();
				 Properties properties = new Properties();
				    try {
				      InputStream in = Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
				      properties.load(in);

				    } catch (IOException f) {
				      System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + f.getCause()
				          + " : " + f.getMessage());
				      System.exit(1);
				    }

				    try {
				      /*
				       * The YouTube object is used to make all API requests. The last argument is required, but
				       * because we don't need anything initialized when the HttpRequest is initialized, we override
				       * the interface and provide a no-op function.
				       */
				      youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
				        public void initialize(HttpRequest request) throws IOException {}
				      }).setApplicationName("youtube-cmdline-search-sample").build();
				      
				      
				      
				      
				      YouTube.Search.List search = youtube.search().list("id,snippet");

				      /*
				       * It is important to set your developer key from the Google Developer Console for
				       * non-authenticated requests (found under the API Access tab at this link:
				       * code.google.com/apis/). This is good practice and increased your quota.
				       */
				      String apiKey = properties.getProperty("youtube.apikey");
				      search.setKey(apiKey);
				      search.setQ(queryTerm);
				      /*
				       * We are only searching for videos (not playlists or channels). If we were searching for
				       * more, we would add them as a string like this: "video,playlist,channel".
				       */
				      search.setType("video");
				      /*
				       * This method reduces the info returned to only the fields we need and makes calls more
				       * efficient.
				       */
				      search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
				      search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
				      SearchListResponse searchResponse = search.execute();

				      List<SearchResult> searchResultList = searchResponse.getItems();

				      
				     
				     
				      if (searchResultList != null) {
				    	  
				    	  
				    	  
				    	
				    	  
				    	  System.out.println("\n=============================================================");
						    System.out.println(
						        "   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search on \"" + queryTerm + "\".");
						    System.out.println("=============================================================\n");

						    if (!searchResultList.iterator().hasNext()) {
						      System.out.println(" There aren't any results for your query.");
						    }
						   
						    String[] videoName = new String[4];
						    String[] videoUrl =new String[4] ;
					    int i = 0;
						    for(SearchResult results : searchResultList){	
						    	 SearchResult singleVideo = results;
							      ResourceId rId = singleVideo.getId();
							        Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().get("default");
							        
							       // textField_1.setText(rId.getVideoId());
							        videoUrl[i] = rId.getVideoId();
							        videoName[i] = singleVideo.getSnippet().getTitle();
							        
							        System.out.println(" Video Id" + rId.getVideoId());
							        System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
							        System.out.println(" Thumbnail: " + thumbnail.getUrl());
							        System.out.println("\n-------------------------------------------------------------\n");
							      i++;
						    }
						    
						  
						    	
						    	textField_1.setText("https://www.youtube.com/watch?v="+videoUrl[0]);
						    	textField_2.setText("https://www.youtube.com/watch?v="+videoUrl[1]);
						    	textField_3.setText("https://www.youtube.com/watch?v="+videoUrl[2]);
						    	textField_4.setText("https://www.youtube.com/watch?v="+videoUrl[3]);
						    	
						    	r1.setText(videoName[0]);
						    	r2.setText(videoName[1]);
						    	r3.setText(videoName[2]);
						    	r4.setText(videoName[3]);
						    
						    
						    
						  System.out.println("Hey:"+videoName[1]);
						    
							
				      }
				    } catch (GoogleJsonResponseException f) {
				      System.err.println("There was a service error: " + f.getDetails().getCode() + " : "
				          + f.getDetails().getMessage());
				    } catch (IOException f) {
				      System.err.println("There was an IO error: " + f.getCause() + " : " + f.getMessage());
				    } catch (Throwable t) {
				      t.printStackTrace();
				    }
				
				
				
				
				
			
			System.out.println("thisss "+queryTerm);
			
			
			//*********************
			
			    
			    
			    
			    
			    
			      
			      
			//********************
			
			
			
			
			
			
			    
			
			
			}
		});
		btnNewButton.setBounds(306, 69, 99, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 121, 316, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 167, 316, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(89, 216, 316, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblResult = new JLabel("Result 1:");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(89, 108, 71, 14);
		contentPane.add(lblResult);
		
		lblResult_1 = new JLabel("Result 2:");
		lblResult_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult_1.setForeground(Color.WHITE);
		lblResult_1.setBounds(89, 152, 71, 14);
		contentPane.add(lblResult_1);
		
		lblResult_2 = new JLabel("Result 3:");
		lblResult_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult_2.setForeground(Color.WHITE);
		lblResult_2.setBounds(89, 198, 55, 14);
		contentPane.add(lblResult_2);
		
		r1 = new JLabel("New label");
		r1.setFont(new Font("Tahoma", Font.BOLD, 12));
		r1.setForeground(Color.WHITE);
		r1.setBounds(170, 108, 235, 14);
		contentPane.add(r1);
		
		r2 = new JLabel("New label");
		r2.setFont(new Font("Tahoma", Font.BOLD, 12));
		r2.setForeground(Color.WHITE);
		r2.setBounds(170, 152, 235, 14);
		contentPane.add(r2);
		
		r3 = new JLabel("New label");
		r3.setFont(new Font("Tahoma", Font.BOLD, 12));
		r3.setForeground(Color.WHITE);
		r3.setBounds(170, 198, 235, 14);
		contentPane.add(r3);
		
		lblResult_3 = new JLabel("Result 4:");
		lblResult_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult_3.setForeground(Color.WHITE);
		lblResult_3.setBounds(89, 247, 63, 14);
		contentPane.add(lblResult_3);
		
		r4 = new JLabel("New label");
		r4.setFont(new Font("Tahoma", Font.BOLD, 12));
		r4.setForeground(Color.WHITE);
		r4.setBounds(170, 247, 235, 14);
		contentPane.add(r4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(89, 259, 316, 20);
		contentPane.add(textField_4);
		
		lblLink = new JLabel("Link:");
		lblLink.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLink.setForeground(Color.WHITE);
		lblLink.setBounds(42, 122, 37, 17);
		contentPane.add(lblLink);
		
		label = new JLabel("Link:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(42, 167, 37, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("Link:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(42, 216, 37, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Link:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(42, 259, 37, 14);
		contentPane.add(label_2);
		
		JButton button = new JButton("Copy Link");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(textField_1.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "Your Youtube URL has been Copied !");
				
				new GUIcontentMovies().setVisible(true);
				
			}
		});
		button.setBounds(415, 118, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Copy Link");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StringSelection stringSelection = new StringSelection(textField_2.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "Your Youtube URL has been Copied !");
				
				new GUIcontentMovies().setVisible(true);
			
			}
		});
		button_1.setBounds(415, 164, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Copy Link");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(textField_3.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "Your Youtube URL has been Copied !");
				
				new GUIcontentMovies().setVisible(true);
			}
		});
		button_2.setBounds(415, 213, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Copy Link");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(textField_4.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "Your Youtube URL has been Copied !");
				
				new GUIcontentMovies().setVisible(true);
			}
		});
		button_3.setBounds(415, 256, 89, 23);
		contentPane.add(button_3);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marwen\\Desktop\\FMS JEE\\SX4JNp.png"));
		lblNewLabel.setBounds(0, 0, 525, 350);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
