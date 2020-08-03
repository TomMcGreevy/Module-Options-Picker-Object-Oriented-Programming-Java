package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

public class menuBar extends MenuBar {
		private MenuItem loadItem, saveItem, exitItem, aboutItem;

		public menuBar() {      

			Menu menu;
			Menu menu2;

			menu = new Menu("_File");

			loadItem = new MenuItem("_Load Student Profile");
			loadItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
			menu.getItems().add(loadItem);

			saveItem = new MenuItem("_Save Student Profile");
			saveItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
			menu.getItems().add(saveItem);

			menu.getItems().add( new SeparatorMenuItem());

			exitItem = new MenuItem("E_xit");
			exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
			menu.getItems().add(exitItem);
			
			menu2 = new Menu("_Help");

			aboutItem = new MenuItem("_About");
			aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
			menu2.getItems().add(aboutItem);

			
			this.getMenus().add(menu);
			this.getMenus().add(menu2);

		}
		
		public void addLoadHandler(EventHandler<ActionEvent> handler) {
			loadItem.setOnAction(handler);
		}
	    
	    public void addSaveHandler(EventHandler<ActionEvent> handler) {
	  		saveItem.setOnAction(handler);
	  	}
	    
	    public void addExitHandler(EventHandler<ActionEvent> handler) {
	  		exitItem.setOnAction(handler);
	    }
	    
	    public void addHelpHandler(EventHandler<ActionEvent> handler) {
	  		aboutItem.setOnAction(handler);
	    }
}
