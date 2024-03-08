package com.example.jwt2.services;


//import com.spring.model.security.JwtUserFactory;
//import com.s
import com.example.jwt2.model.Accounts;
import com.example.jwt2.model.CustomUserDetails;
import com.example.jwt2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private AccountRepository rs;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kiểm tra xem user có tồn tại trong database không?
//        Accounts user = rs.findByUserName(username);
        System.out.println(username);
        Accounts user = rs.findByUserName(username).get();
        System.out.println("======================================================");
        System.out.println(username );
        System.out.println(user);
        System.out.println("======================================================");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }



//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
//
////        Optional<Accounts> account = this.accountService.checkIfEmailExistsAndDeletedAt(email);
//        Optional<Accounts> account = this.accountService.checkIfEmailExistsAndDeletedAt(email);
//
//        if(account.isPresent()){
//            return JwtUserFactory.create(account.get());
//        }
//        throw new UsernameNotFoundException("User/Email not found.");
//    }
}
