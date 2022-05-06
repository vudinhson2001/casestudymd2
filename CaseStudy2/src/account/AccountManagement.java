package account;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
     List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }
    public void registerAnAccount(Account account){
        accountList.add(account);
    }
}
