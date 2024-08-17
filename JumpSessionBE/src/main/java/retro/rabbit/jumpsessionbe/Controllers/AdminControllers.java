package retro.rabbit.jumpsessionbe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retro.rabbit.jumpsessionbe.Models.Admin;
import retro.rabbit.jumpsessionbe.Models.User;
import retro.rabbit.jumpsessionbe.Services.AdminService;

import java.util.List;

@RestController  //this class will act a rest API
@RequestMapping("/api/admin")  //
@CrossOrigin(origins = "http://localhost:4200")
public class AdminControllers {

        @Autowired  //putting service into this class (constructor)
        private AdminService adminService;

        @GetMapping("/get-admins")
        public List<Admin> getAllAdmins() {
            return adminService.getAllAdmins();
        }

        @GetMapping("/get-admin/{id}")
        public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
            return adminService.getAdminById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

    //gets the email relating to the specific user from the db
    //sql query from service class helps to get email of user
//    @GetMapping(value="/get-username")
//    public Admin getAdminByUsername(@PathVariable String username, String password) {
//        return adminService.getAdminByUsername(username,password);
//    }

        @PostMapping("/create-admin")
        public Admin createAdmin(@RequestBody Admin admin) {
            return adminService.createAdmin(admin);
        }

        @DeleteMapping("/delete-admin/{id}")
        public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
            adminService.deleteAdmin(id);
            return ResponseEntity.noContent().build();
        }

          // ToDo: Create assign controller
//    @PostMapping(value="/get-admins/{username}/{password}")
//    public Admin login(@RequestBody Admin admin)
//    {
//        return adminService.getAdminByUsername()
//    }
    }

