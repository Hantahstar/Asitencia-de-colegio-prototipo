import java.io.*;

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
    public void setCantidadAsist(int cantidadAsist){
        this.cantidadAsist = cantidadAsist;
    }
    public Estudiante getEstudiante(int i){
        return curso.getEstudiante(i);
    }
    public boolean pasaAsistencia(Curso c,Asistencia asist)throws IOException{
        //BufferedReader scanf = new BufferedReader(new InputStreamReader(System.in));
        int i,opcionAsist,cantidadPresente = 0;
        String input;
        Estudiante alumno;
        Menu in = new Menu();
        for (i=0;c.sizeCurso()>i;i++){
            System.out.println(c.getEstudiante(i).toString());
            System.out.println("(1) Presente\n(2) Falta\n(3) Falta extraordinaria\n(4) Salio antes de horario\n(5) Cancelar el pase de asistencia");
            input = in.scanf.readLine();
            if (in.isNumeric(input)){
                opcionAsist = Integer.parseInt(input);
            }
            else{
                System.out.println("\n\nValor no valido\nIntentalo de nuevo\n\n");
                i--;
                continue;
            }

            alumno = asist.getEstudiante(i);
            if(opcionAsist==1){
                //presente
                System.out.println(alumno.getNombre()+" "+alumno.getApellidoPaterno()+" "+alumno.getApellidoMaterno()+"\nPresente\n");
                alumno.estado(alumno);
                cantidadPresente++;
            }
            else if(opcionAsist==2){
                //falta falta
                System.out.println(alumno.getNombre()+" "+alumno.getApellidoPaterno()+" "+alumno.getApellidoMaterno()+"\nFaltó\n");
                alumno.estado();
            }
            else if(opcionAsist==3){
                //falta extraordinaria
                System.out.println(alumno.getNombre()+" "+alumno.getApellidoPaterno()+" "+alumno.getApellidoMaterno()+"\nFalta extraordinaria\n");
                alumno.estadoEspecial(alumno);
            }
            else if(opcionAsist==4){
                //salio antes de horario
                System.out.println(alumno.getNombre()+" "+alumno.getApellidoPaterno()+" "+alumno.getApellidoMaterno()+"\nSalió antes de horario\n");
                alumno.estadoEspecial();
            }
            else{
                return false;
            }
        }
        setCantidadAsist(cantidadPresente);
        return true;
    }
}
