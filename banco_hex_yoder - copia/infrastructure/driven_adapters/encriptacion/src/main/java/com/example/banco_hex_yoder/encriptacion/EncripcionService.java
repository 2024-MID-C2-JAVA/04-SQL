package com.example.banco_hex_yoder.encriptacion;


import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class EncripcionService {
    private static final String ALGORITMO = "AES/CBC/PKCS5PADDING";
    private static final String LLAVE_SIMETRICA = "banc0S3gur1d4d!@";
    private static final String VECTOR_INICIALIZACION = "AESInitVector@16";

    public String encriptar(String textoClaro) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(VECTOR_INICIALIZACION.getBytes("UTF-8"));
        SecretKeySpec keySpec = new SecretKeySpec(LLAVE_SIMETRICA.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        byte[] encriptado = cipher.doFinal(textoClaro.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encriptado);
    }

    public String desencriptar(String textoEncriptado) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(VECTOR_INICIALIZACION.getBytes("UTF-8"));
        SecretKeySpec keySpec = new SecretKeySpec(LLAVE_SIMETRICA.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

        byte[] decodificado = Base64.getDecoder().decode(textoEncriptado);
        byte[] desencriptado = cipher.doFinal(decodificado);
        return new String(desencriptado, "UTF-8");
    }
}
