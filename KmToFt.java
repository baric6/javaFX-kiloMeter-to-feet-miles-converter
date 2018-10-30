package kiloToFeet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KmToFt extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//makes layout a grid pattern
		GridPane pane = new GridPane();
		
		//sets padding around the grid
		pane.setPadding(new Insets(10,10,10,10));
		
		//cells of grid vertical spacing 
		pane.setVgap(3);
		
		//cells of grid horizontal spacing
		pane.setHgap(1);
		//////////////////////////////////end grid 
		
		//making a label object
		Label enterNumber = new Label("please enter a number in kiloMeters");
		//setting label in grid
		GridPane.setConstraints(enterNumber, 1, 5);
		
		//making a text field object
		TextField number = new TextField();
		//setting the text field in grid
		GridPane.setConstraints(number, 1, 6);
		
		//making a button object 
		Button btn = new Button("submit");
		//setting the button in the grid
		GridPane.setConstraints(btn, 2, 6);
		
		//results below label
		Label rs = new Label("Conversion:");
		GridPane.setConstraints(rs ,1 ,9);
		
		//display label
		Label l = new Label();
		GridPane.setConstraints(l , 1, 10);
		
		////////////////////////////////////end children for stage 
		
		//when the button is clicked then this happens
		btn.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				String nn = number.getText();
				double num = Double.parseDouble(nn);
				double resultFeet =  num * 3280.8;
				double r = num / 2;
				double r1 = r / 4;
				double resultMiles = r + r1;
				String value = String.format("%.4f Feet%n%.4f miles", resultFeet, resultMiles);
				l.setText(value);
				
			}
		});//end button
		
		//when hit the enter key this happens
		number.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent event) 
			{
				if(event.getCode().equals(KeyCode.ENTER))
				{
					String nn = number.getText();
					double num = Double.parseDouble(nn);
					double resultFeet =  num * 3280.8;
					double r = num / 2;
					double r1 = r / 4;
					double resultMiles = r + r1;
					String value = String.format("%.4f Feet%n%.4f miles", resultFeet, resultMiles);
					l.setText(value);
				}
				
			}
			
		});//end key entered
		
		//setting the children on the stage
		pane.getChildren().addAll(enterNumber, number, btn, rs ,l);
		
		//making the stage 
		Scene scene = new Scene(pane, 315, 150);
		primaryStage.setTitle("Kilo to Feet");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
