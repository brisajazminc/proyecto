
public class persona {
	
	private String codigo;
	private String nombre, membrecia;
	
	public persona(){
		
	}
	
	public persona (String codigo, String nombre, String membrecia ){
		this.codigo = codigo;
		this.nombre = nombre;
		this.membrecia = membrecia;
	}
	
	public String getCodigo(){
		return codigo;
	}

	public String getNombre(){
		return nombre;
	}


	public String getMembrecia(){
		return membrecia;
	}
	
}
