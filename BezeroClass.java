package ERRONKA;

import java.util.Objects;

public class BezeroClass {
	
	
	String Nan, Izena, Abizena,  JaiotzeData,  Mugikor,  Mail,  PostaKode,  Herrialde,  Alta,  Autonomo;

	
	
	public BezeroClass(String Nan,String Izena,String Abizena, String JaiotzeData, String Mugikor, String Mail, String PostaKode, String Herrialde, String Alta, String Autonomo) {
		
		this.Nan=Nan;
		this.Izena=Izena;
		this.Abizena=Abizena;
		this.JaiotzeData=JaiotzeData;
		this.Mugikor=Mugikor;
		this.Mail=Mail;
		this.PostaKode=PostaKode;
		this.Herrialde=Herrialde;
		this.Alta=Alta;
		this.Autonomo=Autonomo;
	}
	



	public String getNan() {
		return Nan;
	}



	public void setNan(String nan) {
		Nan = nan;
	}



	public String getIzena() {
		return Izena;
	}



	public void setIzena(String izena) {
		Izena = izena;
	}



	public String getAbizena() {
		return Abizena;
	}



	public void setAbizena(String abizena) {
		Abizena = abizena;
	}



	public String getJaiotzeData() {
		return JaiotzeData;
	}



	public void setJaiotzeData(String jaiotzeData) {
		JaiotzeData = jaiotzeData;
	}



	public String getMugikor() {
		return Mugikor;
	}



	public void setMugikor(String mugikor) {
		Mugikor = mugikor;
	}



	public String getMail() {
		return Mail;
	}



	public void setMail(String mail) {
		Mail = mail;
	}



	public String getPostaKode() {
		return PostaKode;
	}



	public void setPostaKode(String postaKode) {
		PostaKode = postaKode;
	}



	public String getHerrialde() {
		return Herrialde;
	}



	public void setHerrialde(String herrialde) {
		Herrialde = herrialde;
	}



	public String getAlta() {
		return Alta;
	}



	public void setAlta(String alta) {
		Alta = alta;
	}



	public String getAutonomo() {
		return Autonomo;
	}



	public void setAutonomo(String autonomo) {
		Autonomo = autonomo;
	}



	@Override
	public String toString() {
		return "BezeroClass [Nan=" + Nan + ", Izena=" + Izena + ", Abizena=" + Abizena + ", JaiotzeData=" + JaiotzeData
				+ ", Mugikor=" + Mugikor + ", Mail=" + Mail + ", PostaKode=" + PostaKode + ", Herrialde=" + Herrialde
				+ ", Alta=" + Alta + ", Autonomo=" + Autonomo + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(Abizena, Alta, Autonomo, Herrialde, Izena, JaiotzeData, Mail, Mugikor, Nan, PostaKode);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BezeroClass other = (BezeroClass) obj;
		return Objects.equals(Abizena, other.Abizena) && Objects.equals(Alta, other.Alta)
				&& Objects.equals(Autonomo, other.Autonomo) && Objects.equals(Herrialde, other.Herrialde)
				&& Objects.equals(Izena, other.Izena) && Objects.equals(JaiotzeData, other.JaiotzeData)
				&& Objects.equals(Mail, other.Mail) && Objects.equals(Mugikor, other.Mugikor)
				&& Objects.equals(Nan, other.Nan) && Objects.equals(PostaKode, other.PostaKode);
	}
	
	
	
	
	

}
