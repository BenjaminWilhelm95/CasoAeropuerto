import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Aeropuerto {
    // Atributos
    private String nombre;
    private List<Avion> aviones;

    // Constructor
    public Aeropuerto(String nombre) {
        this.nombre = nombre;
        this.aviones = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
    }

    // Métodos adicionales
    public void agregarAvion(Avion avion) {
        aviones.add(avion);
    }

    public List<Pasajero> buscarUsuariosPorFecha(Date fecha) {
        List<Pasajero> usuarios = new ArrayList<>();
        for (Avion avion : aviones) {
            for (Vuelo vuelo : avion.getVuelos()) {
                if (vuelo.getFecha().equals(fecha)) {
                    usuarios.addAll(vuelo.getPasajeros());
                }
            }
        }
        return usuarios;
    }

    public List<Pasajero> buscarUsuariosMismoVuelo(Vuelo vuelo) {
        for (Avion avion : aviones) {
            for (Vuelo v : avion.getVuelos()) {
                if (v.equals(vuelo)) {
                    return v.getPasajeros();
                }
            }
        }
        return null;
    }

    public List<Vuelo> buscarVuelosConCovidPositivo() {
        List<Vuelo> vuelosCovidPositivo = new ArrayList<>();
        for (Avion avion : aviones) {
            for (Vuelo vuelo : avion.getVuelos()) {
                if (vuelo.tieneCasosCovidPositivo()) {
                    vuelosCovidPositivo.add(vuelo);
                }
            }
        }
        return vuelosCovidPositivo;
    }
}

class Avion {
    // Atributos
    private List<Vuelo> vuelos;

    // Constructor
    public Avion() {
        this.vuelos = new ArrayList<>();
    }

    // Getters y Setters
    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    // Métodos adicionales
    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }
}

class Vuelo {
    // Atributos
    private String ciudadOrigen;
    private String ciudadDestino;
    private Date fecha;
    private List<Pasajero> pasajeros;

    // Constructor
    public Vuelo(String ciudadOrigen, String ciudadDestino, Date fecha) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fecha = fecha;
        this.pasajeros = new ArrayList<>();
    }

    // Getters y Setters
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    // Métodos adicionales
    public boolean tieneCasosCovidPositivo() {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getPasaporte().isResultadoCovidPositivo()) {
                return true;
            }
        }
        return false;
    }
}

class Pasajero {
    // Atributos
    private Pasaporte pasaporte;

    // Constructor
    public Pasajero(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    // Getter y Setter
    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }
}

class Piloto {
    // Atributos
    private Vuelo vueloAsignado;

    // Constructor
    public Piloto(Vuelo vueloAsignado) {
        this.vueloAsignado = vueloAsignado;
    }

    // Getter y Setter
    public Vuelo getVueloAsignado() {
        return vueloAsignado;
    }

    public void setVueloAsignado(Vuelo vueloAsignado) {
        this.vueloAsignado = vueloAsignado;
    }
}

class Pasaporte {
    // Atributos
    private boolean resultadoCovidPositivo;
    private Date fechaPCR;

    // Constructor
    public Pasaporte(boolean resultadoCovidPositivo, Date fechaPCR) {
        this.resultadoCovidPositivo = resultadoCovidPositivo;
        this.fechaPCR = fechaPCR;
    }

    // Getters y Setters
    public boolean isResultadoCovidPositivo() {
        return resultadoCovidPositivo;
    }

    public void setResultadoCovidPositivo(boolean resultadoCovidPositivo) {
        this.resultadoCovidPositivo = resultadoCovidPositivo;
    }

    public Date getFechaPCR() {
        return fechaPCR;
    }

    public void setFechaPCR(Date fechaPCR) {
        this.fechaPCR = fechaPCR;
    }
}
