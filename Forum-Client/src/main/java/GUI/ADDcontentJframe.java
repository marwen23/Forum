package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import com.toedter.calendar.JYearChooser;

import Entities.Category;
import Entities.Genre;
import businessDelegate.ContentServicesDelegate;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;

public class ADDcontentJframe extends JFrame {

	private JPanel contentPane;
	private JTextField titlelb;
	private JTextField trailerlb;
	JComboBox comboBoxGenre = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDcontentJframe frame = new ADDcontentJframe();
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
	public ADDcontentJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Title:");
		label.setBounds(10, 11, 30, 22);
		contentPane.add(label);
		
		titlelb = new JTextField();
		titlelb.setBounds(104, 12, 86, 20);
		titlelb.setColumns(10);
		contentPane.add(titlelb);
		
		JLabel label_1 = new JLabel("Genre");
		label_1.setBounds(10, 44, 36, 22);
		contentPane.add(label_1);
		
		JComboBox comboBoxCat = new JComboBox();
		comboBoxCat.setModel(new DefaultComboBoxModel(Category.values()));
		comboBoxCat.setBounds(311, 11, 86, 22);
		contentPane.add(comboBoxCat);
		
		JLabel label_2 = new JLabel("Description");
		label_2.setBounds(10, 210, 76, 14);
		contentPane.add(label_2);
		
		JTextArea descriptionlb = new JTextArea();
		descriptionlb.setBounds(104, 195, 165, 56);
		contentPane.add(descriptionlb);
		
		JLabel label_3 = new JLabel("Trailer");
		label_3.setBounds(10, 94, 46, 14);
		contentPane.add(label_3);
		
		trailerlb = new JTextField();
		trailerlb.setBounds(101, 91, 215, 20);
		trailerlb.setColumns(10);
		contentPane.add(trailerlb);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setBounds(0, 0, 59, 20);
		yearChooser.setBounds(104, 133, 59, 20);
		contentPane.add(yearChooser);
		yearChooser.setLayout(null);
		
		JLabel label_4 = new JLabel("Release Year");
		label_4.setBounds(10, 139, 84, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Rating");
		label_5.setBounds(10, 167, 64, 14);
		contentPane.add(label_5);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spinner.setBounds(104, 164, 56, 20);
		contentPane.add(spinner);
		
		JLabel label_6 = new JLabel("Category");
		label_6.setBounds(255, 15, 46, 14);
		contentPane.add(label_6);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String title = titlelb.getText();
				Genre genre = (Genre) comboBoxGenre.getSelectedItem();
				//content.setGenre(genre);
				String description=descriptionlb.getText();
				String trailer= trailerlb.getText();
				int   yearReleased=yearChooser.getValue();
			   Double rating= (Double) spinner.getValue();
			  Category category = (Category) comboBoxCat.getSelectedItem();
			  ContentServicesDelegate.addContent(title,genre,description,trailer,yearReleased,rating,category); 
			  dispose();
			 
			  
			  new GUIcontent().setVisible(true);
			  
			  
			 
			  
			   
			    
				//content.setCategory(category);
				
				
				
			}
		});
		button.setBounds(308, 188, 89, 59);
		contentPane.add(button);
		comboBoxGenre.setModel(new DefaultComboBoxModel(Genre.values()));
		
		
		comboBoxGenre.setBounds(104, 45, 86, 20);
		contentPane.add(comboBoxGenre);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marwen\\Desktop\\FMS JEE\\FMS\\add.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}

}
