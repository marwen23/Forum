package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.Category;
import Entities.Content;
import Entities.Genre;
import businessDelegate.ContentServicesDelegate;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GUIcontentMovies extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JSpinner spinner = new JSpinner();
	JSpinner spinner_1 = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIcontentMovies frame = new GUIcontentMovies();
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
	public GUIcontentMovies() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Upload Trailer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UploadVideoGUI().setVisible(true);
				
			 
			}
		});
		btnNewButton.setBounds(237, 252, 115, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 35, 612, 160);
		contentPane.add(scrollPane);
		
		table = new JTable(new TblContentModelMovies());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex=table.getSelectedRow();
				
				
				//String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				//List q=ContentServicesDelegate.findContentByTitle(title);
				//Content c=(Content) q.get(0);
				
				
				textField.setText(table.getModel().getValueAt(selectedRowIndex, 0).toString());
				textField_1.setText(table.getModel().getValueAt(selectedRowIndex, 3).toString());
				textField_2.setText(table.getModel().getValueAt(selectedRowIndex, 2).toString());
				
				String genre = table.getModel().getValueAt(selectedRowIndex, 1).toString();
				comboBox.setSelectedIndex(Genre.valueOf(genre).ordinal());
				
				String category=table.getModel().getValueAt(selectedRowIndex, 6).toString();
				comboBox_1.setSelectedIndex(Category.valueOf(category).ordinal());
			
				spinner.setValue(Integer.parseInt(table.getModel().getValueAt(selectedRowIndex, 4).toString()));
				
				Double sp= (Double) table.getModel().getValueAt(selectedRowIndex, 5);
				spinner_1.setValue(sp);
		
			}
		});
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		JLabel label = new JLabel("Title");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(39, 206, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ADDcontentJframe().setVisible(true);
			}
		});
		textField.setColumns(10);
		textField.setBounds(85, 206, 86, 20);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Genre");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(190, 208, 46, 14);
		contentPane.add(label_1);
		comboBox.setModel(new DefaultComboBoxModel(Genre.values()));
		
		
		comboBox.setBounds(237, 206, 86, 20);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("Trailer");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(39, 255, 46, 14);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 253, 154, 20);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("Description");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(39, 333, 76, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Rating");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(406, 255, 46, 14);
		contentPane.add(label_4);
		comboBox_1.setModel(new DefaultComboBoxModel(Category.values()));
		
		
		comboBox_1.setBounds(512, 281, 78, 20);
		contentPane.add(comboBox_1);
		
		JLabel label_5 = new JLabel("Category");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(406, 283, 62, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Release Year");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(406, 314, 96, 14);
		contentPane.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 330, 235, 52);
		contentPane.add(textField_2);
		spinner.setModel(new SpinnerNumberModel(2017, null, 2017, 1));
		
		
		spinner.setBounds(512, 311, 69, 20);
		contentPane.add(spinner);
		spinner_1.setModel(new SpinnerNumberModel(0.0, 0.0, 10.0, 1.0));
		
		
		spinner_1.setBounds(512, 253, 59, 20);
		contentPane.add(spinner_1);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ADDcontentJframe().setVisible(true);
				
			}
		});
		button.setBounds(619, 212, 110, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				List q=ContentServicesDelegate.findContentByTitle(title);
				Content c=(Content) q.get(0);
				
				int a=JOptionPane.showConfirmDialog(null, "are you sure to want to delete this Content","Delete",JOptionPane.YES_NO_OPTION);
				ContentServicesDelegate.deleteContent(c);
				
				 dispose();
				  new GUIcontentMovies().setVisible(true);
				  JOptionPane.showMessageDialog(null ,"Deleted successfully");
			}
		});
		button_1.setBounds(619, 274, 110, 42);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				List q=ContentServicesDelegate.findContentByTitle(title);
				Content c=(Content) q.get(0);
				
				int idc=c.getId();
				
				
				
				String tit = textField.getText();
				Genre genre = (Genre) comboBox.getSelectedItem();
				//content.setGenre(genre);
				String description=textField_2.getText();
				String trailer= textField_1.getText();
				int   yearReleased=(int) spinner.getValue();
			
				Double rating =2.0;
				//  Double rating= (Double) spinner.getValue();
			  Category category = (Category) comboBox_1.getSelectedItem();
			  
			  

				
			  Content content = new Content(idc,tit,genre,description,trailer,yearReleased,rating,category);
			  ContentServicesDelegate.updateContent(content);
			  
			  dispose();
			  new GUIcontentMovies().setVisible(true);
				
			}
		});
		button_2.setBounds(619, 342, 110, 40);
		contentPane.add(button_2);
		
		JLabel lblSortBy = new JLabel("Sort by==>");
		lblSortBy.setBounds(10, 33, 76, 20);
		contentPane.add(lblSortBy);
		
		JLabel lblManageMovies = new JLabel("MANAGE MOVIES");
		lblManageMovies.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblManageMovies.setBounds(312, 11, 176, 20);
		contentPane.add(lblManageMovies);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchVideo().setVisible(true);
			}
		});
		btnSearch.setBounds(82, 280, 154, 23);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marwen\\Desktop\\FMS JEE\\FMS\\all conentent.jpg"));
		lblNewLabel.setBounds(0, 0, 755, 388);
		contentPane.add(lblNewLabel);
	
	
	
	
	}
}
