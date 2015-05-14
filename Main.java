
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	Bank bank = new Bank(100);
	
	bank.addnewAccount(001);
	bank.addnewAccount(002);
	
//	bank.widthdraw(001, 9);
//	bank.setclimit(001, 10);
//	bank.deposit(001, 10);
//	System.out.println("Balance for 001: " + bank.getbalance(001));
//	bank.widthdraw(001, 10);
//	System.out.println("Balance for 001: " + bank.getbalance(001));
//	bank.setclimit(001, 10);
//	System.out.println("Climit for 001: " + bank.getclimit(001));
//	bank.widthdraw(001, 11);
//	System.out.println("Balance for 001: " + bank.getbalance(001));
//	bank.removeAccount(001);
//	System.out.println("Climit for 001: " + bank.getbalance(001));
	
	bank.deposit(001, 10);
	bank.setclimit(001, 0);
	System.out.println("Balance for 001: " + bank.getbalance(001));
	System.out.println("Balance for 002: " + bank.getbalance(002));
	System.out.println(bank.transfer(003, 002, 15));
	System.out.println("Balance for 001: " + bank.getbalance(001));
	System.out.println("Balance for 002: " + bank.getbalance(002));
	
	
	
	
	}

}
