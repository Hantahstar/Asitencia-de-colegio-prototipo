import java.util.ArrayList;

public class Colegio{
    private final ArrayList<Curso> cursos;
    private final ArrayList <Asistencia> asistencias;

    public Colegio() {
        this.cursos = new ArrayList<>();
        this.asistencias = new ArrayList<>();
        listarCurso();
    }
    public void listarCurso(){
        Curso primeroA = new Curso("1ro Basico", "A");
        cursos.add(primeroA);

        Curso segundoA = new Curso("2do Basico", "A");
        cursos.add(segundoA);

        Curso terceroA = new Curso("3ro Basico", "A");
        cursos.add(terceroA);

        Curso cuartoA = new Curso("4to Basico", "A");
        cursos.add(cuartoA);

        Curso quintoA = new Curso("5to Basico", "A");
        cursos.add(quintoA);

        Curso sextoA = new Curso("6to Basico", "A");
        cursos.add(sextoA);

        Curso septimoA = new Curso("7to Basico", "A");
        cursos.add(septimoA);

        Curso octavoA = new Curso("8vo Basico", "A");
        cursos.add(octavoA);

        Curso primeroMA = new Curso("1ro Medio","A");
        cursos.add(primeroMA);

        Curso segundoMA = new Curso("2do Medio","A");
        cursos.add(segundoMA);

        Curso terceroMA = new Curso("3ro Medio","A");
        cursos.add(terceroMA);

        Curso cuartoMA = new Curso("4to Medio","A");
        Estudiante eCuartoMA = new Estudiante("Daniel","Savedra","Erazo","212194026");
        Estudiante eCuartoMA2 = new Estudiante("Matías","Diaz","Castro","220380025");
        cursos.add(cuartoMA);
        cursos.get(11).agregarEstudiante("212194026",eCuartoMA);
        cursos.get(11).agregarEstudiante(eCuartoMA);
        cursos.get(11).agregarEstudiante("220380025",eCuartoMA2);
        cursos.get(11).agregarEstudiante(eCuartoMA2);
    }
    public boolean cursoEstaVacio(){
        return cursos.isEmpty();
    }
    public boolean asistenciaEstaVacio(){
        return asistencias.isEmpty();
    }
    public boolean removerCurso(Curso c){
        return cursos.remove(c);
    }
    public void removerAsistencia(Asistencia a){
        asistencias.remove(a);
    }
    public void agregarAsistencia(Asistencia a){
        asistencias.add(a);
    }
    public Curso verificarCurso(Curso c){
        int i;
        if (c==null){
            return null;
        }
        for (i=0;cursos.size()>i;i++){
            if (c.getGrado()!=null && c.getLetra()!=null){
                if(cursos.get(i).getGrado().equals(c.getGrado()) && cursos.get(i).getLetra().equals(c.getLetra())){
                    return cursos.get(i);
                }
            }

        }
        cursos.add(c);
        return null;
    }
    public void mostrarCurso(){
        int i;
        System.out.println("Estos son los cursos registrados :");
        System.out.println("=============================================");
        System.out.println(" ");
        for (i=0;cursos.size()>i;i++){
            System.out.println("=============================================");
            System.out.println("Informacion de clase :\nGrado: "+cursos.get(i).getGrado()+"\nParalelo: "+cursos.get(i).getLetra());
            System.out.println("Cantidad de estudiantes : "+cursos.get(i).sizeCurso());
            System.out.println("=============================================");
            System.out.println(" ");
        }
        System.out.println("=============================================");
    }
    public void mostrarCurso(Curso c){
        int i;
        for (i=0;cursos.size()>i;i++){
            if (cursos.get(i).getGrado().equals(c.getGrado()) && cursos.get(i).getLetra().equals(c.getLetra())){
                System.out.println("\n=============================================");
                System.out.println("Informacion de clase :\nGrado: "+cursos.get(i).getGrado()+"\nParalelo: "+cursos.get(i).getLetra());
                System.out.println("Cantidad de estudiantes : "+cursos.get(i).sizeCurso());
                System.out.println("=============================================\n");
                return;
            }
        }
    }
    public boolean verificarEstudiante(String rut){
        int i;
        for(i=0;cursos.size()>i;i++){
            if(cursos.get(i).contieneEstudiante(rut)){
                return true;
            }
        }
        return false;
    }
    public Asistencia verificarAsistencia(Asistencia a){
        int i;
        for (i=0;asistencias.size()>i;i++){
            if(asistencias.get(i).getFecha().equals(a.getFecha())&&asistencias.get(i).getHora().equals(a.getHora())){
                if (asistencias.get(i).getCurso().getGrado().equals(a.getCurso().getGrado()) && asistencias.get(i).getCurso().getLetra().equals(a.getCurso().getLetra())) {
                    return asistencias.get(i);
                }
            }
        }
        return null;
    }
    public void mostrarAsistencia(Asistencia asist){
        int i;
        Estudiante alumno;
        for (i=0;asist.getCurso().sizeCurso()>i;i++){
            alumno = asist.getEstudiante(i);
            System.out.println("======================================================================");
            System.out.println(alumno.toString());
            if(alumno.isAsistencia() && !alumno.isInasistenciaJust()){
                System.out.println("Presente el dia : "+asist.getFecha()+" hora: "+asist.getHora());
            }
            else if(!alumno.isAsistencia() && !alumno.isInasistenciaJust()){
                System.out.println("Falta el dia : "+asist.getFecha()+" hora: "+asist.getHora());
            }
            else if(!alumno.isAsistencia() && alumno.isInasistenciaJust()){
                System.out.println("Falta extraordinaria el dia : "+asist.getFecha()+" hora: "+asist.getHora());
            }
            else if(alumno.isAsistencia() && alumno.isInasistenciaJust()){
                System.out.println("Sale antes del horario el dia : "+asist.getFecha()+" hora: "+asist.getHora());
            }
            System.out.println("======================================================================");
        }
        System.out.println("Cantidad de presentes : "+asist.getCantidadAsist()+" de un total de "+asist.getCurso().sizeCurso());
    }

}