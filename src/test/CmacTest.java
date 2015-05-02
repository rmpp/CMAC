package test;

import static org.junit.Assert.*;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import cmac.Cmac;
import cmac.CmacKeys;

public class CmacTest {


	@Test
	public void testM0() {

		byte[] cbcKey =  DatatypeConverter.parseHexBinary("2b7e151628aed2a6abf7158809cf4f3c");
		byte[] key1 =  DatatypeConverter.parseHexBinary("fbeed618357133667c85e08f7236a8de");
		byte[] key2 =  DatatypeConverter.parseHexBinary("f7ddac306ae266ccf90bc11ee46d513b");

		byte[] iv = DatatypeConverter.parseHexBinary("00000000000000000000000000000000");

		byte[] text= DatatypeConverter.parseHexBinary("");

		CmacKeys keys = new CmacKeys(key1,key2,cbcKey);
		Cmac cMac = Cmac.compute(iv,text, keys);

		assertArrayEquals(DatatypeConverter.parseHexBinary("bb1d6929e95937287fa37d129b756746"), cMac.getMac());
	}


	@Test
	public void testM1() {

		byte[] cbcKey =  DatatypeConverter.parseHexBinary("2b7e151628aed2a6abf7158809cf4f3c");
		byte[] key1 =  DatatypeConverter.parseHexBinary("fbeed618357133667c85e08f7236a8de");
		byte[] key2 =  DatatypeConverter.parseHexBinary("f7ddac306ae266ccf90bc11ee46d513b");

		byte[] iv = DatatypeConverter.parseHexBinary("00000000000000000000000000000000");

		byte[] text= DatatypeConverter.parseHexBinary("6bc1bee22e409f96e93d7e117393172a");

		CmacKeys keys = new CmacKeys(key1,key2,cbcKey);
		Cmac cMac = Cmac.compute(iv,text, keys);

		assertArrayEquals(DatatypeConverter.parseHexBinary("070a16b46b4d4144f79bdd9dd04a287c"), cMac.getMac());
	}



	@Test
	public void testM2() {

		byte[] cbcKey =  DatatypeConverter.parseHexBinary("2b7e151628aed2a6abf7158809cf4f3c");
		byte[] key1 =  DatatypeConverter.parseHexBinary("fbeed618357133667c85e08f7236a8de");
		byte[] key2 =  DatatypeConverter.parseHexBinary("f7ddac306ae266ccf90bc11ee46d513b");

		byte[] iv = DatatypeConverter.parseHexBinary("00000000000000000000000000000000");
		byte[] text= DatatypeConverter.parseHexBinary("6bc1bee22e409f96e93d7e117393172aae"
				+ "2d8a571e03ac9c9eb76fac45af8e5130c8"
				+ "1c46a35ce411");

		CmacKeys keys = new CmacKeys(key1,key2,cbcKey);
		Cmac cMac = Cmac.compute(iv,text, keys);

		assertArrayEquals(DatatypeConverter.parseHexBinary("dfa66747de9ae63030ca32611497c827"), cMac.getMac());
	}



	@Test
	public void testM3() {

		byte[] cbcKey =  DatatypeConverter.parseHexBinary("2b7e151628aed2a6abf7158809cf4f3c");
		byte[] key1 =  DatatypeConverter.parseHexBinary("fbeed618357133667c85e08f7236a8de");
		byte[] key2 =  DatatypeConverter.parseHexBinary("f7ddac306ae266ccf90bc11ee46d513b");

		byte[] iv = DatatypeConverter.parseHexBinary("00000000000000000000000000000000");

		byte[] text= DatatypeConverter.parseHexBinary("6bc1bee22e409f96e93d7e117393172aae2d8a571e03ac9c9eb76fac45af8e5130c81c46a35ce411e5fbc1191a0a52eff69f2445df4f9b17ad2b417be66c3710");

		CmacKeys keys = new CmacKeys(key1,key2,cbcKey);
		Cmac cMac = Cmac.compute(iv,text, keys);

		assertArrayEquals(DatatypeConverter.parseHexBinary("51f0bebf7e3b9d92fc49741779363cfe"), cMac.getMac());
	}

}
