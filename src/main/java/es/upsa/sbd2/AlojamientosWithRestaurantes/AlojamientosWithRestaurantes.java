package es.upsa.sbd2.AlojamientosWithRestaurantes;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Restaurante.Restaurante;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@JsonbTypeAdapter(AlojamientosWithRestJsonbAdapter.class)
public class AlojamientosWithRestaurantes
{
    private Alojamiento alojamiento;
    private List<Restaurante> restaurantes;
}
