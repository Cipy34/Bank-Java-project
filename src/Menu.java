import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Menu {
    public void TextStart(){
        System.out.println("0 - Exit");
        System.out.println("1 - Log-in");
        System.out.println("2 - Register");
        System.out.println("3 - Administrator");
    }

    public void bankdisplay(){
        System.out.println("Select the bank name: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Banca Comerciala Romana");
        System.out.println("2 - Banca Transilvania");
        System.out.println("3 - Cec Bank");
        System.out.println("4 - Libra Bank");
    }

    public void Textoptions(){
        System.out.println("0 - Exit");
        System.out.println("1 - Log-out");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Transfer");
        System.out.println("5 - Personal informations");
        System.out.println("6 - Settings");
    }

    public void TextSettings(){
        System.out.println("0 - Exit");
        System.out.println("1 - Change personal informations");
        System.out.println("2 - Delete account");
    }

    public int Login(Account a[], User u[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String bank_name = "";

        bankdisplay();
        int menuchoice = Integer.parseInt(reader.readLine());

        if (menuchoice == 1) {
            bank_name = "Banca Comerciala Romana";
        } else if (menuchoice == 2) {
            bank_name = "Banca Transilvania";
        } else if (menuchoice == 3) {
            bank_name = "Cec Bank";
        } else if (menuchoice == 4) {
            bank_name = "Libra Bank";
        }

        System.out.print("Username: ");
        String user = reader.readLine();

        int index = -1, ok = 0;

        for(int i = 0; i < a.length; i++){
            if(u[i].getUser().equals(user)&&
                    a[i].getBank_name().equals(bank_name)) {
                index = i;
                ok = 1;
                break;
            }
        }

        if(ok == 1){
            System.out.print("Password: ");
            String password = reader.readLine();
            if(password.equals(u[index].getPassword()))
                return index;
            else{
                System.out.println("Incorrect password");
                return -1;
            }

        }

        System.out.println("Incorrect user");
        return -1;
    }

    public void Register(Account a[], User u[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bank_name = "";

        bankdisplay();
        int menuchoice = Integer.parseInt(reader.readLine());

        if (menuchoice == 1) {
            bank_name = "Banca Comerciala Romana";
        } else if (menuchoice == 2) {
            bank_name = "Banca Transilvania";
        } else if (menuchoice == 3) {
            bank_name = "Cec Bank";
        } else if (menuchoice == 4) {
            bank_name = "Libra Bank";
        }

        System.out.println("First name: ");
        String f_name = reader.readLine();

        System.out.println("Last name: ");
        String l_name = reader.readLine();

        int ok = 1;
        String u_name = "";
        while (ok == 1) {
            ok = 0;
            System.out.println("User name: ");
            u_name = reader.readLine();

            for (int i = 0; i < a.length - 1; i++)
                if (u[i].getUser().equals(u_name)&&
                    a[i].getBank_name().equals(bank_name)) {
                    System.out.println("This user-name is taken, try another one: ");
                    ok = 1;
                }

        }


        System.out.println("Password: ");
        String password = reader.readLine();

        a[a.length-1] = new Account(f_name, l_name, bank_name, 0);
        u[u.length-1] = new User(u_name, password, a[a.length-1].getId());
    }

    public void Start(Account a[], User u[], Transaction[] t) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = -1;

        TextStart();
        int menuchoice = Integer.parseInt(reader.readLine());

        switch (menuchoice){
            case 0:
                return;
            case 1:
                index = Login(a, u);
                if(index == -1)
                    return;
                System.out.println("\nWelcome " + a[index].getFirst_name() + "\n");
                break;
            case 2:
                User[] newU = new User[u.length+1];
                System.arraycopy(u, 0, newU, 0, u.length);
                u = newU;

                Account[] newA = new Account[a.length+1];
                System.arraycopy(a, 0, newA, 0, a.length);
                a = newA;

                Register(a, u);
                System.out.println("Your account has been registered");
                break;
        }

        if(index == -1)
            Start(a, u, t);

        Options(a, u, t, index);
    }

    public Transaction[] newTransaction(Transaction[] t){
        Transaction[] newT = new Transaction[t.length+1];
        System.arraycopy(t, 0, newT, 0, t.length);

        return newT;
    }

    public void Settings(Account[] a, User[] u, Transaction[] t, int index) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TextSettings();
        int menuchoice = Integer.parseInt(reader.readLine());
        String aux;

        switch (menuchoice){
            case 0:
                return;

            case 1:
                System.out.println("Do you want to change the first name?");
                System.out.println("0 - No");
                System.out.println("1 - Yes");

                menuchoice = Integer.parseInt(reader.readLine());
                if(menuchoice == 1){
                    System.out.println("First name: ");
                    aux = reader.readLine();

                    a[index].setFirst_name(aux);
                }

                System.out.println("Do you want to change the last name?");
                System.out.println("0 - No");
                System.out.println("1 - Yes");

                menuchoice = Integer.parseInt(reader.readLine());
                if(menuchoice == 1){
                    System.out.println("Last name: ");
                    aux = reader.readLine();

                    a[index].setLast_name(aux);
                }

                System.out.println("Do you want to change the user name?");
                System.out.println("0 - No");
                System.out.println("1 - Yes");

                menuchoice = Integer.parseInt(reader.readLine());
                if(menuchoice == 1){
                    System.out.println("User name: ");
                    aux = reader.readLine();

                    u[index].setUser(aux);
                }

                System.out.println("Do you want to change the password?");
                System.out.println("0 - No");
                System.out.println("1 - Yes");

                menuchoice = Integer.parseInt(reader.readLine());
                if(menuchoice == 1){
                    System.out.println("Password: ");
                    aux = reader.readLine();

                    u[index].setPassword(aux);
                }

            case 2:
                System.out.println("Are you sure you want to delete this account?");
                System.out.println("Type CONFIRM");
                System.out.println("!!!This account will be lost forever");

                aux = reader.readLine();
                if(aux.toLowerCase().equals("confirm")){
                    a[index] = null;
                    u[index] = null;
                }

        }
    }

    public void Options(Account[] a, User[] u, Transaction[] t, int index) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String iban = a[index].getIban();

        Textoptions();
        int choice = Integer.parseInt(reader.readLine());
        int menuchoice;
        int amount;

        switch (choice){
            case 0:
                System.out.println("Have a nice day " + a[index].getFirst_name() + "!");
                return;

            case 1:
                Start(a, u, t);
                return;

            case 2:
                System.out.println("0 - Exit");
                System.out.println("1 - Deposit in the same account");
                System.out.println("2 - Deposit in another account");

                menuchoice = Integer.parseInt(reader.readLine());

                if(menuchoice != 0){
                    if(menuchoice == 2){
                        System.out.println("Account iban: ");
                        iban = reader.readLine();
                    }

                    System.out.println("Amount: ");
                    amount = Integer.parseInt(reader.readLine());


                    t = newTransaction(t);
                    t[t.length - 1] = new Transaction(iban, amount, a[index].getId(),
                            "Deposited " + amount + ", iban: " + iban + " from id: " + a[index].getId() + " on " + LocalDateTime.now());

                    if(iban.equals(a[index].getIban()))
                        a[index].DepositMoney(amount);
                    else
                        for(int i = 0; i < a.length; i++)
                            if(a[i].getIban().equals(iban))
                                a[i].DepositMoney(amount);
                }

                break;

            case 3:
                System.out.println("How much money you want to withdraw?");
                System.out.println("Amount: ");

                amount = Integer.parseInt(reader.readLine());
                if(amount <= a[index].getBalance()){
                    a[index].WithdrawMoney(amount);

                    t = newTransaction(t);
                    t[t.length - 1] = new Transaction(iban, amount, "Withdrawn " + amount + " on " + LocalDateTime.now());
                }
                else
                    System.out.println("Insufficent fonds");
                break;

            case 4:
                System.out.println("Whom do you want to sent money to");
                System.out.println("Iban: ");
                iban = reader.readLine();

                System.out.println("Amount: ");
                amount = Integer.parseInt(reader.readLine());

                if(amount <= a[index].getBalance()){
                    a[index].WithdrawMoney(amount);

                    for(int i = 0; i < a.length; i++)
                        if(iban.equals(a[i].getIban()))
                            a[i].DepositMoney(amount);

                    t = newTransaction(t);
                    t[t.length - 1] = new Transaction(iban, a[index].getId(), amount,
                            "Transfered " + amount + " to " + iban + " on " + LocalDateTime.now());
                }
                else
                    System.out.println("Insufficent fonds");
                break;

            case 5:
                System.out.println(a[index].getFirst_name() + " " + a[index].getLast_name());
                System.out.println("Balance: " + a[index].getBalance());
                System.out.println("Iban: " + a[index].getIban());
                System.out.println("Account id: " + a[index].getId());
                break;

            case 6:
                Settings(a, u, t, index);
        }

        System.out.println("Do you want to make another transaction?");
        System.out.println("0 - No");
        System.out.println("1 - Yes");

        menuchoice = Integer.parseInt(reader.readLine());

        if(menuchoice == 1)
            Options(a, u, t, index);
    }


}
