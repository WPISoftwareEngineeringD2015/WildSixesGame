package kiviuq.views;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MainScreen extends JFrame{
	public MainScreen() {
		super();
		setResizable(false);
		setTitle("Wild Sixes");
		setSize(750,450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton ScoreButton = new JButton("Scores");
		ScoreButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ScoreButton.setBounds(10, 359, 131, 52);
		getContentPane().add(ScoreButton);
		
		JButton PlayButton = new JButton("Play");
		PlayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayButton.setBounds(10, 296, 131, 52);
		getContentPane().add(PlayButton);
		
		JLabel lblNewLabel = new JLabel("Wild Sixes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(283, 101, 169, 71);
		getContentPane().add(lblNewLabel);
	}
}
