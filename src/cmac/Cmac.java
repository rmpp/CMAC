package cmac;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Cmac {

	public Cmac() {
		this.mac = null;
	}

	byte[] mac;

	public byte[] getMac() {
		return mac;
	}

	public void setMac(byte[] mac) {
		this.mac = mac;
	}

	public static Cmac compute(byte[] iv, byte[] data,CmacKeys keys){
		Cmac cMac = new Cmac();

		try {

			int  nBlocks = data.length/16;

			int  lastBlen = data.length%16;

			byte[] lastState;
			byte[] lastBData;
			
			boolean padding=false;
			if(lastBlen>0){
				padding=true;
				nBlocks++;
			}


		

			if(nBlocks>1){
			byte[] cbcdata =  Arrays.copyOf(data, (nBlocks-1)*16);

			//CBC RAW
			SecretKeySpec aesKey= new SecretKeySpec(keys.getCbcRawKey(),"AES");
			IvParameterSpec ivparam = new IvParameterSpec(iv);
			Cipher cbcRaw = Cipher.getInstance("AES/CBC/NoPadding");
			cbcRaw.init(Cipher.ENCRYPT_MODE,aesKey, ivparam);

			byte[] cbcCt = cbcRaw.doFinal(cbcdata);


			//get cbc last state
			lastState = Arrays.copyOfRange(cbcCt, (nBlocks-2)*16, (nBlocks-1)*16);

			
			
			lastBData = Arrays.copyOfRange(data,(nBlocks-1)*16 ,(nBlocks)*16);

			}else{
				
				lastState = Arrays.copyOf(iv,16);
				
				lastBData = Arrays.copyOfRange(data,(nBlocks-1)*16 ,(nBlocks)*16);
				
			}
			
			
			//Add Padding if needed
			if(lastBlen!=0){

				for(int i=lastBlen;i<16;i++){
					lastBData[i]= (byte) (16-lastBlen);
				}
			}

			byte[] state = DatatypeConverter.parseHexBinary("00000000000000000000000000000000");

			/*
			for (int i = 0; i < 16; i++) {
				state[i] = (byte) (( lastState[i]) ^ ( lastBData[i]));
			}

			*/
			
			if(padding){
				for (int i = 0; i < 16; i++) {
					state[i] = (byte) ( (state[i]) ^ ( keys.getKey2()[i]));
				}
			}else{
				for (int i = 0; i < 16; i++) {
					state[i] = (byte) ( (state[i]) ^ ( keys.getKey1()[i]));
				}

			}


			//TODO Encript
			
			//CBC RAW
			SecretKeySpec aesKey= new SecretKeySpec(keys.getCbcRawKey(),"AES");
			IvParameterSpec ivparam = new IvParameterSpec(lastState);
			Cipher cbcRaw = Cipher.getInstance("AES/ECB/NoPadding");
			cbcRaw.init(Cipher.ENCRYPT_MODE,aesKey, ivparam);

			cMac.setMac(cbcRaw.doFinal(state));

			

		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return cMac;
	}

}