package bg.project.muziapp2.service;


import bg.project.muziapp2.model.UserEntity;
import bg.project.muziapp2.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHelperService {

    private static final String ROLE_PREFIX = "ROLE_";

    private final UserRepository userRepository;

    public UserEntity getUser() {
        return userRepository.findByUsername(getUserDetails().getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Long getUserId() {
        return getUser().getId();
    }


    public boolean hasRole(String role) {
        return getUserDetails().getAuthorities()
                .stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(ROLE_PREFIX + role));
    }


    public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }


    public boolean isAuthenticated() {
        return getAuthentication().getAuthorities().stream()
                .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(ROLE_PREFIX + "ANONYMOUS"));
    }


    public Authentication getAuthentication() {

        return SecurityContextHolder.getContext().getAuthentication();

    }





}
