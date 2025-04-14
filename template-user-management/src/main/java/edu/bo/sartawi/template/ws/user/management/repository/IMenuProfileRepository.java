package edu.bo.sartawi.template.ws.user.management.repository;

import edu.bo.sartawi.template.ws.user.management.dto.AccessUserDto;
import edu.bo.sartawi.template.ws.user.management.entity.TMenuProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuProfileRepository extends JpaRepository<TMenuProfileEntity, Integer> {
    void deleteAllByProfileId(Integer profileId);

    List<TMenuProfileEntity> findAllByProfileId(Integer profileId);

    @Query("""
            SELECT new edu.bo.sartawi.template.ws.user.management.dto.AccessUserDto(
                        m.menuId,
                        m.parentMenuId,
                        mp.orderNo,
                        m.name,
                        mp.canUpdate,
                        mp.canCreate,
                        mp.canRead,
                        null)
            FROM TMenuProfileEntity mp
                    INNER JOIN TMenuEntity m ON mp.menuId = m.menuId
            WHERE mp.profileId = :profileId
            ORDER BY mp.menuId DESC""")
    List<AccessUserDto> findAllAccessByProfileId(@Param("profileId") Integer profileId);
}
