package retro.rabbit.jumpsessionbe.Respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import retro.rabbit.jumpsessionbe.Models.Admin;
import retro.rabbit.jumpsessionbe.Models.User;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Long>{

    @Query(value = "SELECT Admin FROM Admin u WHERE u.username LIKE :username")
    Admin getAdminByUsername(@Param("username") String username);

}
