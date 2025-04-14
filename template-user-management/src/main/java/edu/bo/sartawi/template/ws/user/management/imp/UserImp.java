package edu.bo.sartawi.template.ws.user.management.imp;

import edu.bo.sartawi.template.ws.user.management.config.mapper.UserMapper;
import edu.bo.sartawi.template.ws.user.management.dto.AccessUserDto;
import edu.bo.sartawi.template.ws.user.management.dto.TUserDto;
import edu.bo.sartawi.template.ws.user.management.dto.UserWithAccessDto;
import edu.bo.sartawi.template.ws.user.management.entity.TUserEntity;
import edu.bo.sartawi.template.ws.user.management.repository.IMenuProfileRepository;
import edu.bo.sartawi.template.ws.user.management.repository.IUserRepository;
import edu.bo.sartawi.template.ws.user.management.spec.IUserSpec;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserImp implements IUserSpec {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;
    private final IMenuProfileRepository menuProfileRepository;

    public UserImp(IUserRepository userRepository, UserMapper userMapper, IMenuProfileRepository menuProfileRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.menuProfileRepository = menuProfileRepository;
    }

    @Override
    public TUserDto save(TUserDto dto) throws Exception {
        TUserEntity entity = this.userMapper.mapToEntity(dto);
        return this.userMapper.mapToDto(this.userRepository.save(entity));
    }

    @Override
    public TUserDto update(TUserDto dto) throws Exception {
        TUserEntity entity = this.userMapper.mapToEntity(dto);
        return this.userMapper.mapToDto(this.userRepository.save(entity));
    }

    @Override
    public Optional<TUserDto> findById(Integer id) throws Exception {
        return this.userRepository.findById(id).map(this.userMapper::mapToDto);
    }

    @Override
    public List<TUserDto> findAll() throws Exception {
        return this.userRepository.findAll().parallelStream()
                .map(this.userMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public UserWithAccessDto findWithAccessByUserId(Integer userId) throws Exception {
        Optional<TUserDto> user = this.findById(userId);
        if (user.isPresent()) {
            UserWithAccessDto userAccessDto = (UserWithAccessDto) user.get();
            List<AccessUserDto> accessOfUser = this.menuProfileRepository.findAllAccessByProfileId(userAccessDto.profileId());
            accessOfUser = this.groupByAccess(accessOfUser);
            userAccessDto.access(accessOfUser);
        }
        return null;
    }

    private List<AccessUserDto> groupByAccess(List<AccessUserDto> accessOfUser) {
        List<AccessUserDto> accessGrouped = new ArrayList<>();
        List<AccessUserDto> accessParents = accessOfUser.stream()
                .filter(a -> a.parentMenuId() == null).toList();
        Integer menuParentId = null;
        for (AccessUserDto access : accessParents) {

        }
        return accessParents;
    }

    @Override
    public UserWithAccessDto saveWithAccess(UserWithAccessDto userAccessDto) throws Exception {
        return null;
    }

    @Override
    public UserWithAccessDto updateWithAccess(UserWithAccessDto userAccessDto) throws Exception {
        return null;
    }
}
