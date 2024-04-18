package bankexamp; 
inport javax.ejb.Statful; 
@Stateful 
public class BankTransact implements BankTransactLocal{ 
int balance=10000; 
@override 
public int deposit (int amount){ 
balance=balance+amount; 
return balance; 
} 
@override 
public int withdraw (int amount){ 
balance=balance-amount 
return balance; 
}	 
} 
