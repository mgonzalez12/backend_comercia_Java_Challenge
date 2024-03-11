package com.tech.apicomerciatech.domain.constant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MessageContantTest {

    @Test
    void testMessageContant() {
        assertAll(
                () -> assertEquals("Cliente con ID", MessageContant.CLIENTE_ID_MESSAGE),
                () -> assertEquals("Juego con ID", MessageContant.GAME_ID_MESSAGE),
                () -> assertEquals("Alquiler con ID", MessageContant.RENT_ID_MESSAGE),
                () -> assertEquals("no encontrado", MessageContant.NO_ENCONTRADO_MESSAGE),
                () -> assertEquals("Faltan campos obligatorios", MessageContant.FALTAN_CAMPOS_OBLIGATORIOS),
                () -> assertEquals("Los IDs de cliente y juego deben ser mayores a 0", MessageContant.LOS_ID_MAYORES_ZERO),
                () -> assertEquals("El diasAlquilado debe ser positivo", MessageContant.EL_DIA_ALQUIER_POSITIVO),
                () -> assertEquals("Invalido formato para diasAlquilado", MessageContant.INVALIDO_FORMATO_DIA_ALQUILER),
                () -> assertEquals("El ID que buscas no se encuentra registrado", MessageContant.SEARCH_ID_ERROR),
                () -> assertEquals("error", MessageContant.TEXT_ERROR),
                () -> assertEquals("Parametro", MessageContant.TEXT_PARAMETRO),
                () -> assertEquals("debe ser de tipo", MessageContant.TEXT_DEBE_SER_DE_TIPO),
                () -> assertEquals("desconocido", MessageContant.TEXT_DESCONOCIDO),
                () -> assertEquals("Error Interno de Servidor", MessageContant.STATUS_500_ERROR_SERVER),
                () -> assertNull(MessageContant.NULLABLE_STRING),
                () -> assertNull(MessageContant.NULLABLE_LONG),
                () -> assertNull(MessageContant.NULLABLE_INTEGER),
                () -> assertNull(MessageContant.NULL_LOCAL_DATE),
                () -> assertNull(MessageContant.NULLABLE_ENUM)
        );
    }
}