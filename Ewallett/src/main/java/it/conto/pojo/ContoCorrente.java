package it.conto.pojo;

import java.util.Objects;

public class ContoCorrente {
	
	private String dataCreazione;
	private int iban;
	private int saldo;
	private String intestatario;
	
	public ContoCorrente(String dataCreazione, int iban, int saldo, String intestatario) {
		this.dataCreazione = dataCreazione;
		this.iban = iban;
		this.saldo = saldo;
		this.intestatario = intestatario;
	}

	
	public String getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public int getIban() {
		return iban;
	}

	public void setiban(int iban) {
		this.iban = iban;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(iban);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return iban == other.iban;
	}
	
	
	
	
	

}