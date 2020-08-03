package view;
	import java.time.LocalDate;

import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.Border;
	import javafx.scene.layout.BorderStroke;
	import javafx.scene.layout.BorderStrokeStyle;
	import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
	import javafx.scene.paint.Color;
import model.Course;
import model.Name;

public class profilePane extends VBox  {
		private TextField pNumber, forename, surname, emailAddress;
		private ComboBox<Course> course;
		private Label lbl1 = new Label("Course: ");
		private Label lbl2 = new Label("PNumber: ");
		private Label lbl3 = new Label("First Name: ");
		private Label lbl4 = new Label("Surname: ");
		private Label lbl5 = new Label("Email Address: ");
		private Label lbl6 = new Label("Date: ");
		private DatePicker date;
		private Button submit;
		private ObservableList<Course> choices = FXCollections.observableArrayList ();		
		
		public profilePane() {
			//Style
			this.setStyle("-fx-background-color: #FFFFFF;");
			this.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
			this.setAlignment(Pos.CENTER);
			
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

			
			//Creating ComboBox

			course = new ComboBox<Course>(choices);

			//Creating TextFields
			
			pNumber = new TextField();
			pNumber.setEditable(true);
			pNumber.setPromptText("Enter P Number Here");
			pNumber.setMinWidth(Region.USE_PREF_SIZE);
			pNumber.setMaxWidth(Region.USE_PREF_SIZE);
			
			forename = new TextField();
			forename.setEditable(true);
			forename.setPromptText("Enter First Name Here");
			forename.setMinWidth(Region.USE_PREF_SIZE);
			forename.setMaxWidth(Region.USE_PREF_SIZE);
			
			surname = new TextField();
			surname.setEditable(true);
			surname.setPromptText("Enter Last Name Here");
			surname.setMinWidth(Region.USE_PREF_SIZE);
			surname.setMaxWidth(Region.USE_PREF_SIZE);
			
			emailAddress = new TextField();
			emailAddress.setEditable(true);
			emailAddress.setPromptText("Enter Email Address Here");
			emailAddress.setMinWidth(Region.USE_PREF_SIZE);
			emailAddress.setMaxWidth(Region.USE_PREF_SIZE);
			
			//Creating DatePicker
			
			date = new DatePicker();
			date.setMinWidth(Region.USE_PREF_SIZE);
			date.setMaxWidth(Region.USE_PREF_SIZE);
			
			//Creating Button
			
			submit = new Button("Submit");
			submit.setMinWidth(Region.USE_PREF_SIZE);
			submit.setMaxWidth(Region.USE_PREF_SIZE);
			
			//Creating Gridpane
			
			GridPane grid = new GridPane();
			grid.setVgap(4);
			grid.setPadding(new Insets(5, 5, 5, 5));
			grid.setAlignment(Pos.CENTER);

			//Adding elements to GridPane
			grid.add(lbl1, 0, 0);
			grid.setPrefWidth(Integer.MAX_VALUE);
			grid.add(lbl2, 0, 1);
			grid.add(lbl3, 0, 2);
			grid.add(lbl4, 0, 3);
			grid.add(lbl5, 0, 4);
			grid.add(lbl6, 0, 5);
			grid.add(course, 1, 0);
			grid.add(pNumber, 1, 1);
			grid.add(forename, 1, 2);
			grid.add(surname, 1, 3);
			grid.add(emailAddress, 1, 4);
			grid.add(date, 1, 5);
			grid.add(submit, 1, 6);
			
			HBox outline = new HBox();
			outline.setStyle("-fx-background-color: #FFFFFF;");
			outline.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
			outline.setAlignment(Pos.CENTER);
			outline.setPadding(new Insets(10));
			outline.setMaxWidth(400);
			outline.getChildren().add(grid);
			

			this.getChildren().add(outline);
			
		}
		
		public Course getSelectedCourse() {
			return course.getSelectionModel().getSelectedItem();
		}
		public String getPNumber() {
			return pNumber.getText();
		}
		public Name getName() {
			return new Name(forename.getText(), surname.getText());
		}
		public String getForename() {
			return forename.getText();
		}
		public String getSurname() {
			return surname.getText();
		}
		public String getEmailAddress() {
			return emailAddress.getText();
		}
		public LocalDate getDate() {
			return date.getValue();
		}
		public void populateComboBoxWithCourses(Course[] courses) {
			choices.addAll(courses);
		}
//
//		public void addCourseEventHandler(EventHandler<ActionEvent> handler) {
//			course.setOnAction(handler);
//		}
////		public void addPNumberEventHandler(EventHandler<ActionEvent> handler) {
////			pNumber.setOnAction(handler);			
////		}
////		public void addForenameEventHandler(EventHandler<ActionEvent> handler) {
////			forename.setOnAction(handler);			
////		}
////		public void addSurnameEventHandler(EventHandler<ActionEvent> handler) {
////			surname.setOnAction(handler);			
////		}
////		public void addEmailAddressEventHandler(EventHandler<ActionEvent> handler) {
////			emailAddress.setOnAction(handler);			
////		}
////		public void addDateEventHandler(EventHandler<ActionEvent> handler) {
////			date.setOnAction(handler);			
////		}
		public void addSubmitEventHandler(EventHandler<ActionEvent> handler) {
			submit.setOnAction(handler);			
		}
		public void resetPane() {
			pNumber.clear();
			forename.clear();
			surname.clear();
			emailAddress.clear();
			course.getEditor().clear();
			date.getEditor().clear();
		}
	}

