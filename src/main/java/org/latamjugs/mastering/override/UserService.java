package org.latamjugs.mastering.override;



import org.latamjugs.mastering.override.obj.User;
import org.latamjugs.mastering.override.obj.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class UserService
{
    //private Set<User> userSet = new HashSet<User>();

    private List<User> userSet = new ArrayList<User>();


    public List<User> getUserSet() {
        return userSet;
    }

    /**
     * Ejemplo sin String
     * @param args
     */
    public static void main( String[] args )
    {
        UserService userService = new UserService();

        userService.adicionarUsuario("Luis");

        userService.adicionarUsuario("Hilmer");

        userService.adicionarUsuario("Luis");

        System.out.println(userService.userSet);
    }

    public void adicionarUsuario(String name) {
        User user = new User();
        user.setName(name);
        user.setPassword( "123" );
        user.setRolList(new ArrayList<Role>());
        userSet.add(user);
    }
}
