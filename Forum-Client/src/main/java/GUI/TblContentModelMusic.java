package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entities.Category;
import Entities.Content;
import businessDelegate.ContentServicesDelegate;

class TblContentModelMusic extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String[] COLUMNS = {"title", "genre", "description","trailer","yearReleased","rating",
			"category" };
    
    private static final int COL_ID = 0;
    private static final int COL_TITLE = 1;
Category category = Category.MUSIC;
     List<Content> contents=ContentServicesDelegate.findContentByCategory(category);  //list that is injected via constructor or setter method

    public int getRowCount() {
        return contents.size();
    }

    public int getColumnCount() {
        return COLUMNS.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Content content = contents.get(rowIndex);
        switch (columnIndex) {
            
            case 0:
                return content.getTitle();
            case 1:
                return content.getGenre();
            case 2:
                return content.getDescription();
            case 3:
                return content.getTrailer();
            case 4:
                return content.getYearReleased();
            case 5:
                return content.getRating();
            case 6:
                return content.getCategory();
                
        }
        return null;
    }
        
    enum ContentTableColumn {
        ID, TITLE, PUBLISHER, GENRE, RELEASE_DATE;
    }

    public String getColumnName(int column) {
        return COLUMNS[column];
    }}
