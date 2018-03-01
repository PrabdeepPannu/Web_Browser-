package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Menus extends MyJavaFXBrowser{
	
	private static MenuBar menuBar = new MenuBar();
	
	private static Menu mnuFile = new Menu("File");
	private static Menu mnuSettings = new Menu("Settings");
	private static Menu mnuBookmarks = new Menu("Bookmarks");
	private static Menu mnuHelp = new Menu("Help");
	
	private static MenuItem mnuItmRefresh;
	private static MenuItem mnuItmExit;
	private static MenuItem mnuItmToggleAddressBar;
	private static MenuItem mnuItmChangeStartup;
	private static MenuItem mnuItmAddBookmark;
	private static MenuItem mnuItmListOfBookmark;
	private static MenuItem mnuList;
	private static ToggleGroup group = new ToggleGroup();
	private MenuItem mnuItmAbout = new MenuItem("About");
	private static File File1 = new File("default.web");
	private static File File2 = new File("bookmarks.web");
	static ArrayList<String> al=new ArrayList<String>();

	FileUtils file = new FileUtils();
	public MenuBar getMenuBar(WebEngine e, WebView v,HBox hbox) {
		init();
		
		menuBar.getMenus().addAll(mnuFile, mnuSettings, mnuBookmarks, mnuHelp);
		mnuFile.getItems().addAll(mnuItmRefresh,mnuItmExit);
		mnuSettings.getItems().addAll(mnuItmToggleAddressBar,mnuItmChangeStartup);
		mnuBookmarks.getItems().addAll(mnuItmAddBookmark);
		mnuHelp.getItems().addAll(mnuItmAbout);
		for (int i=0;i<FileUtils.getFileContentsASArrayList(File2).size();i++) {
			//mnuHelp.getItems().addAll(mnuItmAbout,getList(e,i));
			mnuBookmarks.getItems().add(mnuList = new MenuItem(FileUtils.getFileContentsASArrayList(File2).get(i)));
			mnuList.setOnAction(new EventHandler<ActionEvent>() {
                @Override
				public void handle(ActionEvent arg0) {
					for (int i=0;i<FileUtils.getFileContentsASArrayList(File2).size();i++) {
					e.load(FileUtils.getFileContentsASArrayList(File2).get(i));}
				 
			 }});
				
		};
		
		getMnuItmExit();
		getMnuItmRefresh(e);
		getMnuItmBookmark(v);
		getdefault(v); 
	    getMnuItmAbout();
		getMnuItmToggle(hbox);
		return menuBar;
	}
		
	public void init() {
		 mnuItmRefresh = new MenuItem("Refresh");
		 mnuItmExit = new MenuItem("Exit");
		 mnuItmToggleAddressBar = new MenuItem("Toggle Address Bar");
		 mnuItmChangeStartup = new MenuItem("Change Start-up Page");
		 mnuItmAddBookmark = new MenuItem("Add Bookmark");
		 
	}
	public static MenuItem getMnuItmBookmark(WebView e) {
		
		mnuItmAddBookmark.setOnAction(new EventHandler<ActionEvent>() {
			  public void handle(ActionEvent event) {
				  
			 al.add(e.getEngine().getLocation());
			    try {
					FileUtils.saveFileContents(File2, al);
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			    
			  
			  }
			});
		return mnuItmAddBookmark;
		
	}
	
	public static MenuItem getMnuItmToggle(HBox hbox) {
		 mnuItmToggleAddressBar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
			if(hbox.isVisible()==false) {
				hbox.setVisible(true);
			
			}else
			if(hbox.isVisible()==true) {
				hbox.setVisible(false);
			}
				
				}
			 
		 });
		 return  mnuItmToggleAddressBar;
	 }
	
	public static MenuItem getdefault(WebView wv) {
		 mnuItmChangeStartup.setOnAction(new EventHandler<ActionEvent>() {
			  public void handle(ActionEvent event) {
				  ArrayList<String> d = new ArrayList<String>();
			      d.add(wv.getEngine().getLocation());
			    try {
					FileUtils.saveFileContents(File1, d);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			  
			  }
			});
		return mnuItmChangeStartup;
		
	 }

	  public static String getDefaultWeb(){
		 String read = "";
		 read = FileUtils.getFileContentsASArrayList(File1).get(0);
		return read;
	 }
    
	 public void WriteToFile() {
		 
	 }
	 
	public static MenuItem getMnuItmRefresh(WebEngine e) {
		
		mnuItmRefresh.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					e.reload();
				 
			 }});
		
		return mnuItmRefresh;
     	}
	
     	public static MenuItem getMnuItmExit() {
     		mnuItmExit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Platform.exit();
				 
			 }});
		
		return mnuItmExit;
		
	}
	
	 public MenuItem getMnuItmAbout() {
     		 mnuItmAbout.setOnAction(new EventHandler<ActionEvent>() {

 				@Override
 				public void handle(ActionEvent arg0) {
 					Alert alert = new Alert(AlertType.INFORMATION);
 					alert.setTitle("Information");
 					alert.setHeaderText("");
 					alert.setContentText("Name: Pranav Pranav  StudentId:040885654");

 					alert.showAndWait();
 				 
 			 }});
			return mnuItmAbout;
     		 
     	 }
	public boolean isVisible() {
		return true ;
		
	}
	
	public static MenuItem getList(WebEngine w,int i) {
	
		mnuList.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				w.load(FileUtils.getFileContentsASArrayList(File2).get(i));
			 
		 }});
			
		return mnuList;
		   
	}}

