package cmac;

public class CmacKeys {

	byte[] key1;
	byte[] key2;
	byte[] cbcRawKey;
	
	public CmacKeys() {
		this.key1=null;
		this.key2=null;
		this.cbcRawKey=null;
	}

	public byte[] getKey1() {
		return key1;
	}

	public void setKey1(byte[] key1) {
		this.key1 = key1;
	}

	public byte[] getKey2() {
		return key2;
	}

	public void setKey2(byte[] key2) {
		this.key2 = key2;
	}

	public byte[] getCbcRawKey() {
		return cbcRawKey;
	}

	public void setCbcRawKey(byte[] cbcRawKey) {
		this.cbcRawKey = cbcRawKey;
	}
	
}
