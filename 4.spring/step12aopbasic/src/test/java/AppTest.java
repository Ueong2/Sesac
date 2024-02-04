import dev.spring.core.model.User;
import dev.spring.core.service.UserServiceV1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:application-contextV1.xml" })
public class AppTest {

    @Autowired
    private UserServiceV1 userServiceV1;

    @Test
    public void addUserV1() {
        User user = User.builder().name("yoo").level(1).build();
        userServiceV1.addUser(user);
    }

    @Test
    public void addUser2() {

    }
}