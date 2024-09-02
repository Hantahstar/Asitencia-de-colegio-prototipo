
public class Asistencia {
    private String fecha;
    private String hora;
    private Curso curso;
    private int cantidadAsist;
    public Asistencia(String fecha,String hora,Curso curso){
        setCurso(curso);
        setFecha(fecha);
        setHora(hora);
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public int getCantidadAsist() {
        return cantidadAsist;
    }
    public void setCantidadAsist(int cantidadAsist) {
        this.cantidadAsist = cantidadAsist;
    }
}
