package br.org.order.infrastructure.jpa;

import br.org.order.infrastructure.jpa.entity.ProtheusTitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProtheusTitleRepository extends JpaRepository<ProtheusTitleEntity, Integer> {
    ProtheusTitleEntity findByOurNumber(String ourNumber);

    ProtheusTitleEntity findByAuthorizationCode(String authorizationCode);

    List<ProtheusTitleEntity> findByOurNumberNotNullAndSettlementUpdateDateIsNotNullAndSettlementIntegrationDateIsNull();

    @Modifying
    @Query("update ProtheusTitleEntity entity set entity.isSettlementIntegrated = 'S', entity.settlementIntegrationDate = ?1 where entity.code = ?2")
    @Transactional
    int updateSettlementControls(LocalDate settlementIntegrationDate, String code);

    List<ProtheusTitleEntity> findBySourceSystemAndSettlementUpdateDateGreaterThanEqual(String sourceSystem,
            LocalDate settlementUpdateDate);

    ProtheusTitleEntity findBySourceSystemAndCorrelationId(String sourceSystem, String correlationId);

}
