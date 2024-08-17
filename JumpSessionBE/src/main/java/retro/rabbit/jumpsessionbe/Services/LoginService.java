package retro.rabbit.jumpsessionbe.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import retro.rabbit.jumpsessionbe.Models.Admin;
import retro.rabbit.jumpsessionbe.Models.User;
import retro.rabbit.jumpsessionbe.Respositories.AdminRepository;
import retro.rabbit.jumpsessionbe.Respositories.LoginRepository;
import retro.rabbit.jumpsessionbe.Respositories.UserRepository;

@Service
public class LoginService {

    private AdminRepository adminRepository;

//    public ResponseEntity<Login> getUserByEmail(@PathVariable Long id) {
//        Object userService;
//        User user = userService.findByEmail(loginRequest.getEmail());
//        public Password getPassword(@PathVariable Long id) {
//            return userService.getUserById(id);
//        }
//
//        if (user != null && user.)
//
//    }

   // public User getUserByEmail(Long id) {
       // return loginRepository.findByEmail(Email).orElse(null);
   // }

    public Boolean checkPassword(String password,Long id){
        Admin admin = adminRepository.findById(id).orElseThrow();
        String adminPassword =admin.getPassword();

        if(adminPassword.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

}
