package mainpackage.ExtraHelp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordHashSalt {
	
	public String getSalt(String username) {
		String salt=null;
		String url = "jdbc:mysql://localhost:3306/cinema_last";
        try {
        	Connection con = DriverManager.getConnection(url,"root","g1234567890");
            PreparedStatement preparedStatement = con.prepareStatement("SELECT salt from user where username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) 
            { 
            	salt=rs.getString("salt");
        	} 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salt;
	}


	
	
    public static String getHashMD5(String unhashed) {
        return getHashMD5(unhashed, "");
    }

    public static String getHashMD5(String unhashed, String salt) {
        // Hash the password.
        final String toHash = salt + unhashed + salt;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            return "00000000000000000000000000000000";
        }
        messageDigest.update(toHash.getBytes(), 0, toHash.length());
        String hashed = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashed.length() < 32) {
            hashed = "0" + hashed;
        }
        return hashed.toUpperCase();
    }
	
	
	
	
	
	

}
