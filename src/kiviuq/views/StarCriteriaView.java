package kiviuq.views;

import java.awt.Graphics;

import javax.swing.JPanel;

import kiviuq.entities.StarCriteria;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class StarCriteriaView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StarCriteria starCriteria;
	JLabel lblOnecriterialabel, lblTwocriterialabel, lblThreecriterialabel;
	
	
	public StarCriteriaView(StarCriteria starCriteria) {
		super();
		this.starCriteria = starCriteria;
		
		setLayout(new GridLayout(3, 2, 5, 0));
		
		JLabel lblOneStar = new JLabel("\u2605");
		add(lblOneStar);
		
		this.lblOnecriterialabel = new JLabel("OneCriteriaLabel");
		add(lblOnecriterialabel);
		
		JLabel lblNewLabel = new JLabel("\u2605\u2605");
		add(lblNewLabel);
		
		this.lblTwocriterialabel = new JLabel("TwoCriteriaLabel");
		add(lblTwocriterialabel);
		
		JLabel lblThreeStars = new JLabel("\u2605\u2605\u2605");
		add(lblThreeStars);
		
		this.lblThreecriterialabel = new JLabel("ThreeCriteriaLabel");
		add(lblThreecriterialabel);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		lblOnecriterialabel.setText(starCriteria.getPoints1() + "");
		lblTwocriterialabel.setText(starCriteria.getPoints2() + "");
		lblThreecriterialabel.setText(starCriteria.getPoints3() + "");
	}
	
	
	
}