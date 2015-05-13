/*@
predicate AccountInv(BankAccount ac; int b, int c) =
    ac.accountid |-> ?id
    &*&
    id >= 0
    &*& 
    ac.balance |-> b
    &*& 
    ac.climit |-> c
    &*&
    b + c >= 0;
@*/

public class BankAccount {

private int balance;
private int climit;
private int accountid;

public BankAccount(int id)
//@ requires id >= 0;
//@ ensures AccountInv(this,0,0);
{
    balance = 0;
    climit = 0;
    accountid = id;
}

public void withdraw(int v)
//@ requires AccountInv(this,?b,?c) &*& v <= b + c;
//@ ensures AccountInv(this,b-v,c);

{
   balance  -= v;
}

public void deposit(int v)
//@ requires AccountInv(this,?b,?c) &*& v <= b + c;
//@ ensures AccountInv(this,b-v,c);

{
 balance  += v;
}

public int getcode()
//@ requires AccountInv(this,?b,?c);
//@ ensures AccountInv(this,b,c);

{
   return accountid;
}

public int getbalance()
//@ requires AccountInv(this,?b,?c);
//@ ensures AccountInv(this,b,c) &*& result == b;

{
   return balance;
}

public int getclimit()
//@ requires AccountInv(this,?b,?c);
//@ ensures AccountInv(this,b,c) &*& result == c;

{
   return climit;
}

public void setclimit(int newclimit)

{
	
	this.climit = newclimit;
	
}


//static public void main()
////@ requires true;
////@ ensures true;
//
//{
// BankAccount a1 = new BankAccount(10);
//
////@ assert AccountInv(a1,0,0);
//
//int v = a1.getbalance();
//
////@ assert v == 0;
//
//}


}
