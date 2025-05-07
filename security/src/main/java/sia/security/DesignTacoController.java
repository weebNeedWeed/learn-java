package sia.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/design")
@Controller
public class DesignTacoController {
    @GetMapping
    public String design(Principal principal, Authentication authentication, @AuthenticationPrincipal User user) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "design";
    }
}
