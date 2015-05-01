package cmac;

public class Cmac {

	public Cmac() {
		// TODO Auto-generated constructor stub
	}

	byte[] mac;
	
	public byte[] getMac() {
		return mac;
	}

	public void setMac(byte[] mac) {
		this.mac = mac;
	}
	
	public static Cmac compute(byte[] iv, byte[] data,CmacKeys keys){
		return null;
		
	}

	
}
