import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;
import kiviuq.views.MainScreen;
import kiviuq.views.SplashScreen;
import development.Templates;


public class WildSixesGameRunner {
	
	public static void main(String[] args) {
		MainScreen mainScreen = new MainScreen();
		LevelScreen levelScreen = new LevelScreen(new Board(Templates.getExampleTemplate()));
		//SplashScreen s = new SplashScreen(2000, mainScreen);
		SplashScreen s = new SplashScreen(2000, levelScreen);
		s.launchSplashScreen();
	}
}
