import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static int Login(User[] u, int nraccounts) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String user = reader.readLine();

        int index = -1, ok = 0;

        for(int i = 0; i < nraccounts; i++){
            if(u[i].getUser().equals(user)) {
                index = i;
                ok = 1;
                break;
            }
        }

        if(ok == 1){
            String password = reader.readLine();
            if(password.equals(u[index].getPassword()))
                return index;
            else
                return -1;
        }
        else
            return -1;
    }
    public static void main(String[] args) throws IOException {
        int nraccounts = 5, index;
        Account[] a = new Account[nraccounts];
        User[] u = new User[nraccounts];
        AccountInit(a, u);
        index = Login(u, nraccounts);
        if(index != -1)
            System.out.println("Log-in accepted");
        else
            System.out.println("Log-ind denied");

        System.out.println(a[index].getBalance());

    }
}