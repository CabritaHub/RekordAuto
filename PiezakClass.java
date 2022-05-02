package ERRONKA;

import java.util.Objects;

public class PiezakClass {

String PiezaID, Izena, Deskribapena, Kantitatea , DataEntrega,  Hornitzailea, Prezioa;

	
	
	public PiezakClass(String PiezaID, String Izena,String Deskribapena,String Kantitatea, String DataEntrega, String Hornitzailea, String Prezioa) {
		
		this.PiezaID=PiezaID;
		this.Izena=Izena;
		this.Deskribapena=Deskribapena;
		this.Kantitatea=Kantitatea;
		this.Kantitatea=Kantitatea;	
		this.DataEntrega=DataEntrega;
		this.Hornitzailea=Hornitzailea;
		this.Prezioa=Prezioa;

	}



	public String getPrezioa() {
		return Prezioa;
	}



	public void setPrezioa(String prezioa) {
		Prezioa = prezioa;
	}



	public String getPiezaID() {
		return PiezaID;
	}



	public void setPiezaID(String piezaID) {
		PiezaID = piezaID;
	}



	public String getIzena() {
		return Izena;
	}



	public void setIzena(String izena) {
		Izena = izena;
	}



	public String getDeskribapena() {
		return Deskribapena;
	}



	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}



	public String getKantitatea() {
		return Kantitatea;
	}



	public void setKantitatea(String kantitatea) {
		Kantitatea = kantitatea;
	}



	public String getDataEntrega() {
		return DataEntrega;
	}



	public void setDataEntrega(String dataEntrega) {
		DataEntrega = dataEntrega;
	}



	public String getHornitzailea() {
		return Hornitzailea;
	}



	public void setHornitzailea(String hornitzailea) {
		Hornitzailea = hornitzailea;
	}



	@Override
	public String toString() {
		return "PiezakClass [PiezaID=" + PiezaID + ", Izena=" + Izena + ", Deskribapena=" + Deskribapena
				+ ", Kantitatea=" + Kantitatea + ", DataEntrega=" + DataEntrega + ", Hornitzailea=" + Hornitzailea
				+ ", Prezioa=" + Prezioa + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(DataEntrega, Deskribapena, Hornitzailea, Izena, Kantitatea, PiezaID, Prezioa);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PiezakClass other = (PiezakClass) obj;
		return Objects.equals(DataEntrega, other.DataEntrega) && Objects.equals(Deskribapena, other.Deskribapena)
				&& Objects.equals(Hornitzailea, other.Hornitzailea) && Objects.equals(Izena, other.Izena)
				&& Objects.equals(Kantitatea, other.Kantitatea) && Objects.equals(PiezaID, other.PiezaID)
				&& Objects.equals(Prezioa, other.Prezioa);
	}
	
	
}
