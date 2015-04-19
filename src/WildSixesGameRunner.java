import kiviuq.views.MainScreen;
import kiviuq.views.SplashScreen;


public class WildSixesGameRunner {
	
	public static void main(String[] args) {
		MainScreen mainScreen = new MainScreen();
		SplashScreen s = new SplashScreen(300, mainScreen);
		s.launchSplashScreen();
	}
}
