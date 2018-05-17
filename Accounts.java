/*
 * Name:Wenwen Xu
 * Date:10/09/17
 * Class:Cop3022
 * project:Project 1
 * Part Name:Accounts.java
 * */

import java.util.Scanner;

public class Accounts{
	
	//instant variables
	public String companyName;
	public String companyAddress;
	public User[] users;
	public int numOfelements;
	public int NOTFOUND = -1;
	
	Scanner scan = new Scanner(System.in);
	User user = new User();
	
	//default const.
	public Accounts(){
		
		companyName = "";
		companyAddress = "";
		User user[] = new User[7];	
	}
	
	//parameterized constructors
	public Accounts (String cn, String ca, int a ){
		companyName = cn;
		companyAddress = ca;
		User User1[] = new User[a];
	}
	
	//accessor and mutator method
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	public void addUser(User user){
		User newUser = new User();
		scan.nextInt();
		users = new User[numOfelements];
		
	}
	
	public User getUser(String users){
		user.userName = scan.nextLine();
		return user;
	}
	
	public boolean deleteUser(String N){
		user.userName = scan.nextLine();
		for(int i = 0; i < numOfelements; i++){
			if(N == user.userName){
				return true;
			}
		}
		findUser(user.userName);
		return false;
	}
	
	private int findUser(String F){
		 user.userName = scan.nextLine();
		 for(int i = 0; i < numOfelements; i++){
				if(user.userName == F){
					return i;
				}
			}
			return NOTFOUND;		 
	}
	
	public String toString(){
		String S = companyName + companyAddress + "\n" +
				"Username\t EncrPass\t ClearPass\t Key\n" + 
				user.userName + "\t" + user.encryptedPassword + "\t" + user.clearPassword + "\t" + user.key; 
		return S;
	}

}
