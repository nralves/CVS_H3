import java.util.Iterator;


/*@
predicate AccountP(unit a,BankAccount c; unit b) = c != null &*& AccountInv(c,?n,?m) &*& b == unit;
@*/

class Bank {

	private LinkedList<BankAccount> store;
	private int nelems;
	private int capacity;

	/*@
predicate BankInv(int n, int m) = 
     this.nelems |-> n &*& 
     this.capacity |-> m &*& 
     m > 0 &*&
     this.store |-> ?a &*&
     a.length == m &*&
     0 <= n &*& n<=m &*& 
     array_slice_deep(a, 0, n, AccountP, unit,_, _) &*&
     array_slice(a, n, m,?rest) &*& all_eq(rest, null) == true ;
@*/

	//size > 0
	public Bank(int size)
	//@ requires siz>0;
	//@ ensures BankInv(0,siz);
	{
		nelems = 0;
		capacity = size;
		store = new LinkedList<BankAccount>();
	}

	//acc_code > 0
	public void addnewAccount(int acc_code)
	//@ requires BankInv(?n,?m) &*& n < m &*& code >= 0;
	//@ ensures  BankInv(n+1,m);
	{

		if(nelems < capacity){
			BankAccount bankAcc = new BankAccount(acc_code);
			store.addNode(bankAcc);
			nelems++;
		}

	}

	//acc_code > 0
	public int getbalance(int acc_code)
	//@ requires BankInv(?n,?m);
	//@ ensures BankInv(n,m);
	{

		BankAccount tmp = this.findBankAcc(acc_code);

		if(tmp != null)
			return tmp.getbalance();
		else
			return -1337;//TODO: E se a account não existir? O que retornar? (Credit Limit problem)

	}

	//acc_code > 0
	//cl > 0
	public int setclimit (int acc_code, int cl) {

		BankAccount tmp = this.findBankAcc(acc_code);
		if(tmp != null){
			tmp.setclimit(cl);
			return tmp.getclimit();
		}
		else
			return -1;

	}

	//acc_code > 0
	public int getclimit (int acc_code) {

		BankAccount tmp = this.findBankAcc(acc_code);

		if(tmp != null)
			return tmp.getclimit();
		else
			return -1;

	}

	//val > 0
	public int deposit(int acc_code, int val){

		BankAccount tmp = this.findBankAcc(acc_code);
		if(tmp != null){
			tmp.deposit(val);;
			return val;
		}
		else
			return -1;//Account not found

	}

	//acc_code > 0
	//val > 0
	public int widthdraw(int acc_code, int val){

		BankAccount tmp = this.findBankAcc(acc_code);
		if(tmp != null){
			if((tmp.getbalance()+tmp.getclimit())-val >= 0){
				tmp.withdraw(val);
				return val;
			}
			else
				return -1;//Error code for credit limit exceded

		}
		else
			return -2;//Error code for account not found
	}

	//acc_code_from > 0
	//acc_code_to > 0
	//val > 0
	public boolean transfer(int acc_code_from, int acc_code_to, int val){

		if(this.widthdraw(acc_code_from, val)>0){
			if(this.deposit(acc_code_to, val)>0)
				return true;
			else 
				return false;
		}
		else
			return false;
	}

	//acc_code > 0
	public void removeAccount(int acc_code){

		BankAccount tmp = this.findBankAcc(acc_code);
		if(tmp != null)
			store.removeNode(tmp);


	}

	//acc_code > 0
	private BankAccount findBankAcc(int acc_code){

		Iterator<BankAccount> it = store.iterator();
		while (it.hasNext()){

			BankAccount tmp = it.next();

			if (tmp.getcode() == acc_code) 
				return tmp;		
		}

		return null;

	}

}