package fr.kungfunantes.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Data
@Entity
@ApiModel
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope = Account.class)
public class Account {
    public enum AccountPrivilege {
        TEACHER,
        NONE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    private AccountPrivilege privilege;

    @Repository
    public static interface AccountRepository extends JpaRepository<Account, Long> {
    }
}