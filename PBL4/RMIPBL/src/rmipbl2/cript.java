/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * Classe responsável por fazer todo o sistema criptogradia do sistema em
 * questão.utilizando uma chave já presente no código. Vale ressaltar que a
 * mensagem é recebida e enviada em modos de String enquanto elas estrão
 * legíveis. Fora isso, enquanto encriptadas, as mensagens são tratadas como
 * arrays de String
 *
 * @author Hugo Ribeiro e Washington Pagotto@author Hugo
 */
public class cript {

    private static String chaveSimetrica;

    private static SecretKey key;

    Cipher cipher;

    public cript() {
        try {
            cipher = Cipher.getInstance("AES");
            chaveSimetrica = "chave de 16bytes";
            key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(cript.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método usado para encriptar a mensagem que é passada em forma de String
     *
     * @param mensagem String que será a mensagem a ser encriptada
     * @return byte[] que é a mensagem encriptada
     */
    public byte[] encripta(String mensagem) {
        try {

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
            return mensagemEncriptada;
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(cript.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    /**
     * Método usado para decriptar a mensagem que é passada em forma de byte[]
     *
     * @param mensagem byte[] que será a mensagem a ser decriptada
     * @return String que é a mensagem decriptada
     */
    public String decripta(byte[] mensagem) {

        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] mensagemDescriptada = cipher.doFinal(mensagem);
            String mensagemOriginal = new String(mensagemDescriptada);
            return mensagemOriginal;
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(cript.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
