package timer;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;

public class TimerController implements Initializable{
	@FXML ProgressIndicator timeIndicator;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeIndicator.setProgress(0.5);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(()->timeIndicator.setProgress(timeIndicator.getProgress()-0.01));
			}
		};
		timer.schedule(task, 0, 100);
	}
}
