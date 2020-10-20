package miu.cs545.goldendomonlinemarketing.UserAccounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserRepository userRepository;
    public UserAccount saveUserAccount(UserAccount user){
       return  userRepository.save(user);
    }
}
