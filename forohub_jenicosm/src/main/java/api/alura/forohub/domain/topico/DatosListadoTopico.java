package api.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String autor, String curso) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor(), topico.getCurso());
    }
}
