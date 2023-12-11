import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.NonReadableChannelException;

public class Main {
    public static void AccountInit(Account[] a, User[] u){
        a[0] = new Account("Ciprian", "Harnagea", "Banca Comerciala Romana", 2000);
        u[0] = new User("Cipy34", "123", a[0].getId());

        a[1] = new Account("Radu", "Cordunianu", "Libra Bank", -999.9);
        u[1] = new User("Radu1977", "123", a[1].getId());

        a[2] = new Account("Alexandru", "Popescu", "Banca Comerciala Romana", 1500);
        u[2] = new User("Alex", "123", a[2].getId());

        a[3] = new Account("Ioan", "Becali", "Banca Transilvania", 1590000);
        u[3] = new User("IBecali", "123", a[3].getId());

        a[4] = new Account("Ioan", "Becali", "Cec Bank", 60500000);
        u[4] = new User("IBecali2", "123", a[4].getId());
    }

    public static int Login(Account[] a, User[] u, int nraccounts, String bank_name) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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

    public static void MenuText(int choice){
        if(choice == 0){
            System.out.println("0 - Exit");
            System.out.println("1 - Log-in");
            System.out.println("2 - Register");
            return;
        }

        if(choice == 1){
            System.out.println("Select account bank: ");
            System.out.println("0 - Exit");
            System.out.println("1 - Banca Comerciala Romana");
            System.out.println("2 - Banca Transilvania");
            System.out.println("3 - Cec Bank");
            System.out.println("4 - Libra Bank");
            return;
        }

        if(choice == 2){
            System.out.println("0 - Exit");
            System.out.println("1 - Log-out");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Transfer");
            System.out.println("5 - Delete account");
            return;
        }
    }
    public static void main(String[] args) throws IOException {
        MenuText(0);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int mainchoice = Integer.parseInt(reader.readLine());

        if(mainchoice != 0){
            MenuText(1);
        }
        else return;

        int index = -1, nraccounts = 5;
        String bank_name = "";
        Account[] a = new Account[nraccounts];
        User[] u = new User[nraccounts];
        AccountInit(a, u);

        if(mainchoice == 1) {
            mainchoice = Integer.parseInt(reader.readLine());
            if (mainchoice == 1) {
                bank_name = "Banca Comerciala Romana";
            } else if (mainchoice == 2) {
                bank_name = "Banca Transilvania";
            } else if (mainchoice == 3) {
                bank_name = "Cec Bank";
            } else if (mainchoice == 4) {
                bank_name = "Libra Bank";
            }

            index = Login(a, u, nraccounts, bank_name);
        }

        if(mainchoice == 2) {
            mainchoice = Integer.parseInt(reader.readLine());

            if (nraccounts == a.length) {
                int newLength = a.length + 1;

                Account[] newA = new Account[newLength];
                User[] newU = new User[newLength];

                System.arraycopy(a, 0, newA, 0, a.length);
                System.arraycopy(u, 0, newU, 0, u.length);

                a = newA;
                u = newU;
            }

            if (mainchoice == 1) {
                bank_name = "Banca Comerciala Romana";
            } else if (mainchoice == 2) {
                bank_name = "Banca Transilvania";
            } else if (mainchoice == 3) {
                bank_name = "Cec Bank";
            } else if (mainchoice == 4) {
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
            nraccounts++;
            index = nraccounts-1;
        }

        if(index == -1)
            return;

        System.out.println(a[index].getFirst_name());
    }
}