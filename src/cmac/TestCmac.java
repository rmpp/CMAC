package cmac;

import javax.xml.bind.DatatypeConverter;


public class TestCmac {

	public static void main(String[] args) {
	
			System.out.println("");
			
			byte[] key1 =  DatatypeConverter.parseHexBinary("000102030405060708090A0B0C0D0E0F");
			byte[] cbcKey =  DatatypeConverter.parseHexBinary("2b7e151628aed2a6abf7158809cf4f3c");

			byte[] IV = DatatypeConverter.parseHexBinary("000102030405060708090A0B0C0D0E0F");

			byte[] text= DatatypeConverter.parseHexBinary("000102030405060708090A0B0C0D0E0F1122");
			
			CmacKeys keys = new CmacKeys(key1,key1,cbcKey);
			Cmac mac = Cmac.compute(IV, text, keys);
			
			
			System.out.println("");
	}

}
