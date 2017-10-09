package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long>{

    Page<RunningInformation> findAll(Pageable pageable);

    void deleteByRunningId(@Param("runningId") String runningId);

}
