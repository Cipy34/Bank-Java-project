public class Transaction {
    private final String iban;
    private String details;
    private int account_id;
    private float amount;

    public Transaction(){
        iban = null;
        account_id = 0;
    }

    public Transaction(String iban_, int account_id_, float amount_, String details_){
        iban = iban_;
        account_id = account_id_;
        amount = amount_;
        details = details_;
    }

    public Transaction(String iban_, float amount_, String details_){
        iban = iban_;
        amount = amount_;
        details = details_;
    }

    String getIban(){
        return iban;
    }

    int getAccount_id(){
        return account_id;
    }

    float getAmount(){
        return amount;
    }

    String getDetails(){ return details; }
}
