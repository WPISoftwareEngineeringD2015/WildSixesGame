package kiviuq.views;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class MainScreen extends JFrame{
	public MainScreen() {
		super();
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		getContentPane().add(chckbxNewCheckBox, BorderLayout.CENTER);
	}
}
