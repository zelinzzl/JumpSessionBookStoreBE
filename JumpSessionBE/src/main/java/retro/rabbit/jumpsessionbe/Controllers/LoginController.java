package retro.rabbit.jumpsessionbe.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retro.rabbit.jumpsessionbe.Models.Admin;
import retro.rabbit.jumpsessionbe.Services.AdminService;
import retro.rabbit.jumpsessionbe.Services.LoginService;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
   private AdminService adminService;
   @Autowired
   private LoginService loginService;

   public LoginController(AdminService adminService){
       this.adminService = adminService;
   }
    @PostMapping(value="/get-username")
    public Optional<Admin> LoginAdmin(@RequestBody Admin admin) {
        var adminUser = adminService.getAdminById(admin.getId());
//        boolean correctPassword = loginService.checkPassword(admin.getPassword(), admin.getId());
       if(adminUser.isPresent()){
           return adminUser;
       } else {
           return null;
       }
       //adminService.getAdminByUsername(username,password);

    }


}
