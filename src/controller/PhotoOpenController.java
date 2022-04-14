package controller;

import java.io.Serializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

public class PhotoOpenController implements Serializable {

	@FXML
	private Label nameLabel;
	@FXML
	private Label captionLabel;
	@FXML
	private Label dateLabel;
	@FXML
	private Label tagsListLabel;
	@FXML
	private ImageView imageView;
	@FXML
	private Button forwardButton;
	@FXML
	private Button backwardButton;

	Album album = null;

	private int currentPhotoIndex = 0;

	public void start(Stage primaryStage, Album album, int currentPhotoIndex) {

		this.album = album;
		this.currentPhotoIndex = currentPhotoIndex;
		insertPhoto();

		primaryStage.setOnCloseRequest(event -> {
		});
	}

	public void insertPhoto() {

		nameLabel.setText(album.getPhotos().get(currentPhotoIndex).getPhotoName());
		captionLabel.setText(album.getPhotos().get(currentPhotoIndex).getCaption());
		dateLabel.setText(album.getPhotos().get(currentPhotoIndex).getDate().toString());
		imageView.setImage(new Image(album.getPhotos().get(currentPhotoIndex).getLocation()));

		if (album.getPhotos().get(currentPhotoIndex).getTags().size() == 0) {

			tagsListLabel.setText("None");
		} else {

			String tags = "";

			for (int i = 0; i < album.getPhotos().get(currentPhotoIndex).getTags().size(); i++) {

				tags = tags.concat(album.getPhotos().get(currentPhotoIndex).getTags().get(i).getTag() + "\n");
			}

			tagsListLabel.setText(tags);
		}
	}

	public void nextPicture(ActionEvent e) {

		if (currentPhotoIndex + 1 != album.getPhotos().size()) {

			currentPhotoIndex++;
			insertPhoto();
		}
	}

	public void prevPicture(ActionEvent e) {

		if (currentPhotoIndex - 1 != -1) {

			currentPhotoIndex--;
			insertPhoto();
		}
	}

}
