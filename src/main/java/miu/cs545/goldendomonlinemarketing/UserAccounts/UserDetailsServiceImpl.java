package miu.cs545.goldendomonlinemarketing.UserAccounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.getUserByUsername(username);
        if (userAccount == null)
            throw new UsernameNotFoundException("Could not find userAccount");
        return new MyUserDetails(userAccount);
           }

   /* public UserAccount saveUserAccount(UserAccount user){
        return  userRepository.save(user);
    }*/

}
