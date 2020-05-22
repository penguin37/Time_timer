package timer;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("timer.fxml"));
		Scene scene = new Scene(root);
		
		scene.getStylesheets().add(getClass().getResource("timer.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		
		primaryStage.setScene(scene);
		//primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setAlwaysOnTop(true);
		
		//클릭시 투명도 0으로 사라지고 5초 후 다시 보여진다.
		scene.setOnMouseClicked(e->{
			primaryStage.setOpacity(0);
			System.out.println("dd");
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					Platform.runLater(()->{primaryStage.setOpacity(1);});
				}
			};
			timer.schedule(task, 5000);
		});
		
		//마우스 드래그로 위치 이동
		scene.setOnMouseDragged(e->{
			primaryStage.setX(e.getScreenX());
			primaryStage.setY(e.getScreenY());
		});
		
		
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
