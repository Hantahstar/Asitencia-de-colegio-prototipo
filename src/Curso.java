import java.util.*;

public class Curso {
    private String grado;
    private String letra;
    private final ArrayList <Estudiante> listCurso;
    private final Map <String,Estudiante> mapaEstudiante;

    public Curso(String grado,String letra) {
        setGrado(grado);
        setLetra(letra);
        this.listCurso = new ArrayList<>();
        this.mapaEstudiante = new HashMap<>();
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public boolean agregarEstudiante(String rut,Estudiante estudianteAgregar)
    {
        if (mapaEstudiante.containsKey(rut)){
            return false;
        }
        else{

            mapaEstudiante.put(rut,estudianteAgregar);
            return true;
        }

    }
    public void agregarEstudiante(Estudiante estudianteAgregar){
        listCurso.add(estudianteAgregar);
    }
    public void mostrarEstudiante(String rut){
        Estudiante e;
        if (mapaEstudiante.get(rut)!=null){
            e = mapaEstudiante.get(rut);
            System.out.println("Nombre estudiante: "+e.getNombre()+" "+e.getApellidoPaterno()+" "+e.getApellidoMaterno());
            System.out.println("Rut estudiante: "+e.getRut());
        }
        else{
            System.out.println("Estudiante no a sido registado en el curso");
        }
    }
    public Map<String,Estudiante> getCurso(){
        return mapaEstudiante;
    }
    public ArrayList <Estudiante> getListCurso(){
        return listCurso;
    }

}
