import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class index extends JFrame {
	JButton botonCopiar;
	JTextField campoValor, resultado;

	public index() {
		setLayout(new FlowLayout());
		add(new JLabel("Valor "));
		campoValor = new JTextField(5);
		add(campoValor);
		botonCopiar = new JButton("Copiar");
		add(botonCopiar);
		botonCopiar.addActionListener(new OyenteBoton());
		add(new JLabel(" Copia "));
		resultado = new JTextField(6);
	
		setSize(400, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		index ventana = new index();
	}
	
	class OyenteBoton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String valor = campoValor.getText();
			resultado.setText(valor);
		}
	}
}

