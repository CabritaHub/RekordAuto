package ERRONKA;

import java.util.Objects;

public class LoginClass {
	
    public String langileId;
    public String pasahitza;
    public String departamentua;
    
    public LoginClass(String langileId, String pasahitza)
    {
    	this.langileId = langileId;
    	this.pasahitza = pasahitza;
    	this.departamentua = "0000";
    }
    
    public LoginClass(String langileId, String pasahitza, String departamendua)
    {
    	this.langileId = langileId;
    	this.pasahitza = pasahitza;
    	this.departamentua = departamendua;
    }

	public String getLangileId() {
		return langileId;
	}

	public void setLangileId(String langileId) {
		this.langileId = langileId;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getDepartamentua() {
		return departamentua;
	}

	public void setDepartamentua(String departamentua) {
		this.departamentua = departamentua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departamentua, langileId, pasahitza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginClass other = (LoginClass) obj;
		return Objects.equals(departamentua, other.departamentua) && Objects.equals(langileId, other.langileId)
				&& Objects.equals(pasahitza, other.pasahitza);
	}    
}
