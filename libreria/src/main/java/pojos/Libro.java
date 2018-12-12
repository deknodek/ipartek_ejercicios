package pojos;

public class Libro {
	private Long id;
	private String isbn, titulo, editorial;
	private Integer precio;
	
	
	
	private String errorID;
	private String errorisbn;
	private String errortitulo;
	private String erroreditorial;
	private String errorprecio;
	
	private boolean hayErrores=false;
	//private Libro() {}
	
	public Libro(Long id, String isbn, String titulo, String editorial, Integer precio) {
		setId(id);
		setIsbn(isbn);
		setTitulo(titulo);
		setEditorial(editorial);
		setPrecio(precio);
	}
	
	

	public Long getId() {
		
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setId(Long id) {
		
		if(id==null || id<=0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrorID("El id debe valer mas que 0");
		}
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
		if(isbn==null || isbn.trim().length() == 0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrorisbn("El isbn no puede estar vacio");
		}
	}

	public void setTitulo(String titulo) {
		if(titulo==null || titulo.trim().length() == 0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErrortitulo("El editorial no puede estar vacio");
		}
		this.titulo = titulo;
	}

	public void setEditorial(String editorial) {
		if(editorial==null || editorial.trim().length() == 0) {
			//throw new PojoException("no se admiten valores de id negativos");
			setErroreditorial("El editorial no puede estar vacio");
		}
		this.editorial = editorial;
	}

	public void setPrecio(Integer precio) {
		if(precio==null || precio>=0) {
			setErrorprecio("el precio tiene k ser superior a 0");
		}
		this.precio = precio;
	}

	
	
	
	
	
	
	
	
	public String getErrorID() {
		return errorID;
	}



	public String getErrorisbn() {
		return errorisbn;
	}



	public String getErrortitulo() {
		return errortitulo;
	}



	public String getErroreditorial() {
		return erroreditorial;
	}



	public String getErrorprecio() {
		return errorprecio;
	}



	public void setErrorID(String errorID) {
		hayErrores=true;
		this.errorID = errorID;
	}



	public void setErrorisbn(String errorisbn) {
		hayErrores=true;
		this.errorisbn = errorisbn;
	}



	public void setErrortitulo(String errortitulo) {
		hayErrores=true;
		this.errortitulo = errortitulo;
	}



	public void setErroreditorial(String erroreditorial) {
		hayErrores=true;
		this.erroreditorial = erroreditorial;
	}



	public void setErrorprecio(String errorprecio) {
		hayErrores=true;
		this.errorprecio = errorprecio;
	}



	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", precio="+ precio + "]";
	}
	

	
	
	
}
