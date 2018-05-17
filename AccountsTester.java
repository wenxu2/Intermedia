/*
 * Name:Wenwen Xu
 * Date:10/09/17
 * Class:Cop3022
 * project:Project 1
 * Part Name:AccountsTester.java
 * */



public class AccountsTester {
	public static void main(String[] main){
		User User1 = new User("jSmith", "password", "house");
		System.out.print(User1.getUserName() + "\t");
		System.out.print(User1.getEncryptedPassword() + "\t");
		System.out.print(User1.getClearPassword() + "\t");
		System.out.print(User1.getKey() + "\n");
		Accounts Acc1 = new Accounts("ABC Company", "1234 Holly Land, Pensacola Florida", 10);
		System.out.println(Acc1.getCompanyName() + "\t");
		System.out.println(Acc1.getCompanyAddress() + "\n");
		System.out.println(Acc1.toString());
		
		User User2 = new User("kMarry", "abcd1234", "friend");
		System.out.print(User2.getUserName() + "\t");
		System.out.print(User2.getEncryptedPassword() + "\t");
		System.out.print(User2.getClearPassword() + "\t");
		System.out.print(User2.getKey() + "\n");
		Accounts Acc2 = new Accounts("ABC Company", "1234 Holly Land, Pensacola Florida", 10);
		System.out.println(Acc2.getCompanyName() + "\t");
		System.out.println(Acc2.getCompanyAddress() + "\n");
		System.out.println(Acc2.toString());
		

		
	}

}
