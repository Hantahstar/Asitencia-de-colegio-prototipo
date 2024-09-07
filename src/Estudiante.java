public class Estudiante {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rut;
    private boolean asistencia;
    private boolean inasistenciaJust;

    public Estudiante(String nombre,String apellidoPaterno,String apellidoMaterno,String rut){
        setNombre(nombre);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setRut(rut);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public boolean isAsistencia() {
        return asistencia;
    }
    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
    public boolean isInasistenciaJust() {
        return inasistenciaJust;
    }
    public void setInasistenciaJust(boolean inasistenciaJust) {
        this.inasistenciaJust = inasistenciaJust;
    }
    //presente
    public void estado(Estudiante e){
        e.setAsistencia(true);
        e.setInasistenciaJust(false);
    }
    //falta
    public void estado(){
        setAsistencia(false);
        setInasistenciaJust(false);
    }
    //justificado
    public void estadoEspecial(Estudiante e){
        e.setAsistencia(false);
        e.setInasistenciaJust(true);
    }
    //fuera de horario
    public void estadoEspecial(){
        setAsistencia(true);
        setInasistenciaJust(true);
    }
    public String toString() {
        return ("Nombre : "+nombre+" "+apellidoPaterno+" "+apellidoMaterno+"\nRut : "+rut);
    }
}