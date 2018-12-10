package pojos;

public class Libro {
	private Long id;
	private String isbn, titulo, editorial;
	private Integer precio;
	
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
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	
	
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", precio="+ precio + "]";
	}
	

	
	
	
}
