/*
 *  Copyright (C) 2016 Ernesto Serrano <info at ernesto.es>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package smm;

import javax.swing.*;
import javafx.application.Platform;
import javafx.beans.value.*;
import javafx.embed.swing.JFXPanel;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.util.Duration;

/**
 * Esta es una clase para probar como cargar videos usando javafx
 * finalmente no se ha finalizado porque no soporta .avi, solo soporta .mp4 y .flv
 * la dejo aqui para un futuro 
 * para instanciarla basta con lanzar:
 *         VideoPlayer player = new VideoPlayer();
        player.play("http://www.urldelvideo.com/video.flv");
 * 
 * 
 * @author Ernesto Serrano
 */
public class VideoPlayer extends JFrame {

  public static final String VID_URL = 
    "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

  private static final int VID_WIDTH     = 320;
  private static final int VID_HEIGHT    = 180;
  private static final int PLAYER_WIDTH  = 320;
  private static final int PLAYER_HEIGHT = 265;

  public void play(final String url) {
    final JFXPanel panel = new JFXPanel();
    Platform.runLater(new Runnable() {
      @Override public void run() {
        initFX(panel, url);
      }
    });
    this.add(panel);
    this.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private void initFX(JFXPanel panel, String url) {
    MediaView mediaView = createMediaView(url);

    final Scene playerScene = new Scene(
      createPlayerLayout(mediaView), 
      PLAYER_WIDTH, 
      PLAYER_HEIGHT
    );

    setMediaEventHandlers(
      mediaView
    );

    panel.setScene(playerScene);
  }

  private MediaView createMediaView(String url) {
    final Media clip = new Media(url);
    final MediaPlayer player = new MediaPlayer(clip);
    final MediaView view = new MediaView(player);
    view.setFitWidth(VID_WIDTH);
    view.setFitHeight(VID_HEIGHT);
    return view;
  }

  private VBox createPlayerLayout(final MediaView view) {
    final Button button = new Button("Play From Start");
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        view.getMediaPlayer().seek(Duration.ZERO);
        view.getMediaPlayer().play();
      }
    });

    final VBox layout = new VBox(8);
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().addAll(
      view,
      button
    );

    layout.setStyle("-fx-background-color: linear-gradient(to bottom, derive(lightseagreen, -20%), lightseagreen);");

    return layout;
  }

  private void setMediaEventHandlers(final MediaView view) {
    final MediaPlayer player = view.getMediaPlayer();

    System.out.println("Initial: " + player.getStatus());
    player.statusProperty().addListener(new ChangeListener<MediaPlayer.Status>() {
      @Override
      public void changed(ObservableValue<? extends MediaPlayer.Status> observable, MediaPlayer.Status oldStatus, MediaPlayer.Status curStatus) {
        System.out.println("Current: " + curStatus);
      }
    });

    if (player.getError() != null) {
      System.out.println("Initial Error: " + player.getError());
    }

    player.setOnError(new Runnable() {
      @Override public void run() {
        System.out.println("Current Error: " + player.getError());
      }
    });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override public void run() {
        VideoPlayer player = new VideoPlayer();
        player.play(VID_URL);
      }
    });
  }
}
