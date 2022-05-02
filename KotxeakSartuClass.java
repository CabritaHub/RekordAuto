package ERRONKA;

public class KotxeakSartuClass {
	
	public String matrikula;
	public String urtea;
	public String marka;
	public String modeloa;
	public String baztidorea;
	public String nan;
	
    public KotxeakSartuClass(String matrikula, String urtea, String marka, String modeloa, String baztidorea, String nan)
    {
    	this.matrikula = matrikula;
    	this.urtea = urtea;
    	this.marka = marka;
    	this.modeloa = modeloa;
    	this.baztidorea = baztidorea;
    	this.nan = nan;
    }
    
    public KotxeakSartuClass(String matrikula, String marka, String modeloa, String baztidorea, String nan)
    {
    	this.matrikula = matrikula;
    	this.urtea = "1111/11/11";
    	this.marka = marka;
    	this.modeloa = modeloa;
    	this.baztidorea = baztidorea;
    	this.nan = nan;
    }

	public String getMatrikula() {
		return matrikula;
	}

	public void setMatrikula(String matrikula) {
		this.matrikula = matrikula;
	}

	public String getUrtea() {
		return urtea;
	}

	public void setUrtea(String urtea) {
		this.urtea = urtea;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModeloa() {
		return modeloa;
	}

	public void setModeloa(String modeloa) {
		this.modeloa = modeloa;
	}

	public String getBaztidorea() {
		return baztidorea;
	}

	public void setBaztidorea(String baztidorea) {
		this.baztidorea = baztidorea;
	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}
}
