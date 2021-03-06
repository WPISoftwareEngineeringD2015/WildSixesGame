package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kiviuq.controllers.LoadLevelController;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Score;
import kiviuq.entities.StarRating;

public class SelectScreen extends JFrame {
	JPanel puzzle1Panel;
	JPanel puzzle2Panel;
	JPanel puzzle3Panel;
	JPanel puzzle4Panel;
	JPanel puzzle5Panel;
	JPanel lightning1Panel;
	JPanel lightning2Panel;
	JPanel lightning3Panel;
	JPanel lightning4Panel;
	JPanel lightning5Panel;
	JPanel elimination1Panel;
	JPanel elimination2Panel;
	JPanel elimination3Panel;
	JPanel elimination4Panel;
	JPanel elimination5Panel;
	JPanel release1Panel;
	JPanel release2Panel;
	JPanel release3Panel;
	JPanel release4Panel;
	JPanel release5Panel;

	public JLabel puzzle1Label;
	public JLabel puzzle2Label;
	public JLabel puzzle3Label;
	public JLabel puzzle4Label;
	public JLabel puzzle5Label;
	public JLabel lightning1Label;
	public JLabel lightning2Label;
	public JLabel lightning3Label;
	public JLabel lightning4Label;
	public JLabel lightning5Label;
	public JLabel elimination1Label;
	public JLabel elimination2Label;
	public JLabel elimination3Label;
	public JLabel elimination4Label;
	public JLabel elimination5Label;
	public JLabel release1Label;
	public JLabel release2Label;
	public JLabel release3Label;
	public JLabel release4Label;
	public JLabel release5Label;
	
	JPanel panel_1;

	/**
	 * @author mhomchenko
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	JFrame lastWindow;


	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public SelectScreen(JFrame lastWindow) throws ClassNotFoundException, IOException {
		this.lastWindow = lastWindow;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		JLabel title = new JLabel("Levels");
		title.setFont(new Font("Candara", Font.PLAIN, 38));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(title, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JButton backBTN = new JButton("Back");
		backBTN.addActionListener(new ActionListener() {
			// Executes code on button press
			public void actionPerformed(ActionEvent e) {
				SelectScreen.this.goToMainScreen();
			}
		});
		panel.add(backBTN, BorderLayout.WEST);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 5, 5, 5));

		puzzle1Panel = new JPanel();
		FlowLayout fl_puzzle1Panel = (FlowLayout) puzzle1Panel.getLayout();
		fl_puzzle1Panel.setAlignOnBaseline(true);
		puzzle1Panel.setBackground(Color.CYAN);
		puzzle1Label = new JLabel();
		puzzle1Label.setFont(new Font("Verdana",1,16));
		puzzle1Panel.add(puzzle1Label);
		puzzle1Panel.setName("puzzle1");
		puzzle1Panel.addMouseListener(new LoadLevelController(puzzle1Panel.getName(), this));
		panel_1.add(puzzle1Panel);

		puzzle2Panel = new JPanel();
		puzzle2Panel.setBackground(Color.GRAY);
		puzzle2Label = new JLabel();
		puzzle2Label.setFont(new Font("Verdana",1,16));
		puzzle2Panel.add(puzzle2Label);
		puzzle2Panel.setName("puzzle2");
		if (refreshHighScore("puzzle1", puzzle1Label) ) {
			puzzle2Panel.addMouseListener(new LoadLevelController(puzzle2Panel.getName(), this));
			puzzle2Panel.setBackground(Color.BLUE);
		}
		panel_1.add(puzzle2Panel);

		puzzle3Panel = new JPanel();
		puzzle3Panel.setBackground(Color.GRAY);
		puzzle3Label = new JLabel();
		puzzle3Label.setFont(new Font("Verdana",1,16));
		puzzle3Panel.add(puzzle3Label);
		puzzle3Panel.setName("puzzle3");
		if (refreshHighScore("puzzle2", puzzle2Label) ) {
			puzzle3Panel.addMouseListener(new LoadLevelController(puzzle3Panel.getName(), this));
			puzzle3Panel.setBackground(Color.GREEN);
		}
		panel_1.add(puzzle3Panel);

		puzzle4Panel = new JPanel();
		puzzle4Panel.setBackground(Color.GRAY);
		puzzle4Label = new JLabel();
		puzzle4Label.setFont(new Font("Verdana",1,16));
		puzzle4Panel.add(puzzle4Label);
		puzzle4Panel.setName("puzzle4");
		if (refreshHighScore("puzzle3", puzzle3Label) ) {
			puzzle4Panel.addMouseListener(new LoadLevelController(puzzle4Panel.getName(), this));
			puzzle4Panel.setBackground(Color.YELLOW);
		}
		panel_1.add(puzzle4Panel);

		puzzle5Panel = new JPanel();
		puzzle5Panel.setBackground(Color.GRAY);
		puzzle5Label = new JLabel();
		puzzle5Label.setFont(new Font("Verdana",1,16));
		puzzle5Panel.add(puzzle5Label);
		puzzle5Panel.setName("puzzle5");
		if (refreshHighScore("puzzle4", puzzle4Label) ) {
			puzzle5Panel.addMouseListener(new LoadLevelController(puzzle5Panel.getName(), this));
			puzzle5Panel.setBackground(Color.ORANGE);
		}
		panel_1.add(puzzle5Panel);

		lightning1Panel = new JPanel();
		lightning1Panel.setBackground(Color.CYAN); 
		lightning1Label = new JLabel();
		lightning1Label.setFont(new Font("Verdana",1,16));
		lightning1Panel.add(lightning1Label);
		lightning1Panel.setName("lightning1");
		lightning1Panel.addMouseListener(new LoadLevelController(lightning1Panel.getName(), this));
		panel_1.add(lightning1Panel);

		lightning2Panel = new JPanel();
		lightning2Panel.setBackground(Color.GRAY);
		lightning2Label = new JLabel();
		lightning2Label.setFont(new Font("Verdana",1,16));
		lightning2Panel.add(lightning2Label);
		lightning2Panel.setName("lightning2");
		if (refreshHighScore("lightning1", lightning1Label) ) {
			lightning2Panel.addMouseListener(new LoadLevelController(lightning2Panel.getName(), this));
			lightning2Panel.setBackground(Color.BLUE);
		}
		panel_1.add(lightning2Panel);

		lightning3Panel = new JPanel();
		lightning3Panel.setBackground(Color.GRAY);
		lightning3Label = new JLabel();
		lightning3Label.setFont(new Font("Verdana",1,16));
		lightning3Panel.add(lightning3Label);
		lightning3Panel.setName("lightning3");
		if (refreshHighScore("lightning2", lightning2Label) ) {
			lightning3Panel.addMouseListener(new LoadLevelController(lightning3Panel.getName(), this));
			lightning3Panel.setBackground(Color.GREEN);
		}
		panel_1.add(lightning3Panel);

		lightning4Panel = new JPanel();
		lightning4Panel.setBackground(Color.GRAY);
		lightning4Label = new JLabel();
		lightning4Label.setFont(new Font("Verdana",1,16));
		lightning4Panel.add(lightning4Label);
		lightning4Panel.setName("lightning4");
		if (refreshHighScore("lightning3", lightning3Label) ) {
			lightning4Panel.addMouseListener(new LoadLevelController(lightning4Panel.getName(), this));
			lightning4Panel.setBackground(Color.YELLOW);
		}
		panel_1.add(lightning4Panel);

		lightning5Panel = new JPanel();
		lightning5Panel.setBackground(Color.GRAY);
		lightning5Label = new JLabel();
		lightning5Label.setFont(new Font("Verdana",1,16));
		lightning5Panel.add(lightning5Label);
		lightning5Panel.setName("lightning5");
		if (refreshHighScore("lightning4", lightning4Label) ) {
			lightning5Panel.addMouseListener(new LoadLevelController(lightning5Panel.getName(), this));
			lightning5Panel.setBackground(Color.ORANGE);
		}
		panel_1.add(lightning5Panel);

		elimination1Panel = new JPanel();
		elimination1Panel.setBackground(Color.CYAN);
		elimination1Label = new JLabel();
		elimination1Label.setFont(new Font("Verdana",1,16));
		elimination1Panel.add(elimination1Label);
		elimination1Panel.setName("elimination1");
		elimination1Panel.addMouseListener(new LoadLevelController(elimination1Panel.getName(), this));
		panel_1.add(elimination1Panel);

		elimination2Panel = new JPanel();
		elimination2Panel.setBackground(Color.GRAY);
		elimination2Label = new JLabel();
		elimination2Label.setFont(new Font("Verdana",1,16));
		elimination2Panel.add(elimination2Label);
		elimination2Panel.setName("elimination2");
		if (refreshHighScore("elimination1", elimination1Label) ) {
			elimination2Panel.addMouseListener(new LoadLevelController(elimination2Panel.getName(), this));
			elimination2Panel.setBackground(Color.BLUE);
		}
		panel_1.add(elimination2Panel);

		elimination3Panel = new JPanel();
		elimination3Panel.setBackground(Color.GRAY);
		elimination3Label = new JLabel();
		elimination3Label.setFont(new Font("Verdana",1,16));
		elimination3Panel.add(elimination3Label);
		elimination3Panel.setName("elimination3");
		if (refreshHighScore("elimination2", elimination2Label) ) {
			elimination3Panel.addMouseListener(new LoadLevelController(elimination3Panel.getName(), this));
			elimination3Panel.setBackground(Color.GREEN);
		}
		panel_1.add(elimination3Panel);

		elimination4Panel = new JPanel();
		elimination4Panel.setBackground(Color.GRAY);
		elimination4Label = new JLabel();
		elimination4Label.setFont(new Font("Verdana",1,16));
		elimination4Panel.add(elimination4Label);
		elimination4Panel.setName("elimination4");
		if (refreshHighScore("elimination3", elimination3Label) ) {
			elimination4Panel.addMouseListener(new LoadLevelController(elimination4Panel.getName(), this));
			elimination4Panel.setBackground(Color.YELLOW);
		}
		panel_1.add(elimination4Panel);

		elimination5Panel = new JPanel();
		elimination5Panel.setBackground(Color.GRAY);
		elimination5Label = new JLabel();
		elimination5Label.setFont(new Font("Verdana",1,16));
		elimination5Panel.add(elimination5Label);
		elimination5Panel.setName("elimination5");
		if (refreshHighScore("elimination4", elimination4Label) ) {
			elimination5Panel.addMouseListener(new LoadLevelController(elimination5Panel.getName(), this));
			elimination5Panel.setBackground(Color.ORANGE);
		}
		panel_1.add(elimination5Panel);

		release1Panel = new JPanel();
		release1Panel.setBackground(Color.CYAN);
		release1Label = new JLabel();
		release1Label.setFont(new Font("Verdana",1,16));
		release1Panel.add(release1Label);
		release1Panel.setName("release1");
		release1Panel.addMouseListener(new LoadLevelController(release1Panel.getName(), this));
		panel_1.add(release1Panel);

		release2Panel = new JPanel();
		release2Panel.setBackground(Color.GRAY);
		release2Label = new JLabel();
		release2Label.setFont(new Font("Verdana",1,16));
		release2Panel.add(release2Label);
		release2Panel.setName("release2");
		if (refreshHighScore("release1", release1Label) ) {
			release2Panel.addMouseListener(new LoadLevelController(release2Panel.getName(), this));
			release2Panel.setBackground(Color.BLUE);
		}
		panel_1.add(release2Panel);

		release3Panel = new JPanel();
		release3Panel.setBackground(Color.GRAY);
		release3Label = new JLabel();
		release3Label.setFont(new Font("Verdana",1,16));
		release3Panel.add(release3Label);
		release3Panel.setName("release3");
		if (refreshHighScore("release2", release2Label) ) {
			release3Panel.addMouseListener(new LoadLevelController(release3Panel.getName(), this));
			release3Panel.setBackground(Color.GREEN);
		}
		panel_1.add(release3Panel);

		release4Panel = new JPanel();
		release4Panel.setBackground(Color.GRAY);
		release4Label = new JLabel();
		release4Label.setFont(new Font("Verdana",1,16));
		release4Panel.add(release4Label);
		release4Panel.setName("release4");
		if (refreshHighScore("release3", release3Label) ) {
			release4Panel.addMouseListener(new LoadLevelController(release4Panel.getName(), this));
			release4Panel.setBackground(Color.YELLOW);
		}
		panel_1.add(release4Panel);

		release5Panel = new JPanel();
		release5Panel.setBackground(Color.GRAY);
		release5Label = new JLabel();
		release5Label.setFont(new Font("Verdana",1,16));
		release5Panel.add(release5Label);
		release5Panel.setName("release5");
		if (refreshHighScore("release4", release4Label) ) {
			release5Panel.addMouseListener(new LoadLevelController(release5Panel.getName(), this));
			release5Panel.setBackground(Color.ORANGE);
		}
		panel_1.add(release5Panel);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(4, 1, 15, 5));

		JLabel lblNewLabel = new JLabel("Puzzle");
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Lightning");
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Elimination   ");
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Release");
		panel_2.add(lblNewLabel_3);

		refreshHighScores();
	}

	/**
	 * Returns WildSixes to the MainScreen and disposes this window.
	 */
	public void goToMainScreen() {
		this.lastWindow.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}

	public void setObjectInputStream(ObjectInputStream input, ObjectInputStream newInput) {
		input = newInput;		
	}

	private boolean refreshHighScore(String name, JLabel label) {
		// this block of code looks crazy, but it seems to be
		// necessary for relative class path to work
		File file = new File(getClass().getClassLoader()
				.getResource("LevelTemplates/" + name).toString().replaceAll("%20", " "));
		String[] tempString;
		String fileString = file.toString();
		tempString = fileString.split(":", 2);
		FileInputStream fileInput;

		LevelTemplate template = null;

		try {
			fileInput = new FileInputStream(tempString[1]);
			ObjectInputStream in = new ObjectInputStream(fileInput);
			template = (LevelTemplate) in.readObject();
			in.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Score highScore = new Score(template.getHighScorePoints(), template.getHighScoreRating());
		label.setText(highScore.getHighScoreText());
		this.repaint();

		if (highScore.getRating() == StarRating.NoStars) {
			return false;
		} else
			return true;
	}

	public void refreshHighScores() {
		try {
			if (refreshHighScore("puzzle1", puzzle1Label) ) {
				puzzle2Panel.addMouseListener(new LoadLevelController(puzzle2Panel.getName(), this));
				puzzle2Panel.setBackground(Color.BLUE);
			}
			if (refreshHighScore("puzzle2", puzzle2Label) ) {
				puzzle3Panel.addMouseListener(new LoadLevelController(puzzle3Panel.getName(), this));
				puzzle3Panel.setBackground(Color.GREEN);
			}
			if (refreshHighScore("puzzle3", puzzle3Label) ) {
				puzzle4Panel.addMouseListener(new LoadLevelController(puzzle4Panel.getName(), this));
				puzzle4Panel.setBackground(Color.YELLOW);
			}
			if (refreshHighScore("puzzle4", puzzle4Label) ) {
				puzzle5Panel.addMouseListener(new LoadLevelController(puzzle5Panel.getName(), this));
				puzzle5Panel.setBackground(Color.ORANGE);
			}
			refreshHighScore("puzzle5", puzzle5Label);

			if (refreshHighScore("elimination1", elimination1Label) ) {
				elimination2Panel.addMouseListener(new LoadLevelController(elimination2Panel.getName(), this));
				elimination2Panel.setBackground(Color.BLUE);
			}
			if (refreshHighScore("elimination2", elimination2Label) ) {
				elimination3Panel.addMouseListener(new LoadLevelController(elimination3Panel.getName(), this));
				elimination3Panel.setBackground(Color.GREEN);
			}
			if (refreshHighScore("elimination3", elimination3Label) ) {
				elimination4Panel.addMouseListener(new LoadLevelController(elimination4Panel.getName(), this));
				elimination4Panel.setBackground(Color.YELLOW);
			}
			if (refreshHighScore("elimination4", elimination4Label) ) {
				elimination5Panel.addMouseListener(new LoadLevelController(elimination5Panel.getName(), this));
				elimination5Panel.setBackground(Color.ORANGE);
			}
			refreshHighScore("elimination5", elimination5Label);

			if (refreshHighScore("lightning1", lightning1Label) ) {
				lightning2Panel.addMouseListener(new LoadLevelController(lightning2Panel.getName(), this));
				lightning2Panel.setBackground(Color.BLUE);
			}
			if (refreshHighScore("lightning2", lightning2Label) ) {
				lightning3Panel.addMouseListener(new LoadLevelController(lightning3Panel.getName(), this));
				lightning3Panel.setBackground(Color.GREEN);
			}
			if (refreshHighScore("lightning3", lightning3Label) ) {
				lightning4Panel.addMouseListener(new LoadLevelController(lightning4Panel.getName(), this));
				lightning4Panel.setBackground(Color.YELLOW);
			}
			if (refreshHighScore("lightning4", lightning4Label) ) {
				lightning5Panel.addMouseListener(new LoadLevelController(lightning5Panel.getName(), this));
				lightning5Panel.setBackground(Color.ORANGE);
			}
			refreshHighScore("lightning5", lightning5Label);

			if (refreshHighScore("release1", release1Label) ) {
				release2Panel.addMouseListener(new LoadLevelController(release2Panel.getName(), this));
				release2Panel.setBackground(Color.BLUE);
			}
			if (refreshHighScore("release2", release2Label) ) {
				release3Panel.addMouseListener(new LoadLevelController(release3Panel.getName(), this));
				release3Panel.setBackground(Color.GREEN);
			}
			if (refreshHighScore("release3", release3Label) ) {
				release4Panel.addMouseListener(new LoadLevelController(release4Panel.getName(), this));
				release4Panel.setBackground(Color.YELLOW);
			}
			if (refreshHighScore("release4", release4Label) ) {
				release5Panel.addMouseListener(new LoadLevelController(release5Panel.getName(), this));
				release5Panel.setBackground(Color.ORANGE);
			}
			refreshHighScore("release5", release5Label);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
