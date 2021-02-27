package br.com.ilia.digital.folhadeponto.repository;

import br.com.ilia.digital.folhadeponto.model.Momento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MomentoRepository extends JpaRepository<Momento, Long> {
}
