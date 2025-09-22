package bg.project.muziapp2.service;

import bg.project.muziapp2.model.DTO.UserLoginDTO;
import bg.project.muziapp2.model.DTO.UserRegisterDTO;
import bg.project.muziapp2.model.DTO.ViewProfileDTO;
import bg.project.muziapp2.model.Song;
import bg.project.muziapp2.model.UserEntity;
import bg.project.muziapp2.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserHelperService userHelperService;


    public boolean register(UserRegisterDTO data){

        Optional<UserEntity> existingUser = userRepository
                .findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(data.getUsername());
        userEntity.setEmail(data.getEmail());
        userEntity.setPassword(passwordEncoder.encode(data.getPassword()));

        this.userRepository.save(userEntity);

        return true;
    }


    public List<Song> findFavourites(Long id) {

        return userRepository.findFavouritesById(id)
                .map(UserEntity::getFavouriteSongs)
                .orElseGet(ArrayList::new);


    }



    public ViewProfileDTO getProfileData() {


        Long userId = userHelperService.getUserId();
        Optional<UserEntity> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            return null;
        }

        UserEntity userEntity = userOptional.get();

        long addedSongsCount = userEntity.getSongsAdded() != null ? userEntity.getSongsAdded().size() : 0;
        long favouriteSongsCount = userEntity.getFavouriteSongs() != null ? userEntity.getFavouriteSongs().size() : 0;

        return new ViewProfileDTO(userEntity.getUsername(), addedSongsCount, favouriteSongsCount);

    }






}

