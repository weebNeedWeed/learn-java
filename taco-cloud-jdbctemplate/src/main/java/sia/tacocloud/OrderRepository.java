package sia.tacocloud;

import java.util.Optional;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);

    Optional<TacoOrder> findById(Long id);
}
