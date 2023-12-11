import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public void TextStart(){
        System.out.println("0 - Exit");
        System.out.println("1 - Log-in");
        System.out.println("2 - Register");
    }

    public void bankdisplay(){
        System.out.println("Select the bank name: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Banca Comerciala Romana");
        System.out.println("2 - Banca Transilvania");
        System.out.println("3 - Cec Bank");
        System.out.println("4 - Libra Bank");
    }

    public void options(){
        System.out.println("0 - Exit");
        System.out.println("1 - Log-out");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Transfer");
        System.out.println("5 - Delete account");
    }

    public int Login(Account a[], User u[], int nraccounts) throws IOException {
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

        for(int i = 0; i < nraccounts; i++){
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

    public void Register(Account a[], User u[], int nraccounts) throws IOException{
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

        System.out.println("User name: ");
        String u_name = reader.readLine();

        System.out.println("Password: ");
        String password = reader.readLine();

        a[nraccounts] = new Account(f_name, l_name, bank_name, 0);
        u[nraccounts] = new User(u_name, password, a[nraccounts].getId());
    }

    public int Start(Account a[], User u[], int nraccounts) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = -1;

        TextStart();
        int menuchoice = Integer.parseInt(reader.readLine());

        switch (menuchoice){
            case 0:
                return -1;
            case 1:
                index = Login(a, u, nraccounts);
                if(index == -1)
                    return -1;
                System.out.println("\nWelcome " + a[index].getFirst_name() + "\n");
                break;
            case 2:
                nraccounts++;
                User[] newU = new User[nraccounts];
                System.arraycopy(u, 0, newU, 0, u.length);
                u = newU;

                Account[] newA = new Account[nraccounts];
                System.arraycopy(a, 0, newA, 0, a.length);
                a = newA;

                Register(a, u, nraccounts-1);
                System.out.println("Your account has been registered");
                break;
        }
        return index;
    }
}
