import kiviuq.views.MainScreen;
import kiviuq.views.SplashScreen;

/**
 * Main class, simply fires off a new {@link SplashScreen} reference and
 * launches the game.
 * 
 * @author Evin Ugur
 *
 */
public class WildSixesGameRunner {

	/**
	 * Main method for the program
	 * 
	 * @param args
	 *            unused command line options
	 */
	public static void main(String[] args) {
		MainScreen mainScreen = new MainScreen();
		SplashScreen s = new SplashScreen(500, mainScreen);
		s.launchSplashScreen();
	}
}
