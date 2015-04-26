
package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import development.Templates;

public class SelectScreen extends JFrame {

	/**
	 * @author mhomchenko
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	JFrame lastWindow;


	/**
	 * Create the frame.
	 */
	public SelectScreen(JFrame lastWindow) {
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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 5, 5, 5));
		
		MouseAdapter levelClickListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel sourcePanel = (JPanel) e.getSource();
				String nameComponents = sourcePanel.getName();
				// String gameModeStr = nameComponents[0];
				// int levelNumber = Integer.parseInt(nameComponents[1]);
				
				// TODO implement this later
				// for now, just load up any level with out getExampleTemplate()...
				
				if(nameComponents.equals("puzzle 1")) {
					LevelTemplate template = Templates.getExampleTemplate();
					LevelScreen lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), SelectScreen.this);
					lvlScreen.setVisible(true);
					SelectScreen.this.setVisible(false);
					}
				/* TODO implement this later 
				GameMode gameMode;
				
				switch(gameModeStr) {
				case "puzzle":
					gameMode = GameMode.Puzzle;
					break;
				case "elimination":
					gameMode = GameMode.Elimination;
					break;
				case "lightning":
					gameMode = GameMode.Lightning;
					break;
				case "release":
					gameMode = GameMode.Release;
					break;
				default:
					gameMode = null;
				} */
				
				// TODO levelTemplate = new LevelTemplate(gameMode, levelNumber, ...
			}
		};
		
		JPanel puzzle1Panel = new JPanel();
		puzzle1Panel.addMouseListener(levelClickListener);
		FlowLayout fl_puzzle1Panel = (FlowLayout) puzzle1Panel.getLayout();
		fl_puzzle1Panel.setAlignOnBaseline(true);
		puzzle1Panel.setBackground(Color.CYAN);
		puzzle1Panel.setName("puzzle 1");
		panel_1.add(puzzle1Panel);
		
		JPanel puzzle2Panel = new JPanel();
		puzzle2Panel.setBackground(Color.BLUE);
		puzzle2Panel.addMouseListener(levelClickListener);
		puzzle2Panel.setName("puzzle 2");
		panel_1.add(puzzle2Panel);
		
		JPanel puzzle3Panel = new JPanel();
		puzzle3Panel.setBackground(Color.BLUE);
		puzzle3Panel.addMouseListener(levelClickListener);
		puzzle3Panel.setName("puzzle 3");
		panel_1.add(puzzle3Panel);
		
		JPanel puzzle4Panel = new JPanel();
		puzzle4Panel.setBackground(Color.BLUE);
		puzzle4Panel.addMouseListener(levelClickListener);
		puzzle4Panel.setName("puzzle 4");
		panel_1.add(puzzle4Panel);
		
		JPanel puzzle5Panel = new JPanel();
		puzzle5Panel.setBackground(Color.BLUE);
		puzzle5Panel.addMouseListener(levelClickListener);
		puzzle5Panel.setName("puzzle 5");
		panel_1.add(puzzle5Panel);
		
		JPanel lightning1Panel = new JPanel();
		lightning1Panel.setBackground(Color.BLUE);
		lightning1Panel.addMouseListener(levelClickListener);
		lightning1Panel.setName("lightning 1");
		panel_1.add(lightning1Panel);
		
		JPanel lightning2Panel = new JPanel();
		lightning2Panel.setBackground(Color.BLUE);
		lightning2Panel.addMouseListener(levelClickListener);
		lightning2Panel.setName("lightning 2");
		panel_1.add(lightning2Panel);
		
		JPanel lightning3Panel = new JPanel();
		lightning3Panel.setBackground(Color.BLUE);
		lightning3Panel.addMouseListener(levelClickListener);
		lightning3Panel.setName("lightning 3");
		panel_1.add(lightning3Panel);
		
		JPanel lightning4Panel = new JPanel();
		lightning4Panel.setBackground(Color.BLUE);
		lightning4Panel.addMouseListener(levelClickListener);
		lightning4Panel.setName("lightning 4");
		panel_1.add(lightning4Panel);
		
		JPanel lightning5Panel = new JPanel();
		lightning5Panel.setBackground(Color.BLUE);
		lightning5Panel.addMouseListener(levelClickListener);
		lightning5Panel.setName("lightning 5");
		panel_1.add(lightning5Panel);
		
		JPanel elimination1Panel = new JPanel();
		elimination1Panel.setBackground(Color.BLUE);
		elimination1Panel.addMouseListener(levelClickListener);
		elimination1Panel.setName("elinimation 1");
		panel_1.add(elimination1Panel);
		
		JPanel elimination2Panel = new JPanel();
		elimination2Panel.setBackground(Color.BLUE);
		elimination2Panel.addMouseListener(levelClickListener);
		elimination2Panel.setName("elinimation 2");
		panel_1.add(elimination2Panel);
		
		JPanel elimination3Panel = new JPanel();
		elimination3Panel.setBackground(Color.BLUE);
		elimination3Panel.addMouseListener(levelClickListener);
		elimination3Panel.setName("elinimation 3");
		panel_1.add(elimination3Panel);
		
		JPanel elimination4Panel = new JPanel();
		elimination4Panel.setBackground(Color.BLUE);
		elimination4Panel.addMouseListener(levelClickListener);
		elimination4Panel.setName("elinimation 4");
		panel_1.add(elimination4Panel);
		
		JPanel elimination5Panel = new JPanel();
		elimination5Panel.setBackground(Color.BLUE);
		elimination5Panel.addMouseListener(levelClickListener);
		elimination5Panel.setName("elinimation 5");
		panel_1.add(elimination5Panel);
		
		JPanel release1Panel = new JPanel();
		release1Panel.setBackground(Color.BLUE);
		release1Panel.addMouseListener(levelClickListener);
		release1Panel.setName("release 1");
		panel_1.add(release1Panel);
		
		JPanel release2Panel = new JPanel();
		release2Panel.setBackground(Color.BLUE);
		release2Panel.addMouseListener(levelClickListener);
		release2Panel.setName("release 2");
		panel_1.add(release2Panel);
		release2Panel.setLayout(null);
		
		JPanel release3Panel = new JPanel();
		release3Panel.setLayout(null);
		release3Panel.addMouseListener(levelClickListener);
		release3Panel.setBackground(Color.BLUE);
		release3Panel.setName("release 3");
		panel_1.add(release3Panel);
		
		JPanel release4Panel = new JPanel();
		release4Panel.setLayout(null);
		release4Panel.setBackground(Color.BLUE);
		release4Panel.addMouseListener(levelClickListener);
		release4Panel.setName("release 4");
		panel_1.add(release4Panel);
		
		JPanel release5Panel = new JPanel();
		release5Panel.setLayout(null);
		release5Panel.setBackground(Color.BLUE);
		release5Panel.addMouseListener(levelClickListener);
		release5Panel.setName("release 5");
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
	}

	public void goToMainScreen() {
		this.lastWindow.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
}
