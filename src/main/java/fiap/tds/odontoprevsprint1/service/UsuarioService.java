//package fiap.tds.odontoprevsprint1.service;
//
//import fiap.tds.odontoprevsprint1.dto.UsuarioDTO;
//import fiap.tds.odontoprevsprint1.mapper.UsuarioMapper;
//import fiap.tds.odontoprevsprint1.models.Usuario;
//import fiap.tds.odontoprevsprint1.repository.UsuarioRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class UsuarioService {
//    private UsuarioRepository usuarioRepository;
//    private UsuarioMapper usuarioMapper;
//
//    //Listar Usuarios
//    @Transactional
//    public List<UsuarioDTO> getAllUsuarios(){
//        return usuarioRepository.findAll()
//                .stream()
//                .map(usuarioMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//
//    //Criar usuarios
//    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
//        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioDTO.getEmail());
//        if (usuarioExistente.isPresent()) {
//            throw new IllegalArgumentException("Usuario com email já existente.");
//        }
//        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
//        Usuario savedUsuario = usuarioRepository.save(usuario);
//        return usuarioMapper.toDto(savedUsuario);
//    }
//
//
//    //Buscar por email
//    @Transactional(readOnly = true)
//    public Optional<UsuarioDTO> buscarPorEmail(String email){
//        return usuarioRepository.findByEmail(email).map(usuarioMapper::toDto);
//    }
//}
