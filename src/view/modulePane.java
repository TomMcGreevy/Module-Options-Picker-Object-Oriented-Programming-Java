package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Course;
import model.Module;

public class modulePane extends VBox {
	private Label lbl1 = new Label("Unselected Term 1 Modules: ");
	private ListView<Module> unSelectedTerm1, selectedTerm1, unSelectedTerm2, selectedTerm2;
	private Label lbl2 = new Label("Selected Term 1 Modules: ");
	private Label lbl3 = new Label("Unselected Term 2 Modules: ");
	private Label lbl4 = new Label("Selected Term 2 Modules: ");
	private Label lbl5 = new Label("Year Long Modules: ");
	private Label lbl6 = new Label("Term 1 Credits: ");
	private Label lbl7 = new Label("Term 2 Credits: ");
	private ListView<Module> yearLong;
	private Button add1, remove1, add2, remove2, reset, submit;
	private ObservableList<Module> allModules = FXCollections.observableArrayList ();	
	private ObservableList<Module> unsTerm1 = FXCollections.observableArrayList ();	
	private ObservableList<Module> selTerm1 = FXCollections.observableArrayList ();		
	private ObservableList<Module> unsTerm2 = FXCollections.observableArrayList ();	
	private ObservableList<Module> selTerm2 = FXCollections.observableArrayList ();
	private ObservableList<Module> project = FXCollections.observableArrayList ();	
	
	

	public modulePane() {
		//Style
		this.setStyle("-fx-background-color: #FFFFFF;");
		this.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		lbl1.setStyle("-fx-font-weight: bold;");
		lbl1.setMinWidth(Region.USE_PREF_SIZE);

		
		lbl2.setStyle("-fx-font-weight: bold;");
		lbl2.setMinWidth(Region.USE_PREF_SIZE);

		
		lbl3.setStyle("-fx-font-weight: bold;");
		lbl3.setMinWidth(Region.USE_PREF_SIZE);

		
		lbl4.setStyle("-fx-font-weight: bold;");
		lbl4.setMinWidth(Region.USE_PREF_SIZE);

		
		lbl5.setStyle("-fx-font-weight: bold;");
		lbl5.setMinWidth(Region.USE_PREF_SIZE);

		lbl6.setStyle("-fx-font-weight: bold;");
		lbl6.setMinWidth(Region.USE_PREF_SIZE);
		lbl6.setAlignment(Pos.CENTER);
		
		lbl7.setStyle("-fx-font-weight: bold;");
		lbl7.setMinWidth(Region.USE_PREF_SIZE);
		lbl7.setAlignment(Pos.CENTER);
		
		//Creating ListViews
		unSelectedTerm1 = new ListView<Module>(unsTerm1);
		unSelectedTerm1.setMinSize(162, 108);
		unSelectedTerm1.setPrefSize(1080, 360);
		unSelectedTerm1.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

		
		selectedTerm1 = new ListView<Module>(selTerm1);
		selectedTerm1.setMinSize(162, 108);
		selectedTerm1.setPrefSize(1080, 360);
		selectedTerm1.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		unSelectedTerm2 = new ListView<Module>(unsTerm2);
		unSelectedTerm2.setMinSize(162, 108);
		unSelectedTerm2.setPrefSize(1080, 360);
		unSelectedTerm2.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		selectedTerm2 = new ListView<Module>(selTerm2);
		selectedTerm2.setMinSize(162, 108);
		selectedTerm2.setPrefSize(1080, 360);
		selectedTerm2.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		yearLong = new ListView<Module>(project);
		yearLong.setPrefSize(2200, 40);
		yearLong.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));


		
		//Creating Button
		add1 = new Button("Add");
		add1.setMinWidth(Region.USE_PREF_SIZE);
		add1.setMaxWidth(Region.USE_PREF_SIZE);

		
		remove1 = new Button("Remove");
		remove1.setMinWidth(Region.USE_PREF_SIZE);
		remove1.setMaxWidth(Region.USE_PREF_SIZE);

		
		add2 = new Button("Add");
		add2.setMinWidth(Region.USE_PREF_SIZE);
		add2.setMaxWidth(Region.USE_PREF_SIZE);

		
		remove2 = new Button("Remove");
		remove2.setMinWidth(Region.USE_PREF_SIZE);
		remove2.setMaxWidth(Region.USE_PREF_SIZE);

		
		submit = new Button("Submit");
		submit.setMinWidth(Region.USE_PREF_SIZE);

		reset = new Button("Reset");
		reset.setMinWidth(Region.USE_PREF_SIZE);

		
		//Create Menubars
		HBox menubar = new HBox();
		menubar.setSpacing(10);
		menubar.getChildren().add(add1);
		menubar.getChildren().add(remove1);
		menubar.setAlignment(Pos.CENTER);
		
		HBox menubar2 = new HBox();
		menubar2.setSpacing(10);
		menubar2.getChildren().add(add2);
		menubar2.getChildren().add(remove2);
		menubar2.setAlignment(Pos.CENTER);
		
		HBox yearBar = new HBox();
		yearBar.setSpacing(10);
		yearBar.getChildren().add(lbl5);
		yearBar.getChildren().add(yearLong);
		yearBar.setAlignment(Pos.CENTER);
		yearBar.setMinSize(324, 40);
		yearBar.setPrefSize(324 , 40);
		
		HBox footer = new HBox();
		footer.setSpacing(10);
		footer.getChildren().add(submit);
		footer.getChildren().add(reset);
		footer.setAlignment(Pos.CENTER);
		footer.setMinSize(324, 40);
		footer.setPrefSize(324, 40);
		
		//Create GridPane
		

		
		GridPane grid2 =  new GridPane();
		grid2.setVgap(4);
		grid2.setPadding(new Insets(10,10, 10, 10));
		grid2.setHgap(10);
		grid2.setAlignment(Pos.CENTER);
		
		ColumnConstraints column1 = new ColumnConstraints();
		RowConstraints row1 = new RowConstraints();
		column1.setPercentWidth(50);
		row1.setPercentHeight(10);
		grid2.getRowConstraints().add(row1);
		grid2.getColumnConstraints().add(column1);
		
		
		grid2.add(yearBar, 0, 0, 2, 1);
		
		grid2.add(lbl1, 0, 1);
		grid2.add(unSelectedTerm1, 0, 2);
		grid2.add(lbl2, 1, 1);
		grid2.add(selectedTerm1, 1, 2);
		

		grid2.add(menubar, 0, 3);
		grid2.add(lbl6, 1, 3);
		
		grid2.add(lbl3, 0, 4);
		grid2.add(unSelectedTerm2, 0, 5);
		grid2.add(lbl4, 1, 4);
		grid2.add(selectedTerm2,1, 5);
		
		grid2.add(menubar2, 0, 6);
		grid2.add(lbl7, 1, 6);
		
		grid2.add(footer, 0, 7, 2, 1);

		this.getChildren().add(grid2);
	}
	
	//Get Methods for Lists
	public ObservableList<Module> getSelectedListTerm1() {
		return selTerm1;
	}
	public ObservableList<Module> getSelectedListTerm2() {
		return selTerm2;
	}
	public ObservableList<Module> getUnselectedListTerm1() {
		return unsTerm1;
	}
	public ObservableList<Module> getUnselectedListTerm2() {
		return unsTerm2;
	}
	
	
	//Get Methods for Combo Boxes
	public Module getSelectedModuleTerm1() {
		return unSelectedTerm1.getSelectionModel().getSelectedItem();
	}
	
	public Module getSelectedModuleTerm2() {
		return unSelectedTerm2.getSelectionModel().getSelectedItem();
	}
	
	public Module getRemoveModuleTerm1() {
		return selectedTerm1.getSelectionModel().getSelectedItem();
	}
	
	public Module getRemoveModuleTerm2() {
		return selectedTerm2.getSelectionModel().getSelectedItem();
	}
	
	
	//Populating Comboboxes
	public void populateComboBoxesWithModules(Course course) {
		allModules.addAll(course.getAllModulesOnCourse());

		for (Module m : allModules) {
			if(m.getRunPlan().toString() == "TERM_1" && m.isMandatory() == false) {
				unsTerm1.add(m);
			}

			if(m.getRunPlan().toString() == "TERM_1" && m.isMandatory() == true) {
				selTerm1.add(m);
			}

			if(m.getRunPlan().toString() == "TERM_2" && m.isMandatory() == false) {
				unsTerm2.add(m);
			}

			if(m.getRunPlan().toString() == "TERM_2" && m.isMandatory() == true) {
				selTerm2.add(m);
			}

			if(m.getRunPlan().toString() == "YEAR_LONG") {
				project.add(m);
			}
			updateCreditLabels();
		}
	}

	
	public void clearComboBoxes() {
		allModules.clear();
		unsTerm1.clear();
		selTerm1.clear();
		unsTerm2.clear();
		selTerm2.clear();
		project.clear();
		updateCreditLabels();
	}
	
	
	//Add EventHandlers
	public void addSelectorEventHandler1(EventHandler<ActionEvent> handler) {
		add1.setOnAction(handler);			
	}
	
	public void addSelectorEventHandler2(EventHandler<ActionEvent> handler) {
		add2.setOnAction(handler);			
	}
	
	public void addRemoverEventHandler1(EventHandler<ActionEvent> handler) {
		remove1.setOnAction(handler);			
	}
	
	public void addRemoverEventHandler2(EventHandler<ActionEvent> handler) {
		remove2.setOnAction(handler);			
	}
	
	public void addSubmitEventHandler(EventHandler<ActionEvent> handler) {
		submit.setOnAction(handler);			
	}
	
	public void addResetEventHandler(EventHandler<ActionEvent> handler) {
		reset.setOnAction(handler);			
	}
	
	public void updateCreditLabels() {
		int count1 =  15;
		int count2 = 15;
		for (Module m : selTerm1) {
			count1 = count1 + m.getCredits();
		}
		for (Module m : selTerm2) {
			count2 = count2 + m.getCredits();
		}
		lbl6.setText("Term 1 Credits: " + count1);
		lbl7.setText("Term 2 Credits: " + count2);
	}
	}
