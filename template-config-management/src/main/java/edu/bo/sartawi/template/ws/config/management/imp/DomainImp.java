package edu.bo.sartawi.template.ws.config.management.imp;

import edu.bo.sartawi.template.ws.config.management.config.mapper.DomainMapper;
import edu.bo.sartawi.template.ws.config.management.dto.TDomainDto;
import edu.bo.sartawi.template.ws.config.management.entity.TDomainEntity;
import edu.bo.sartawi.template.ws.config.management.repository.IDomainRepository;
import edu.bo.sartawi.template.ws.config.management.spec.IDomainSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DomainImp implements IDomainSpec {

    private final DomainMapper domainMapper;
    private final IDomainRepository domainRepository;

    @Autowired
    public DomainImp(IDomainRepository domainRepository, DomainMapper domainMapper) {
        this.domainRepository = domainRepository;
        this.domainMapper = domainMapper;
    }

    @Override
    public TDomainDto save(TDomainDto dto) throws Exception {
        TDomainEntity entity = this.domainMapper.mapToEntity(dto);
        entity.setLastUser("SUPER");
        entity.setLastTime(LocalDateTime.now());
        entity = this.domainRepository.save(entity);
        return this.domainMapper.mapToDto(entity);
    }

    @Override
    public TDomainDto update(TDomainDto dto) throws Exception {
        TDomainEntity entity = this.domainMapper.mapToEntity(dto);
        entity.setLastUser("SUPER");
        entity.setLastTime(LocalDateTime.now());
        entity = this.domainRepository.save(entity);
        return this.domainMapper.mapToDto(entity);
    }

    @Override
    public Optional<TDomainDto> findById(Integer domainId) throws Exception {
        Optional<TDomainEntity> entity = this.domainRepository.findById(domainId);
        return entity.map(this.domainMapper::mapToDto);
    }

    @Override
    public List<TDomainDto> findAll() throws Exception {
        return this.domainRepository.findAll().stream()
                .map(this.domainMapper::mapToDto).toList();
    }
}
