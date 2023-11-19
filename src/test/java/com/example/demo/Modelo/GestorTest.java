package com.example.demo.Modelo;

import com.example.demo.Persistence.Persistencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTest {

    private Gestor gestor;

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() {
        gestor = new Gestor();
        Persistencia.RUTA_ARCHIVO_ACTIVIDAD = tempDir.resolve("ArchivoActividad.txt").toString();
    }

    @Test
    public void testCargarActividadesWhenFileExistsAndContainsActivitiesThenActivitiesLoaded() throws IOException {
        // Arrange
        String testContent = "TestActivity@TestDescription@true@Task1$Task2$Task3\n";
        Files.write(Path.of(Persistencia.RUTA_ARCHIVO_ACTIVIDAD), testContent.getBytes());

        // Act
        gestor.cargarActividades();

        // Assert
        LinkedList<Actividad> actividades = gestor.getListaActividades();
        assertEquals(1, actividades.size());
        assertEquals("TestActivity", actividades.get(0).getNombre_Actividad());
        assertEquals("TestDescription", actividades.get(0).getDescripcion_Actividad());
        assertEquals("true", actividades.get(0).getEsObligatoria_Actividad());
    }

    @Test
    public void testCargarActividadesWhenFileDoesNotExistThenFileNotFoundExceptionThrown() {
        // Arrange
        Persistencia.RUTA_ARCHIVO_ACTIVIDAD = "non_existent_file.txt";

        // Act & Assert
        assertThrows(IOException.class, () -> gestor.cargarActividades());
    }

    @Test
    public void testCargarActividadesWhenIOExceptionOccursThenIOExceptionThrown() {
        // Arrange
        Persistencia.RUTA_ARCHIVO_ACTIVIDAD = null;

        // Act & Assert
        assertThrows(IOException.class, () -> gestor.cargarActividades());
    }
}