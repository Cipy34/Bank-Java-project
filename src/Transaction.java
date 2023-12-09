public class Transaction {
    private final String iban;
    private final int account_id;
    private final float ammount;
    private int commision;

    public Transaction(String iban_, int account_id_, float ammount_){
        iban = iban_;
        account_id = account_id_;
        ammount = ammount_;
    }

    String getIban(){
        return iban;
    }

    int getAccount_id(){
        return account_id;
    }

    float getAmmount(){
        return ammount;
    }

    int getCommision(){
        return commision;
    }
}
