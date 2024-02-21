import java.util.ArrayList;
import java.util.List;

class PlanificadorTareas {
    private List<MiembroTripulacion> tripulacion;

    public PlanificadorTareas() {
        tripulacion = new ArrayList<>();
    }

    public void agregarMiembro(MiembroTripulacion miembro) {
        tripulacion.add(miembro);
    }

    public void distribuirTareas(List<Tarea> tareas) {
        int numTareas = tareas.size();
        int numMiembros = tripulacion.size();
        int indiceMiembro = 0;

        for (int i = 0; i < numTareas; i++) {
            MiembroTripulacion miembro = tripulacion.get(indiceMiembro);
            miembro.agregarTarea(tareas.get(i));

            indiceMiembro = (indiceMiembro + 1) % numMiembros; // Rotar a través de los miembros de la tripulación
        }
    }

    public void mostrarHorarios() {
        for (MiembroTripulacion miembro : tripulacion) {
            System.out.println("Horario de " + miembro.getNombre() + ":");
            miembro.mostrarTareas();
            System.out.println();
        }
    }

    public void calcularCargaTrabajoOptima() {
        // Calcular el producto escalar para cada miembro
        for (MiembroTripulacion miembro : tripulacion) {
            int cargaTrabajo = 0;
            for (Tarea tarea : miembro.getTareas()) {
                cargaTrabajo += tarea.getDuracion();
            }
            System.out.println("Carga de trabajo para " + miembro.getNombre() + ": " + cargaTrabajo);
        }
    }
}

class MiembroTripulacion {
    private String nombre;
    private List<Tarea> tareas;

    public MiembroTripulacion(String nombre) {
        this.nombre = nombre;
        tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void mostrarTareas() {
        for (Tarea tarea : tareas) {
            System.out.println(tarea.getNombre() + ": " + tarea.getDuracion() + " minutos");
        }
    }
}

class Tarea {
    private String nombre;
    private int duracion; // Duración en minutos

    public Tarea(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }
}

public class Planificador_de_tareas {
    public static void main(String[] args) {
        // Crear miembros de la tripulación
        MiembroTripulacion miembro1 = new MiembroTripulacion("Miembro 1");
        MiembroTripulacion miembro2 = new MiembroTripulacion("Miembro 2");

        // Agregar miembros al planificador
        PlanificadorTareas planificador = new PlanificadorTareas();
        planificador.agregarMiembro(miembro1);
        planificador.agregarMiembro(miembro2);

        // Crear tareas
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Tarea 1", 30));
        tareas.add(new Tarea("Tarea 2", 45));
        tareas.add(new Tarea("Tarea 3", 60));
        tareas.add(new Tarea("Tarea 4", 20));
        tareas.add(new Tarea("Tarea 5", 35));

        // Distribuir tareas
        planificador.distribuirTareas(tareas);

        // Mostrar horarios
        planificador.mostrarHorarios();

        // Calcular carga de trabajo óptima
        planificador.calcularCargaTrabajoOptima();
    }
}
