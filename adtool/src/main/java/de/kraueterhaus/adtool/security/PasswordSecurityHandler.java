package de.kraueterhaus.adtool.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordSecurityHandler
{
     private static final String SHA_256 = "SHA-256";

     public static synchronized PasswordSecurityHandler getInstance()
     {
         return new PasswordSecurityHandler();
     }

     public Credentials getSecureCredentials(String password)
     {
         final byte[] salt = this.getSalt();
         String generatedPassword = this.getSecurePassword(password, salt);

         return new Credentials(generatedPassword, salt);
     }

     public String getSecurePassword(String password, byte[] salt)
     {
         String generatedPassword = null;
         try
         {
             StringBuilder builder = new StringBuilder();
             MessageDigest digest = MessageDigest.getInstance(SHA_256);
             digest.update(salt);
             byte[] bytes = digest.digest(password.getBytes());

             for (int i = 0; i < bytes.length; i++)
             {
                 builder
                     .append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                     .substring(1));
             }

             generatedPassword = builder.toString();
         }
         catch (NoSuchAlgorithmException exc)
         {
             exc.printStackTrace();
         }

         return generatedPassword;
     }

     private byte[] getSalt()
     {
         SecureRandom random = new SecureRandom();
         byte[] salt = new byte[16];
         random.nextBytes(salt);
         return salt;
     }
}


