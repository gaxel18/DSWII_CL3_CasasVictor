package pe.edu.cibertec.DSWII_CL3_CasasVictor.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioResponse {
    private Integer idusuario;
    private String nomusuario;
    private String token;
}

