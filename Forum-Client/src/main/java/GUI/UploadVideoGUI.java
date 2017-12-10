package GUI;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.FileCredentialStore;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import com.google.common.collect.Lists;




import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import nu.zoom.swing.desktop.component.filechooser.impl.RegExpFileFilter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.samples.youtube.cmdline.youtube_cmdline_uploadvideo_sample.UploadVideo;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import com.google.common.collect.Lists;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.Color;
public class UploadVideoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField link;
	private JTextField tit;
	private JTextField tag1;
	private JTextField tag2;
	private JTextField tag3;
	private JTextField tag4;
	private  GUIcontentMovies gUIcontentMovies;
	public String url;
	
	
	

	//**************************************
	
	  public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	/** Global instance of the HTTP transport. */
	  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	  /** Global instance of the JSON factory. */
	  private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	  /** Global instance of Youtube object to make all API requests. */
	  private static YouTube youtube;

	  /* Global instance of the format used for the video being uploaded (MIME type). */
	  private static String VIDEO_FILE_FORMAT = "video/*";
	  private JTextField youtubeLink;
	  private JButton btnCopyLink;
	  private JLabel lblNewLabel_2;
	  private JLabel lblYoutube;
	  private JLabel lblUpload;

	  /**
	   * Authorizes the installed application to access user's protected data.
	   *
	   * @param scopes list of scopes needed to run youtube upload.
	   */
	  private static Credential authorize(List<String> scopes) throws Exception {

	    // Load client secrets.
	    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
	        JSON_FACTORY, UploadVideo.class.getResourceAsStream("/client_secrets.json"));

	    // Checks that the defaults have been replaced (Default = "Enter X here").
	    if (clientSecrets.getDetails().getClientId().startsWith("Enter")
	        || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
	      System.out.println(
	          "Enter Client ID and Secret from https://code.google.com/apis/console/?api=youtube"
	          + "into youtube-cmdline-uploadvideo-sample/src/main/resources/client_secrets.json");
	      System.exit(1);
	    }

	    // Set up file credential store.
	    FileCredentialStore credentialStore = new FileCredentialStore(
	        new File(System.getProperty("user.home"), ".credentials/youtube-api-uploadvideo.json"),
	        JSON_FACTORY);

	    // Set up authorization code flow.
	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, scopes).setCredentialStore(credentialStore)
	        .build();

	    // Build the local server and bind it to port 9000
	    LocalServerReceiver localReceiver = new LocalServerReceiver.Builder().setPort(8080).build();

	    // Authorize.
	    return new AuthorizationCodeInstalledApp(flow, localReceiver).authorize("user");
	  }
	
	
	//*****************************************
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadVideoGUI frame = new UploadVideoGUI();
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
	public UploadVideoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Choose Video");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser= new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				String filepath=f.getAbsolutePath();
				link.setText(filepath);
				
				
			}
		});
		
		lblUpload = new JLabel("UPLOAD");
		lblUpload.setForeground(Color.WHITE);
		lblUpload.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpload.setBounds(429, 50, 102, 58);
		contentPane.add(lblUpload);
		
		lblYoutube = new JLabel("YOUTUBE");
		lblYoutube.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblYoutube.setBounds(325, 50, 102, 58);
		contentPane.add(lblYoutube);
		
		btnNewButton.setBounds(460, 119, 125, 23);
		contentPane.add(btnNewButton);
		
		link = new JTextField();
		link.setBounds(272, 120, 178, 20);
		contentPane.add(link);
		link.setColumns(10);
		
		tit = new JTextField();
		tit.setBounds(272, 163, 298, 20);
		contentPane.add(tit);
		tit.setColumns(10);
		
		tag1 = new JTextField();
		tag1.setBounds(292, 248, 62, 20);
		contentPane.add(tag1);
		tag1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(225, 163, 37, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPath.setBounds(220, 120, 43, 16);
		contentPane.add(lblPath);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(190, 198, 79, 14);
		contentPane.add(lblDescription);
		
		JTextArea descrip = new JTextArea();
		descrip.setBounds(273, 194, 297, 43);
		contentPane.add(descrip);
		
		JLabel lblNewLabel_1 = new JLabel("Tags:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(239, 248, 43, 18);
		contentPane.add(lblNewLabel_1);
		
		tag2 = new JTextField();
		tag2.setBounds(364, 248, 62, 20);
		contentPane.add(tag2);
		tag2.setColumns(10);
		
		tag3 = new JTextField();
		tag3.setBounds(436, 248, 62, 20);
		contentPane.add(tag3);
		tag3.setColumns(10);
		
		tag4 = new JTextField();
		tag4.setBounds(508, 248, 62, 20);
		contentPane.add(tag4);
		tag4.setColumns(10);
		
		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		  UploadVideo upv = new UploadVideo();
		  String title=tit.getText();
		  String description= descrip.getText();
		  List<String> keywords = new ArrayList<>();
		  keywords.add(tag1.getText());
		  keywords.add(tag2.getText());
		  keywords.add(tag3.getText());
		  keywords.add(tag4.getText());
		  String abspath=link.getText();
		  
		  
		  //upv.TestVideo(title, description, keywords, abspath);
		  
		  
		  
			

		  //************************************************************************
		  
		  
		  // Scope required to upload to YouTube.
		    List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");

		    try {
		      // Authorization.
		      Credential credential = authorize(scopes);

		      // YouTube object used to make all API requests.
		      youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(
		          "youtube-cmdline-uploadvideo-sample").build();

		      // We get the user selected local video file to upload.
		      File videoFile = new File(abspath);
		      System.out.println("You chose " + videoFile + " to upload.");

		      // Add extra information to the video before uploading.
		      Video videoObjectDefiningMetadata = new Video();

		      /*
		       * Set the video to public, so it is available to everyone (what most people want). This is
		       * actually the default, but I wanted you to see what it looked like in case you need to set
		       * it to "unlisted" or "private" via API.
		       */
		      VideoStatus status = new VideoStatus();
		      status.setPrivacyStatus("public");
		      videoObjectDefiningMetadata.setStatus(status);

		      // We set a majority of the metadata with the VideoSnippet object.
		      VideoSnippet snippet = new VideoSnippet();

		      /*
		       * The Calendar instance is used to create a unique name and description for test purposes, so
		       * you can see multiple files being uploaded. You will want to remove this from your project
		       * and use your own standard names.
		       */
		      Calendar cal = Calendar.getInstance();
		      snippet.setTitle(title +" "+ cal.getTime());
		      snippet.setDescription(
		          description + "on " + cal.getTime());

		      // Set your keywords.
		      List<String> tags = keywords;
		     
		      snippet.setTags(tags);

		      // Set completed snippet to the video object.
		      videoObjectDefiningMetadata.setSnippet(snippet);

		      InputStreamContent mediaContent = new InputStreamContent(
		          VIDEO_FILE_FORMAT, new BufferedInputStream(new FileInputStream(videoFile)));
		      mediaContent.setLength(videoFile.length());

		      /*
		       * The upload command includes: 1. Information we want returned after file is successfully
		       * uploaded. 2. Metadata we want associated with the uploaded video. 3. Video file itself.
		       */
		      YouTube.Videos.Insert videoInsert = youtube.videos()
		          .insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);

		      // Set the upload type and add event listener.
		      MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

		      /*
		       * Sets whether direct media upload is enabled or disabled. True = whole media content is
		       * uploaded in a single request. False (default) = resumable media upload protocol to upload
		       * in data chunks.
		       */
		      uploader.setDirectUploadEnabled(false);

		      MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
		        public void progressChanged(MediaHttpUploader uploader) throws IOException {
		          switch (uploader.getUploadState()) {
		            case INITIATION_STARTED:
		              System.out.println("Initiation Started");
		              break;
		            case INITIATION_COMPLETE:
		              System.out.println("Initiation Completed");
		              break;
		            case MEDIA_IN_PROGRESS:
		              System.out.println("Upload in progress");
		              System.out.println("Upload percentage: " + uploader.getProgress());
		              
		              
		              break;
		            case MEDIA_COMPLETE:
		              System.out.println("Upload Completed!");
		              break;
		            case NOT_STARTED:
		              System.out.println("Upload Not Started!");
		              break;
		          }
		        }
		      };
		      uploader.setProgressListener(progressListener);

		      // Execute upload.
		      Video returnedVideo = videoInsert.execute();

		      // Print out returned results.
		      System.out.println("\n================== Returned Video ==================\n");
		      System.out.println("  - Id: " + returnedVideo.getId());
		      System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
		      System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
		      System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
		      System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());
		      
		      url= "https://www.youtube.com/watch?v="+returnedVideo.getId();
		      
		      System.out.println(url);		
		      
		      
		      
		      JOptionPane.showMessageDialog(null ,"Video Uploaded Succesfully !\n"
		      		+ "https://www.youtube.com/watch?v="+returnedVideo.getId());
		      
		      youtubeLink.setText(url);
		    } catch (GoogleJsonResponseException f) {
		      System.err.println("GoogleJsonResponseException code: " + f.getDetails().getCode() + " : "
		          + f.getDetails().getMessage());
		      f.printStackTrace();
		    } catch (IOException f) {
		      System.err.println("IOException: " + f.getMessage());
		      f.printStackTrace();
		    } catch (Throwable t) {
		      System.err.println("Throwable: " + t.getMessage());
		      t.printStackTrace();
		    }
		  
		  
		  
		  
		  
		  
		  
		  
		  //**********************************************************************
		  
			}
		});
		btnUpload.setBounds(460, 330, 110, 36);
		contentPane.add(btnUpload);
		
		JLabel lblYoutubeLink = new JLabel("Youtube Link:");
		lblYoutubeLink.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYoutubeLink.setBounds(191, 301, 91, 14);
		contentPane.add(lblYoutubeLink);
		
		youtubeLink = new JTextField();
		youtubeLink.setBounds(292, 299, 278, 20);
		contentPane.add(youtubeLink);
		youtubeLink.setColumns(10);
		
		btnCopyLink = new JButton("Copy Link");
		btnCopyLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(url);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "You Youtube URL has been Copied !");
				
				new GUIcontentMovies().setVisible(true);
				
			}
		});
		btnCopyLink.setBounds(315, 330, 102, 36);
		contentPane.add(btnCopyLink);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Marwen\\Desktop\\FMS JEE\\youtube_play_button_background__3000_x_1700__by_dannegoma-da10ku5.png"));
		lblNewLabel_2.setBounds(0, 0, 595, 388);
		contentPane.add(lblNewLabel_2);
		
				
		
		
	}
}
