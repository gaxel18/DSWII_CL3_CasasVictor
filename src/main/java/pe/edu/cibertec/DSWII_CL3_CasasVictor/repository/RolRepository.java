package pe.edu.cibertec.DSWII_CL3_CasasVictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL3_CasasVictor.model.bd.Rol;

@Repository
public interface RolRepository extends
        JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);
}

