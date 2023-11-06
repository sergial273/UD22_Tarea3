package models;

public class Cientifico {
	private int id;
	private int dni;
	private String name;
	
	public Cientifico() {
		
	}

	public Cientifico(int id, int dni, String name) {
		this.id = id;
		this.dni = dni;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cientifico [id=" + id + ", dni=" + dni + ", name=" + name + "]";
	}
	
	
	
}
