import com.sun.source.tree.ClassTree;

public class Account {
    private String first_name, last_name, iban, bank_name;
    private float balance;
    private int account_id;
    private static int generalId = 100;

    public Account(){
        first_name = "";
        last_name = "";
        iban = "";
        bank_name = "";
        balance = 0;
        account_id = generalId++;
    }

    public Account(String first_name_, String last_name_, String iban_, String bank_name_, float balance_){
        first_name = first_name_;
        last_name = last_name_;
        iban = iban_;
        bank_name = bank_name_;
        balance = balance_;
    }

    void setFirst_name(String first_name_){
        first_name = first_name_;
    }
    void setLast_name(String last_name_){
        last_name = last_name_;
    }

    void setBank(String bank_name_){
        bank_name = bank_name_;
        if(bank_name_ == "Banca Comerciala Romana"){
            iban = "BCR" + account_id;
        } else if (bank_name_ == "Banca Transilvania") {
            iban = "BT" + account_id;
        } else if (bank_name_ == "Cec Bank") {
            iban = "CB" + account_id;
        } else if (bank_name_ == "Libra Bank") {
            iban = "LB" + account_id;
        }
    }

    void setBalance(float balance_){
        balance = balance_;
    }

    public int getId(){
        return account_id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public String getBank_name(){
        return bank_name;
    }

    public String getIban(){
        return iban;
    }

    public float getBalance(){
        return balance;
    }
}
