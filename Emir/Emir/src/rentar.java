import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class rentar extends JFrame implements ActionListener {
	private JLabel cliente, pelicula;
	private JTextField campocliente, campopelicula;
	private JButton boton1;

	public rentar() {
		setLayout(new GridLayout(4, 1));

		cliente = new JLabel("Codigo cliente: ", JLabel.LEFT);
		campocliente = new JTextField();
		add(cliente);
		add(campocliente);
		pelicula = new JLabel("Codigo pelicula:", JLabel.LEFT);
		campopelicula = new JTextField();
		add(pelicula);
		add(campopelicula);

		boton1 = new JButton("Aceptar");
		boton1.setBounds(10, 80, 100, 30);
		add(boton1);
		boton1.addActionListener(this);

	}

	public static void main(String[] ar) {
		rentar formulario2 = new rentar();
		formulario2.setBounds(0, 0, 500, 200);
		formulario2.setLocationRelativeTo(null);
		formulario2.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			String opcion;

			conexion conn = new conexion();
			String c, p;
			rentavideos rv = new rentavideos();
			c = campocliente.getText();
			p = campopelicula.getText();
			Date f = new Date();
			SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formateador.format(f);

			rv = new rentavideos(c, p, fecha);

			try {
				conn.video(rv);

				campocliente.setText("");
				campopelicula.setText("");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			opcion = JOptionPane.showInputDialog("�Desea continuar S/N?");
			if (opcion.equalsIgnoreCase("S") || opcion.equalsIgnoreCase("s")) {
				main(null);
			} else {
				this.dispose();
				informacion inf = new informacion();
				inf.main(null);
			}

		} else {
			this.dispose();
		}

	}
}
