package edu.bo.sartawi.template.ws.user.management.imp;

import edu.bo.sartawi.template.ws.user.management.config.mapper.MenuProfileMapper;
import edu.bo.sartawi.template.ws.user.management.config.mapper.ProfileMapper;
import edu.bo.sartawi.template.ws.user.management.dto.TMenuProfileDto;
import edu.bo.sartawi.template.ws.user.management.dto.TProfileDto;
import edu.bo.sartawi.template.ws.user.management.entity.TMenuProfileEntity;
import edu.bo.sartawi.template.ws.user.management.entity.TProfileEntity;
import edu.bo.sartawi.template.ws.user.management.repository.IMenuProfileRepository;
import edu.bo.sartawi.template.ws.user.management.repository.IProfileRepository;
import edu.bo.sartawi.template.ws.user.management.spec.IProfileSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileImp implements IProfileSpec {
    private final IProfileRepository profileRepository;
    private final IMenuProfileRepository menuProfileRepository;
    private final MenuProfileMapper menuProfileMapper;
    private final ProfileMapper profileMapper;

    @Autowired
    public ProfileImp(IProfileRepository profileRepository, IMenuProfileRepository menuProfileRepository,
                      MenuProfileMapper menuProfileMapper, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.menuProfileRepository = menuProfileRepository;
        this.menuProfileMapper = menuProfileMapper;
        this.profileMapper = profileMapper;
    }

    @Override
    public TProfileDto save(TProfileDto dto) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        String lastUser = dto.lastUser();
        List<TMenuProfileDto> accessMenu = dto.menu();
        TProfileEntity entity = this.profileMapper.mapToEntity(dto);
        List<TMenuProfileEntity> menuProfileEntities = this.menuProfileMapper.mapToEntities(accessMenu);
        entity.lastUser(lastUser);
        entity.lastTime(now);
        TProfileDto newProfile = this.profileMapper.mapToDto(this.profileRepository.save(entity));
        menuProfileEntities.parallelStream().forEach(menuProfile -> {
            menuProfile.lastTime(now);
            menuProfile.lastUser(lastUser);
            menuProfile.profileId(newProfile.profileId());
        });
        newProfile.menu(this.menuProfileMapper.mapToDtos(
                this.menuProfileRepository.saveAll(menuProfileEntities)));
        return newProfile;
    }

    @Override
    public TProfileDto update(TProfileDto dto) throws Exception {
        this.menuProfileRepository.deleteAllByProfileId(dto.profileId());
        TProfileEntity entity = this.profileMapper.mapToEntity(dto);
        entity.lastTime(LocalDateTime.now());
        entity.lastUser(dto.lastUser());
        TProfileDto newProfile = this.profileMapper.mapToDto(this.profileRepository.save(entity));
        List<TMenuProfileEntity> detailProfile = dto.menu()
                .parallelStream().map(m -> {
                    m.profileId(newProfile.profileId());
                    m.menuProfileId(null);
                    m.lastTime(newProfile.lastTime());
                    m.lastUser(newProfile.lastUser());
                    return this.menuProfileMapper.mapToEntity(m);
                }).toList();
        newProfile.menu(this.menuProfileMapper.mapToDtos(
                this.menuProfileRepository.saveAll(detailProfile)));
        return newProfile;
    }

    @Override
    public Optional<TProfileDto> findById(Integer id) throws Exception {
        return this.profileRepository.findById(id).map(this.profileMapper::mapToDto);
    }

    @Override
    public List<TProfileDto> findAll() throws Exception {
        return this.profileRepository.findAll()
                .stream().map(this.profileMapper::mapToDto).toList();
    }

    @Override
    public Optional<TProfileDto> findExtendedByProfileId(Integer profileId) throws Exception {
        Optional<TProfileDto> entity = this.findById(profileId);
        if (entity.isPresent()) {
            List<TMenuProfileDto> menuAccess = this.findAllMenuByProfileId(profileId);
            entity.get().menu(menuAccess);
            return entity;
        }
        return entity;
    }

    @Override
    public List<TMenuProfileDto> findAllMenuByProfileId(Integer profileId) throws Exception {
        return this.menuProfileMapper.mapToDtos(this.menuProfileRepository.findAllByProfileId(profileId));
    }
}
