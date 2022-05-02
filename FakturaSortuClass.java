package ERRONKA;

public class FakturaSortuClass {

	private String torlojua;
	private String gurpila;
	private String motelagailua;
	private String nitro;
	
	public FakturaSortuClass(String torlojua, String gurpila, String motelagailua, String nitro) {
		
	this.torlojua = torlojua;
	this.gurpila = gurpila;
	this.motelagailua = motelagailua;
	this.nitro = nitro;
	
	}

	@Override
	public String toString() {
		return "FakturaSortuClass [torlojua=" + torlojua + ", gurpila=" + gurpila + ", motelagailua=" + motelagailua
				+ ", nitro=" + nitro + "]";
	}

	public String getTorlojua() {
		return torlojua;
	}

	public void setTorlojua(String torlojua) {
		this.torlojua = torlojua;
	}

	public String getGurpila() {
		return gurpila;
	}

	public void setGurpila(String gurpila) {
		this.gurpila = gurpila;
	}

	public String getMotelagailua() {
		return motelagailua;
	}

	public void setMotelagailua(String motelagailua) {
		this.motelagailua = motelagailua;
	}

	public String getNitro() {
		return nitro;
	}

	public void setNitro(String nitro) {
		this.nitro = nitro;
	}

}
