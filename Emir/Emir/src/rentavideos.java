
public class rentavideos {

	private String cliente, pelicula;
	private String fecha;

	public rentavideos() {

	}

	public rentavideos(String c, String p, String fecha) {
		this.cliente = c;
		this.pelicula = p;
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public String getPelicula() {
		return pelicula;
	}

	public String getFecha() {
		return fecha;
	}

}
