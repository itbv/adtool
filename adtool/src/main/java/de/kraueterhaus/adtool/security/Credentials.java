package de.kraueterhaus.adtool.security;

public class Credentials
{
     private String encryptedPassword;
     private byte[] salt;

     public Credentials(String encryptedPassword, byte[] salt)
     {
         this.encryptedPassword = encryptedPassword;
         this.salt = salt;
     }

     public String getEncryptedPassword()
     {
         return encryptedPassword;
     }

     public byte[] getSalt()
     {
         return salt;
     }


}

