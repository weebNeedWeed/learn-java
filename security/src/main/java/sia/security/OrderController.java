package sia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderProps orderProps;

    @Autowired
    public OrderController(OrderProps orderProps) {
        this.orderProps = orderProps;
    }

    @GetMapping
    public String index() {
        return "orders";
    }

    @GetMapping("/pagesize")
    @ResponseBody
    public String pagesize() {
        return String.valueOf(orderProps.getPageSize());
    }
}
