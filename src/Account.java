public class Account {
    private String first_name, last_name, iban, bank_name;
    private double balance;
    private int account_id;
    private static int generalId = 100;

    public Account(){
        balance = 0;
        account_id = generalId++;
    }

    public Account(String first_name_, String last_name_, String bank_name_, double balance_){
        first_name = first_name_;
        last_name = last_name_;
        bank_name = bank_name_;
        balance = balance_;
        account_id = generalId++;

        if(bank_name_.equals("Banca Comerciala Romana")){
            iban = "BCR" + account_id;
        } else if (bank_name_.equals("Banca Transilvania")) {
            iban = "BT" + account_id;
        } else if (bank_name_.equals("Cec Bank")) {
            iban = "CB" + account_id;
        } else if (bank_name_.equals("Libra Bank")) {
            iban = "LB" + account_id;
        } else{
            iban = "";
        }
    }

    void setBalance(double balance_){
        balance = balance_;
    }

    void setFirst_name(String first_name_){ first_name = first_name_; }

    void setLast_name(String last_name_){last_name = last_name_; }

    int getId(){
        return account_id;
    }

    String getFirst_name(){
        return first_name;
    }

    String getLast_name(){
        return last_name;
    }

    String getBank_name(){
        return bank_name;
    }

    String getIban(){
        return iban;
    }

    double getBalance(){
        return balance;
    }

    void DepositMoney(int amount){
        balance += amount;
    }

    void WithdrawMoney(int amount){
        balance -= amount;
    }
}
