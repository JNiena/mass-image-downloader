import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class Main {

  public static void main(String[] args) {
    String[] links = readLines("links.txt");
    for (int i = 0; i < links.length; i++) {
      downloadImage(links[i], "images/" + (i + 1) + ".jpg");
      System.out.println("Downloaded image " + (i + 1) + "/" + links.length);
    }
  }

  public static void downloadImage(String link, String filePath) {
    try {
      ImageIO.write(ImageIO.read(new URL(link)), "jpg", new File(filePath));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public static String[] readLines(String filePath) {
    try {
      return new String(Files.readAllBytes(Paths.get(filePath))).split("\n");
    } catch (IOException exception) {
      return new String[0];
    }
  }

}