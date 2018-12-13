package pojos;

import java.util.Date;

public class Noticia {

	private Long id;
	private String titular;
	private Date fecha;
	private String autor;
	private String texto;
	
	private String errorID;
	private String errortitular;
	private String errorfecha;
	private String errorautor;
	private String errortexto;
	
	
	private boolean hayErrores = false;
	public Noticia(Long id, String titular, Date fecha, String autor, String texto) {
		super();
		setId(id);
		setTitular(titular);
		setFecha(fecha);
		setAutor(autor);
		setTexto(texto);
	}
	

	

	public Long getId() {
		return id;
	}




	public String getTitular() {
		return titular;
	}




	public Date getFecha() {
		return fecha;
	}




	public String getAutor() {
		return autor;
	}




	public String getTexto() {
		return texto;
	}




	public String getErrorID() {
		return errorID;
	}




	public String getErrortitular() {
		return errortitular;
	}




	public String getErrorfecha() {
		return errorfecha;
	}




	public String getErrorautor() {
		return errorautor;
	}




	public String getErrortexto() {
		return errortexto;
	}




	public void setId(Long id) {
		if(id==null || id<=0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrorID("Valores numericos");
		}
		this.id = id;
		
	}




	public void setTitular(String titular) {
		
		if(titular==null || titular.trim().length() == 0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrortitular("Obligatorio");
		}
		this.titular = titular.trim();
	}




	public void setFecha(Date fecha) {
		
		this.fecha = fecha;
	}




	public void setAutor(String autor) {
		if(autor==null || autor.trim().length() == 0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrorautor("Obligatorio");
		}
		this.autor = autor.trim();
	}




	public void setTexto(String texto) {
		if(texto==null || texto.trim().length() == 0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrortexto("Obligatorio");
		}
		this.texto = texto;
	}




	public void setErrorID(String errorID) {
		this.errorID = errorID;
	}




	public void setErrortitular(String errortitular) {
		hayErrores=true;
		this.errortitular = errortitular;
	}




	public void setErrorfecha(String errorfecha) {
		this.errorfecha = errorfecha;
	}




	public void setErrorautor(String errorautor) {
		hayErrores=true;
		this.errorautor = errorautor;
	}




	public void setErrortexto(String errortexto) {
		hayErrores=true;
		this.errortexto = errortexto;
	}


	

	public boolean isCorrecto() {
		return !hayErrores;
	}
	

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titular=" + titular + ", fecha=" + fecha + ", autor=" + autor + ", texto="
				+ texto + "]";
	}




	
	
	
	
	
	
	
}
