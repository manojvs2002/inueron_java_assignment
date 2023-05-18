package javaAssignment1;

import java.util.Scanner;
 class InsufficientFundException extends Exception{
	
	public InsufficientFundException(String msg) {
		super(msg);
	}
	
}

public class BankSimulation {
	
	static double balance;
	
	public BankSimulation() {
		balance = 0.0;
	}
	
	public static void Deposite(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposited amt is"+balance);
			
		}
		else {
			System.out.print("invalid deposit amount, enter the valid amount");
		}
	}
	
	public static void Withdraw(double amount) throws InsufficientFundException{
		if(amount>0) {
			if(amount>balance) {
				//System.out.println("insufficient balance");
				throw new InsufficientFundException("insuffinet balance");
			}else
				balance-=amount;
			System.out.println("remainning balance is"+balance);
			
		}else {
			System.out.print("inavlid withdrawal amount");
		}
	}
	
	public static double getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		
		while(true) {
			System.out.println("enter the choice 1-deposite 2-withdraw 3-checkbal 4-exit");
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1->{
				System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                Deposite(depositAmount);
                break;
			}
			case 2->{
				int time=3;
				while(time>0) {
					System.out.println("enetr the withdrawal amt");
					double withdrawalamt=scanner.nextDouble();
					try {
						Withdraw(withdrawalamt);
						break;
					}
					catch(InsufficientFundException e) {
						System.out.println("exception caught: "+e.getMessage());
						time--;
					}
				}
					
				}
				case 3->{
					double currentBalance = getBalance();
                    System.out.println("Current balance: " + currentBalance);
				}
				case 4 -> {
				System.out.println("Thank you for using Bank Account Simulation. Goodbye!");
				scanner.close();
				System.exit(0);
				}
				default -> System.out.println("Invalid choice. Please select a valid option.");
					
				}
			}
		}
	

}
