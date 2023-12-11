public class Transaction {
    private final String iban;
    private final int account_id;
    private final float amount;
    private int commision;

    public Transaction(String iban_, int account_id_, float amount_){
        iban = iban_;
        account_id = account_id_;
        amount = amount_;
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

    int getCommision(){
        return commision;
    }
}
