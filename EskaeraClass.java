package ERRONKA;

import java.util.Objects;

public class EskaeraClass {

String Lana_id, Langilea, Matrikula, Deskribapena, Piezak,  Prezioa,  Orduak, Kantitatea, Data;

	
	
	public EskaeraClass(String Lana_id, String Langilea,String Matrikula,String Deskribapena, String Piezak, String Kantitatea, String Prezioa, String Orduak, String Data) {
		
		this.Lana_id=Lana_id;
		this.Langilea=Langilea;
		this.Matrikula=Matrikula;
		this.Deskribapena=Deskribapena;
		this.Piezak=Piezak;
		this.Kantitatea=Kantitatea;	
		this.Prezioa=Prezioa;
		this.Orduak=Orduak;
		this.Data=Data;

	}



	public String getData() {
		return Data;
	}



	public void setData(String data) {
		Data = data;
	}



	public String getLana_id() {
		return Lana_id;
	}



	public void setLana_id(String Lana_id) {
		Lana_id = Lana_id;
	}



	public String getPiezak() {
		return Piezak;
	}



	public void setPiezak(String piezak) {
		Piezak = piezak;
	}



	public String getKantitatea() {
		return Kantitatea;
	}



	public void setKantitatea(String kantitatea) {
		Kantitatea = kantitatea;
	}



	@Override
	public int hashCode() {
		return Objects.hash(Data, Deskribapena, Kantitatea, Lana_id, Langilea, Matrikula, Orduak, Piezak, Prezioa);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EskaeraClass other = (EskaeraClass) obj;
		return Objects.equals(Data, other.Data) && Objects.equals(Deskribapena, other.Deskribapena)
				&& Objects.equals(Kantitatea, other.Kantitatea) && Objects.equals(Lana_id, other.Lana_id)
				&& Objects.equals(Langilea, other.Langilea) && Objects.equals(Matrikula, other.Matrikula)
				&& Objects.equals(Orduak, other.Orduak) && Objects.equals(Piezak, other.Piezak)
				&& Objects.equals(Prezioa, other.Prezioa);
	}



	@Override
	public String toString() {
		return "EskaeraClass [Lana_id=" + Lana_id + ", Langilea=" + Langilea + ", Matrikula=" + Matrikula
				+ ", Deskribapena=" + Deskribapena + ", Piezak=" + Piezak + ", Prezioa=" + Prezioa + ", Orduak="
				+ Orduak + ", Kantitatea=" + Kantitatea + ", Data=" + Data + "]";
	}



	public String getLangilea() {
		return Langilea;
	}



	public void setLangilea(String langilea) {
		Langilea = langilea;
	}



	public String getMatrikula() {
		return Matrikula;
	}



	public void setMatrikula(String matrikula) {
		Matrikula = matrikula;
	}



	public String getDeskribapena() {
		return Deskribapena;
	}



	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}



	public String getPrezioa() {
		return Prezioa;
	}



	public void setPrezioa(String prezioa) {
		Prezioa = prezioa;
	}



	public String getOrduak() {
		return Orduak;
	}



	public void setOrduak(String orduak) {
		Orduak = orduak;
	}
	
	
	
}
