package mainpackage.Administrators;
import java.util.ArrayList;
import mainpackage.implementation.Mainclass;
import mainpackage.moviecatalog.Films;
import mainpackage.Clients.*;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Admins extends Users implements Serializable{
	

	public void createUser(String name , String Username , String password) {}
	public void updateUser(String oldusername,String name, String username , String password) {} 
	public void deleteUser(String user_username, boolean delete){}
    public void searchUser(String user_username) {} 
	public void viewAllUsers() {}
	public void registerAdmin(String user_username) {} // ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΚΑΝΩ ΕΝΑΝ USER ADMIN
	
    
	
	
	public Admins(String name,String username,String password) {super(name,username,password);} // CONSTRUCTOR

	
	

}

