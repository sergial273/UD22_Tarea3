package models;

public class Asignado {
	
	private int id_proy;
	private int id_cien;
	
	public Asignado() {
		
	}

	public Asignado(int id_proy, int id_cien) {
		this.id_proy = id_proy;
		this.id_cien = id_cien;
	}

	public int getId_proy() {
		return id_proy;
	}

	public int getId_cien() {
		return id_cien;
	}

	public void setId_proy(int id_proy) {
		this.id_proy = id_proy;
	}

	public void setId_cien(int id_cien) {
		this.id_cien = id_cien;
	}

	@Override
	public String toString() {
		return "Asignado [id_proy=" + id_proy + ", id_cien=" + id_cien + "]";
	}
	
	
}
