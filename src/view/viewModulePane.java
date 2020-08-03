package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class viewModulePane extends VBox {
	private TextArea info;
	private Button print;
	
	public viewModulePane() {
		this.setStyle("-fx-background-color: #FFFFFF;");
		this.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		info = new TextArea();
		info.setEditable(false);
		info.setMinSize(540, 360);
		info.setPrefSize(720, 1080);
		info.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		print = new Button("Print to file");
		print.setAlignment(Pos.CENTER);
		print.setPrefWidth(200);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10,10,10,10));
		this.getChildren().add(info);
		this.getChildren().add(print);
		}
	
	public String getInfoText() {
		return info.getText();
	}
	public void setInfoText(String s) {
		info.setText(s);
	}
	
	public void addPrintEventHandler(EventHandler<ActionEvent> handler) {
		print.setOnAction(handler);			
	}
}
