package assignment1;

import java.io.File;
import javax.swing.JMenuItem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MyJavaFXBrowser extends Application {
	TextField tAddress = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		
	    WebPage currentPage = new WebPage();
		WebView webView = currentPage.getWebView();
		WebEngine webEngine = currentPage.createWebEngine(primaryStage);
		webEngine.load(Menus.getDefaultWeb());

		Label label1 = new Label("Enter Address");
		tAddress.setMaxWidth(Double.MAX_VALUE);
		tAddress.setPromptText("Address Here");
		tAddress.setMinWidth(500.0);
		Button bGo = new Button("Go");
		 
		HBox topPane = new HBox(20);
		
		topPane.getChildren().addAll(label1,tAddress,bGo);
		
		settext(tAddress);
		
		Menus m = new Menus();
		MenuBar menuBar = m.getMenuBar(webEngine,webView,topPane);
		
		VBox vbox = new VBox();
		vbox.getChildren().add(menuBar);
		vbox.getChildren().add(topPane);
		
		BorderPane root = new BorderPane();
		root.setCenter(webView);
		root.setTop(vbox);
	
		bGo.setOnAction(new EventHandler<ActionEvent>() {
			  public void handle(ActionEvent event) {
			    webEngine.load(tAddress.getText());
			    
			  }
			});
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();	

	}
	
	public void stop() {
		
	}
	
	public TextField getText() {
		return tAddress;
	}
	
	public void settext(TextField t) {
		this.tAddress = t;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
