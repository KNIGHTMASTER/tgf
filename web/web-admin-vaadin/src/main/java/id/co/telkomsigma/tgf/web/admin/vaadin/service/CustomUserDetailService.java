package id.co.telkomsigma.tgf.web.admin.vaadin.service;

import id.co.telkomsigma.tgf.web.admin.vaadin.dto.RoleDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 10/26/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = new UserDTO();
        List<RoleDTO> roles = new ArrayList<>();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(username.equals("user")) {
            user.setName("user");
            user.setPassword("password");

            RoleDTO role = new RoleDTO();
            role.setName("ADMIN");
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            roles.add(role);
            user.setRoles(roles);
        }
        return user;
    }
}
