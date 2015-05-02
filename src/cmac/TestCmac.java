package cmac;

import javax.xml.bind.DatatypeConverter;


public class TestCmac {

	public static void main(String[] args) {

		System.out.println("");


		byte[] cbcKey =  DatatypeConverter.parseHexBinary("2b7e151628aed2a6abf7158809cf4f3c");
		byte[] key1 =  DatatypeConverter.parseHexBinary("fbeed618357133667c85e08f7236a8de");
		byte[] key2 =  DatatypeConverter.parseHexBinary("f7ddac306ae266ccf90bc11ee46d513b");

		byte[] IV = DatatypeConverter.parseHexBinary("00000000000000000000000000000000");

		byte[] text= DatatypeConverter.parseHexBinary("6bc1bee22e409f96e93d7e117393172a");

		CmacKeys keys = new CmacKeys(key1,key2,cbcKey);
		Cmac cmac = Cmac.compute(IV, text, keys);


		System.out.println(Integer.toHexString((byte) cmac.getMac()[0]));
	}

}
