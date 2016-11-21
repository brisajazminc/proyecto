import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cliente extends JFrame implements ActionListener {
	private JTextField campocodigo, campoNombre, campoMembrecia;
	private JLabel codigo, etiquetaNombre, membrecia;
	private JButton boton1, boton2;

	public cliente() {
		setLayout(new GridLayout(4, 1));
		codigo = new JLabel("Codigo cliente: ", JLabel.LEFT);
		campocodigo = new JTextField();
		add(codigo);
		add(campocodigo);
		etiquetaNombre = new JLabel("Nombre:", JLabel.LEFT);
		campoNombre = new JTextField();
		add(etiquetaNombre);
		add(campoNombre);
		membrecia = new JLabel("Membrecia(gold o normal):", JLabel.LEFT);
		add(membrecia);
		campoMembrecia = new JTextField();
		add(campoMembrecia);

		boton1 = new JButton("Aceptar");
		boton1.setBounds(10, 80, 100, 30);
		add(boton1);
		boton1.addActionListener(this);

		boton2 = new JButton("Cancelar");
		boton2.setBounds(10, 80, 100, 30);
		add(boton2);
		boton2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {

			conexion conn = new conexion();
			String c, n, m;
			persona p = new persona();
			c = campocodigo.getText();
			n = campoNombre.getText();
			m = campoMembrecia.getText();

			p = new persona(c, n, m);

			try {
				conn.insertar(p);
				JOptionPane.showMessageDialog(null, "Cliente registrado");
				campocodigo.setText("");
				campoNombre.setText("");
				campoMembrecia.setText("");

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == boton2) {
			this.dispose();
		}
	}

	public static void main(String[] ar) {
		cliente formulario1 = new cliente();
		formulario1.setBounds(0, 0, 500, 200);
		formulario1.setLocationRelativeTo(null);
		formulario1.setVisible(true);
	}
}