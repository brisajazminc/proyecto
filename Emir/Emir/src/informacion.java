import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class informacion extends JFrame {
	private JLabel informacion, codigo, etiquetaNombre;
	private DefaultTableModel modelo;
	private JTable tabla;
	private DefaultTableCellRenderer renderizadorCelda;
	private TableColumn columna;
	private JScrollPane scroll;

	public informacion() throws SQLException {
		setLayout(new GridLayout(4, 2));
		conexion conn = new conexion();
		JLabel codigo = null, pelicula = null, cliente = null;

		ResultSet rs = conn
				.consultar("SELECT * FROM renta,cliente,video where n_cliente=codigo_cliente");

		modelo.setRowCount(0);
		try {
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getObject("n_pelicula"));
				modelo.addRow(v);
				tabla.setModel(modelo);
			}

			LineBorder color = new LineBorder(Color.white);

			tabla = new JTable(modelo);
			tabla.getTableHeader().setReorderingAllowed(false);
			tabla.getTableHeader().setBorder(color);
			tabla.setBorder(color);
			tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			tabla.setSelectionForeground(Color.white);

			renderizadorCelda = new DefaultTableCellRenderer();
			renderizadorCelda.setHorizontalAlignment(JLabel.CENTER);

			columna = new TableColumn();
			columna = tabla.getColumnModel().getColumn(0);
			columna.setMaxWidth(80);
			columna.setCellRenderer(renderizadorCelda);

			scroll = new JScrollPane(tabla);
			scroll.setBorder(new LineBorder(null));
			add(scroll);

		} catch (Exception e) {

		}

		// try {
		// informacion = new JLabel(" INFORMACION DE RENTA ", JLabel.CENTER);
		// add(informacion);
		//
		// ResultSet rs = conn
		// .consultar("SELECT * FROM renta,cliente,video where n_cliente=codigo_cliente");
		//
		// Vector<Vector> datos = new Vector<Vector>();
		// Vector objetos = new Vector();
		// Vector<Object> fila = new Vector<Object>();
		//
		// // Recupera los datos
		// while (rs.next()) {
		// fila = new Vector<Object>();
		// fila.addElement(rs.getObject("n_pelicula"));
		// datos.addElement(fila);
		// }
		//
		// Vector<String> encabezados = new Vector<String>();
		// encabezados.addElement("C�digo");
		// encabezados.addElement("Pelicula");
		//
		// modelo = new DefaultTableModel(datos, encabezados) {
		// public boolean isCellEditable(int row, int column) {
		// return false;
		// }
		// };
		//
		// LineBorder color = new LineBorder(Color.white);
		//
		// tabla = new JTable(modelo);
		// tabla.getTableHeader().setReorderingAllowed(false);
		// tabla.getTableHeader().setBorder(color);
		// tabla.setBorder(color);
		// tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//
		// tabla.setSelectionForeground(Color.white);
		//
		// renderizadorCelda = new DefaultTableCellRenderer();
		// renderizadorCelda.setHorizontalAlignment(JLabel.CENTER);
		//
		// columna = new TableColumn();
		// columna = tabla.getColumnModel().getColumn(0);
		// columna.setMaxWidth(80);
		// columna.setCellRenderer(renderizadorCelda);
		//
		// scroll = new JScrollPane(tabla);
		// scroll.setBorder(new LineBorder(null));
		// add(scroll);
		//
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
	}

	public static void main(String[] ar) throws SQLException {
		informacion formulario3 = new informacion();
		formulario3.setBounds(0, 0, 400, 200);
		formulario3.setLocationRelativeTo(null);
		formulario3.setVisible(true);
	}
}
