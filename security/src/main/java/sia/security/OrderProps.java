package sia.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "taco.orders")
public class OrderProps {
    /**
     * The size of each page
     */
    private int pageSize = 10;
}
