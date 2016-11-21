import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class menu extends JFrame implements ActionListener {

	private JButton boton1, boton2;

	public menu() {
		setLayout(new GridLayout(4, 1));

		boton1 = new JButton("Dar de alta cliente");
		boton1.setBounds(10, 30, 50, 30);
		add(boton1);

		boton2 = new JButton("Rentar");
		boton2.setBounds(10, 30, 50, 30);
		add(boton2);

		boton2.addActionListener(this);

	}

	public static void main(String[] ar) {
		menu menu1 = new menu();
		menu1.setBounds(0, 0, 200, 200);
		menu1.setLocationRelativeTo(null);
		menu1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			cliente cl = new cliente();
			cl.main(null);
		}

		if (e.getSource() == boton2) {
			rentar re = new rentar();
			re.main(null);
		}
	}
}
