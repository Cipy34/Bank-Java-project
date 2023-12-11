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

    public static Account[] NewAccount(Account[] a, int nraccounts){
        Account[] newA = new Account[nraccounts];
        System.arraycopy(a, 0, newA, 0, a.length);
        return newA;
    }

    public static User[] NewUser(User[] u, int nraccounts){
        User[] newU = new User[nraccounts];
        System.arraycopy(u, 0, newU, 0, u.length);
        return newU;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int index;
        int nraccounts = 5;
        Account[] a = new Account[nraccounts];
        User[] u = new User[nraccounts];

        AccountInit(a, u);
        Menu m = new Menu();

        int mainchoice = Integer.parseInt(reader.readLine());
        switch(mainchoice){
            case 0:
                return;

            case 1:
                index = m.Login(a, u, nraccounts);
                if(index == -1)
                    return;
            case 2:
                nraccounts++;
                a = NewAccount(a, nraccounts);
                u = NewUser(u, nraccounts);

                m.Register(a, u, nraccounts-1);
        }

    }
}