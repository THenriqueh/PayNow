package paynow.example.paynow.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paynow.example.paynow.domain.user.User;
import paynow.example.paynow.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // DTO -> Entity
    @Mapping(target = "id", ignore = true) // id é gerado pelo banco
    User toEntity(UserDTO dto);

    // Entity -> DTO (se quiser listar depois)
    UserDTO toDto(User user);
}
