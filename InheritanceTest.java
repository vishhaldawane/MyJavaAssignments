import javax.swing.JFrame;

abstract class Reptile
{
	 abstract void crawl();  // the method body is incomplete 	
	 
	 void eat() {
		 System.out.println("Non-abstract function....eating.... ");
	 }
	 
	 void breathing() {
		 System.out.println("non-abstract  function ...breathing.....");
	 }
}

class Snake extends Reptile {
	void crawl() {
		System.out.println("Snake is crawling....in the grass.....");
	}
	void shedSkin() { //exclusive 
		
	}
}

class RattledSnake extends Snake {
	
}

class Turtle extends Reptile
{
	void crawl() {
		System.out.println("Turtle is crawling in the spawining ground of the ocean");
	}
	void closeBodyParts() {
		
	}
}
class SnakeNeckedTurtle extends Turtle {
	
}

class Lizard extends Reptile 
{
	void crawl() {
		System.out.println("Lizard is crawling on the wall.....");
	}
}
class FrillNeckedLizard extends Lizard {
	
}

class Crocodile extends Reptile
{
	void crawl() {
		System.out.println("Crocodile is crawling at the banking of the river");
	}
}

class Allegator extends Crocodile {
	
	void rapidHuntWithBiteForce() {
		System.out.println("allegator is rapidly hunting a Tiger....with a great jaw bite force....");
	}
	
	void breathing() {
		
		System.out.println("allegator is breathing...at a slower rate....");
	}
}


abstract class Mammal
{
	abstract void giveBirth();
}
 /*
  * 
  * 1					Reptile <---------------------------
  * 					|	crawl();     					|
  * ---------------------------------------------			|<-- implementation
  *   |		   |			|					|			|
  * 2 Snake	  Turtle	Lizard	 		Crocodile <-----------------
  *   |		  |				|					|		           |<-- derivation
  *	3 Rattled	SnakeNeckedTurtle FrillNeckedLizard  Allegator<----
  *   Snake
  * 
  */
 

public class InheritanceTest {

	public static void main(String[] args) {
		
		Allegator alle = new Allegator();
		alle.rapidHuntWithBiteForce(); //1. exclusive
		alle.breathing();//3.overridden
		alle.eat(); //2.inherited
		alle.crawl(); //4.implemented
		
		
		
		
		
		
	//	BankAccount baObj = new BankAccount(444,"Jack",55006);
	//	baObj.showAccountDetails();
		
		/*
		
		// TODO Auto-generated method stub
		SavingsAccount savObj1 = new SavingsAccount(101, "Suraj Dev",50000,4.5f); // USER ROLE!!!
	
		//savObj1.setInitialValues(101, "Jack",50000,4.5f);
		savObj1.showAccountDetails();
		double simpleInterest = savObj1.calculateSimpleInterest();
		System.out.println("Simple interest is : "+simpleInterest);
		
		savObj1.withdraw(5000);
		
		savObj1.showAccountDetails();
		savObj1.deposit(4500);
		savObj1.showAccountDetails();
		
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
		
		CurrentAccount currObj2 = new CurrentAccount(102, "Smith",70000,0.25f);
		
		//currObj2.setInitialValues(102, "Smith",70000,0.25f);
		currObj2.showAccountDetails();
		double overDraftAmount = currObj2.calculateOverDraftAmount();
		System.out.println("Over Draft Amount is : "+overDraftAmount);
		
		
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");

		
		CreditAccount creObj3 = new CreditAccount(-103, "Robert",100000,20000);
		
		//creObj3.setInitialValues(103, "Robert",100000,20000);
		creObj3.showAccountDetails();
		double credibility = creObj3.calculateCredibility();
		System.out.println("Credibility Amount is : "+credibility);
		
		creObj3.withdraw(20000);
		creObj3.withdrawCash(7000);
		
		double credibility2 = creObj3.calculateCredibility();
		System.out.println("Credibility2 Amount is : "+credibility2);
		
		*/
		
	} //end of the main

}//end of the class

/*
 * 
 * 
 * 		1 2   3 4 5  6 7 8
 * 		a g   a r    w a l
 * 		a g   r a    w a l
 * 		a g   g a r  w a l
 * 
 * 		ag[arg][ra]r*wal
 * 
 * the character preceeding * should be matched zero or more times
 * 
 * 
 * 99.99% code is as it is like the previous one
 * 
 */



abstract class BankAccount // DEVELOPER ROLE!!!!
{
	//DATA MEMBER SECTION
	private int accountNumber; // DATA member
	private String accountHolderName; // DATA member
	protected double accountBalance; // DATA member
	
	private boolean isStringContainAlphabets(String acHolder) {
	return (	(!acHolder.equals("")	) && 
				(acHolder != null) && 
				(acHolder.matches("^[a-zA-Z]*$")
		));
	}
	
	BankAccount() {
		
	}
	//parameterized constructor
	BankAccount(int acno, String acHolder, double acbal) {
		System.out.println("BankAccount(int,String,double,float) ...constructor is setting the initial account details...");
		
		if(acno < 0) {
			RuntimeException rte = new RuntimeException("Account number cannot be in negative...");
			throw rte;
		}
		else
			accountNumber = acno; // set the local var to the DATA member 
		
		if(isStringContainAlphabets(acHolder)) {
			accountHolderName = acHolder;	
		}
		else {
			RuntimeException rte = new RuntimeException("Account name must have only alphabets.....");
			throw rte;
			
		}
		
		if( acbal< 0 ) {
			RuntimeException rte = new RuntimeException("Account balance cannot be in negative...");
			throw rte;

		}
		else
			accountBalance = acbal;
	}
	
	//MEMBER METHOD SECTION   local var     local var  local  var
	void setInitialValues(int acno, String acHolder, double acbal) {
		System.out.println("setting the initial account details...");
		accountNumber = acno; // set the local var to the DATA member 
		accountHolderName = acHolder;
		accountBalance = acbal;
	}
	
	void showAccountDetails() {
		System.out.println("------------- A C C O U N T   D E T A I L S -------------");
		System.out.println("[ Account Number  : "+accountNumber+" ]");
		System.out.println("[ Account Holder  : "+accountHolderName+" ]");
		System.out.println("[ Account Balance : "+accountBalance+" ]");
		System.out.println("---------------------------------------------------------");
	}
	void deposit(double amountToDeposit) {
		System.out.println("Depositing $"+amountToDeposit+" for AcNo:"+accountNumber);
		accountBalance = accountBalance + amountToDeposit; 
	}
	
	void withdraw(double amountToWithdraw) {
		System.out.println("Withdrawing $"+amountToWithdraw+" for AcNo:"+accountNumber);
		accountBalance = accountBalance - amountToWithdraw; 
	}

}

class SavingsAccount extends BankAccount // DEVELOPER ROLE!!!!
{
	//DATA MEMBER SECTION
	
	private float interestRate; //plus 4th data here
	
	SavingsAccount() {
		
	}
	//parameterized constructor
	SavingsAccount(int acno, String acHolder, double acbal, float ir) {
		super(acno,acHolder,acbal);
		System.out.println("SavingsAccount(int,String,double,float) ...constructor is setting the initial account details...");
		interestRate = ir;
	}
	
	//MEMBER METHOD SECTION   local var     local var  local  var
	void setInitialValues(int acno, String acHolder, double acbal, float ir) {
		System.out.println("setting the initial account details...");
		super.setInitialValues(acno, acHolder, acbal);
		interestRate = ir;
	}
	
	void showAccountDetails() {
		super.showAccountDetails();
		System.out.println("Interest Rate   : "+interestRate);
		
		System.out.println("--------------------");
	}
	void deposit(double amountToDeposit) { //overriding is always optional
		//some logic for SavingsAccount deposit....here... can be...
		super.deposit(amountToDeposit);
		//plus additional code in order to fulfill the logic of SavingsAccount
	}
	
	void withdraw(double amountToWithdraw) { //3. inherited-cum-overridding
		//some logic for SavingsAccount withdraw....here... can be...
		super.withdraw(amountToWithdraw); //2. inherited
		//plus additional code in order to withdraw the logic of SavingsAccount
	}
	
	double calculateSimpleInterest() { //1. exclusive 
		System.out.println("Calculating simple interest....");
		double simpleInterest = (accountBalance * 1 * interestRate)/100;
		return simpleInterest;
	}

}
/*
 * 
 * Personal
 * |
 * Student
 * |
 * Employee -> apply for another job -> 
 * 
 */
class CurrentAccount extends BankAccount
{
	//DATA MEMBER SECTION
	
	private float overdraftLimit; //4th field
	
	
	//MEMBER METHOD SECTION   local var     local var  local  var
	CurrentAccount(int acno, String acHolder, double acbal, float odl) {
		super(acno,acHolder,acbal);
		System.out.println("CurrentAccount(int,String,double,float) constructor is setting the initial account details...");
		overdraftLimit = odl;
		
	}
		
	//MEMBER METHOD SECTION   local var     local var  local  var
	void setInitialValues(int acno, String acHolder, double acbal, float odl) {
		System.out.println("setting the initial account details...");
		super.setInitialValues(acno, acHolder, acbal);
		overdraftLimit = odl;
		
	}
	
	void showAccountDetails() {
		super.showAccountDetails();
		System.out.println("OverDraftLimit  : "+overdraftLimit);
		System.out.println("--------------------");
	}
	void deposit(double amountToDeposit) {
		//logic for current account deposit...
		super.deposit(amountToDeposit);
		//logic for current account deposit
	}
	
	void withdraw(double amountToWithdraw) {
		//check the logic of overdraft here ..
		super.withdraw(amountToWithdraw);
		//some post activity here...
	}
	
	double calculateOverDraftAmount() { //1. exclusive function
		System.out.println("Calculating over draft amount....");
		double overDraftAmount = accountBalance + (accountBalance * overdraftLimit);
		return overDraftAmount;
	}

}
class CreditAccount extends BankAccount
{
	//DATA MEMBER SECTION
	
	private double creditLimit; //4th
	private double cashLimit; //5th
	
	
	//MEMBER METHOD SECTION   local var     local var  local  var
	CreditAccount(int acno, String acHolder, double acbal,  double cashLim) {
		super(acno,acHolder,acbal);
		System.out.println("CreditAccount(int,String,double, double) constructor is setting the initial account details...");
		creditLimit = acbal;
		cashLimit = cashLim;
	}
		
		
	//MEMBER METHOD SECTION   local var     local var  local  var
	void setInitialValues(int acno, String acHolder, double acbal,  double cashLim) {
		System.out.println("setting the initial account details...");
		super.setInitialValues(acno,acHolder,acbal);
		creditLimit = acbal;
		cashLimit = cashLim;
	}
	
	void showAccountDetails() {
		super.showAccountDetails();
		System.out.println("Credit Limit    : "+creditLimit);
		System.out.println("Cash Limit      : "+cashLimit);
		
		System.out.println("--------------------");
	}
	void deposit(double amountToDeposit) {
		//logic here too...
		super.deposit(amountToDeposit);
		//logic to suit the requirement of the credit account here
	}
	
	void withdraw(double amountToWithdraw) {
		//some logic to process the bill of the credit account
		super.withdraw(amountToWithdraw);
		creditLimit = accountBalance;
		// here too...
	}
	
	void withdrawCash(double amountToWithdraw) { //1. exclusive..
		super.withdraw(amountToWithdraw);
		cashLimit = cashLimit - amountToWithdraw;
	}
	
	double calculateCredibility() { //1. exclusive
		System.out.println("Calculating credibility....");
		double credibilityAmount = creditLimit + cashLimit;
		return credibilityAmount;
	}

}


/*
 
  Art Gallery
  
  
 incomplete
 
 				abstract	BankAccount
 								|
 				 	  			|acno,name,bal			  <--- generalized
 	 							|withdraw()
 	  							|deposit()
 	 							|showAccount()
 			-------------------------------------------
 			|					|					|
 	SavingsAccount			CurrentAccount		CreditAccount
 	    interestRate			overDraftLimit		  creditLimit,cashLimit <- specialized
		|
FixedDepositAccount
		|8.5
		compoundInterest
		|
FlexiFixedDepositAccount
		|7.5
		
 
 	Point2D
 	|isA
 	Point3D
 	|isA
 	ColouredPoint3D
 	|isA
 	ColouredPoint4D
 	
 
 */






// add one extra member ONLY in SavingsAccount as
// interestRate
// acno name acbalance  interestRate
// 104  Seema  50000     3.5f <-- as interest rate


//innovate CurrentAccount which is same as SavingsAccount
// it has "fourth" member as "float overdraftLimit"
// acno , name, acbalance, overdraftLimit
// 101    Jack  10000      0.25, ie 12500 can be overdrafted/withdrawn by jack


//innovate CreditAccount which is same as SavingsAccount
// it has fourth member as "double creditLimit"
//it has fifth member as "double cashLimit"

// acno name acbalance  creditLimit	cashLimit
// 102  Rita  50000      90000		20000	 <-- 





