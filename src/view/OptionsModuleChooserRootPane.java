package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

//You may change this class to extend another type if you wish
public class OptionsModuleChooserRootPane extends VBox {
	private profilePane profile; 
	private modulePane modules;
	private viewModulePane overview;
	private TabPane application;
	private menuBar menu;
	public OptionsModuleChooserRootPane() {
		profile = new profilePane();
		modules = new modulePane();
		overview = new viewModulePane();
		application = new TabPane();
		menu = new menuBar();
		Tab[] tabs = new Tab[3];
		tabs[0] = new Tab("Create Your Profile", profile);
		tabs[1] = new Tab("Pick Your Modules");		
		tabs[2] = new Tab("See Your Modules");
		tabs[0].setContent(profile);
		tabs[1].setContent(modules);
		tabs[2].setContent(overview);
		application.getTabs().addAll(tabs);
		this.getChildren().add(menu);
		this.getChildren().add(application);


	}
	public profilePane getProfilePane() {
		return profile;
	}
	public modulePane getModulePane() {
		return modules;
	}
	public viewModulePane getViewModulePane() {
		return overview;
	}
	public TabPane getTabPane() {
		return application;
	}
	public menuBar getMenu() {
		return menu;
	}
}
