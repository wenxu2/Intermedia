/*
 * Name:Wenwen Xu
 * Date:10/09/17
 * Class:Cop3022
 * project:Project 1-User.java
 * */

	//instant variables
	public class User {
		public String userName;
		public String clearPassword;
		public String encryptedPassword;
		public String key;
		
	//default constructors
	public User(){
		userName = "";
		clearPassword = "";
		encryptedPassword ="";
		key = "";
		}
	
	public User(String un, String cp,String k){
		userName = un;
		clearPassword = cp;
		key = k;
		encrypt();
			
	} 
		
	// accessor & mutator
	public String getUserName() {
		return userName;
	}
	public void setUser(String user) {
		this.userName = user;
	}
	public String getClearPassword() {
		return clearPassword;
	}
	public void setClearPassword(String clearPassword) {
		this.clearPassword = clearPassword;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	private void encrypt(){
		int encryptedPassword1 = 0;
		
		for(int i=0,j=0;i<clearPassword.length();i++){
			char IP = clearPassword.charAt(i);
			char k = key.charAt(j);
			int EP = IP + k - 2 * '!';
			encryptedPassword1 = (char)EP % 90 + '!';
			char encryptedPassword = (char) encryptedPassword1;
			j = ++j % key.length();
			System.out.print(encryptedPassword);
		}
		
	}
	
	public String toString(){
		String info = userName + "\t" + encryptedPassword + "\t" + clearPassword + "\t" + key;
		return info;
		}
	}

