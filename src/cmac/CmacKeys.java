package cmac;

public class CmacKeys {

	byte[] key1;
	byte[] key2;
	byte[] cbcKey;

	public CmacKeys() {
		this.key1=null;
		this.key2=null;
		this.cbcKey=null;
	}

	public CmacKeys(byte[] key1, byte[] key2, byte[] cbcRawKey) {
		super();
		this.key1 = key1;
		this.key2 = key2;
		this.cbcKey = cbcRawKey;
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

	public byte[] getCbcKey() {
		return cbcKey;
	}

	public void setCbcKey(byte[] cbcKey) {
		this.cbcKey = cbcKey;
	}

}
