package br.org.order.infrastructure.jpa;

import br.org.order.infrastructure.jpa.entity.IIFMensagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIFMensagemRepository extends JpaRepository<IIFMensagemEntity, Long> {

}
