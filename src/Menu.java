import java.io.*;

public class Menu {
    BufferedReader scanf = new BufferedReader(new InputStreamReader(System.in));
    Colegio colegio = new Colegio();
    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()){
            return false;
        }
        for (char c:str.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public void menu()throws IOException{
        int opcion;
        String grado,letra,input;
        Curso c;
        do{
            System.out.println("\n\nMenu de registro de asistencia");
            System.out.println("Ya hay cursos registrados desde primero básico a cuarto medio");
            System.out.println("(1) Menu de Cursos");
            System.out.println("(2) Menu de Estudiantes");
            System.out.println("(3) Realizar Asistencia");
            System.out.println("(4) Salir");
            System.out.print("Elija su opción");
            input = scanf.readLine();
            if(isNumeric(input)){
                opcion = Integer.parseInt(input);
            }
            else{
                System.out.println("\n\nValor no valido");
                opcion = 5;
            }
            switch(opcion)
            {
                case 1:
                    menuCursos();
                    break;
                case 2:
                    if (!colegio.cursoEstaVacio()){
                        colegio.mostrarCurso();
                        System.out.println("=============================================");
                        System.out.println("Ingresar grado de curso para añadir estudiantes");
                        grado = scanf.readLine();
                        System.out.println("Ingresar el paralelo o letra de curso para añadir estudiantes");
                        letra = scanf.readLine();
                        c = new Curso(grado,letra);
                        if (c.getGrado()!=null &&colegio.verificarCurso(c)!=null){
                            menuEstudiantes(colegio.verificarCurso(c));
                        }
                        else{
                            System.out.println("El curso seleccionado no se encuentra registrado");
                        }
                    }
                    else{
                        System.out.println("No hay cursos para poder tener estudiantes");
                    }
                    break;
                case 3:
                    if (!colegio.cursoEstaVacio()){
                        colegio.mostrarCurso();
                        System.out.println("Ingresar grado de curso para añadir estudiantes");
                        grado = scanf.readLine();
                        System.out.println("Ingresar el paralelo o letra de curso para añadir estudiantes");
                        letra = scanf.readLine();
                        c = new Curso(grado,letra);
                        c = colegio.verificarCurso(c);
                        if (c!=null){
                            if(!c.estaCursoVacio()){
                                asistencia(c);
                            }
                        }
                        else{
                            System.out.println("Curso no valido para pasar asistencia");
                        }
                    }
                    else{
                        System.out.println("No hay cursos para poder pasar asistencia");

                    }

                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingrese un numero valido");
                    break;
            }
        }while(opcion!= 4);
    }

    //menu de los cursos
    public void menuCursos()throws IOException{
        int opcion;
        String grado,letra,input;
        Curso c;
        do{
            System.out.println("\n\nMenu de Cursos");
            System.out.println("(1) Agregar Curso");
            System.out.println("(2) Buscar Curso");
            System.out.println("(3) Eliminar Curso");
            System.out.println("(4) Regresar menu principal...");
            System.out.print("Elija su opción");
            input = scanf.readLine();
            if(isNumeric(input)){
                opcion = Integer.parseInt(input);
            }
            else{
                System.out.println("\n\nValor no valido");
                opcion = 5;
            }
            switch (opcion){
                case 1:
                    //agregar
                    System.out.println("Ingrese el grado del curso");
                    grado = scanf.readLine();
                    System.out.println("Ingrese el paralelo o letra del curso");
                    letra = scanf.readLine();
                    c = new Curso(grado,letra);
                    if (colegio.verificarCurso(c)!=null){
                        System.out.println("Este curso ya está registrado");
                    }
                    else{
                        System.out.println("Agregada con exito");
                    }
                    break;
                case 2:
                    //buscar
                    if (colegio.cursoEstaVacio()){
                        System.out.println("No hay ningun curso registrado para buscar");
                        break;
                    }
                    System.out.println("Ingrese el grado del curso a buscar");
                    grado = scanf.readLine();
                    System.out.println("Ingrese el paralelo o letra del curso a buscar");
                    letra = scanf.readLine();
                    c = new Curso(grado,letra);
                    if (colegio.verificarCurso(c)!=null){
                        System.out.println("El curso se encuentra registrado");
                        colegio.mostrarCurso(c);
                    }
                    else{
                        System.out.println("El curso no se encuentra registrado");
                    }
                    break;
                case 3:
                    //eliminar
                    if (colegio.cursoEstaVacio()){
                        System.out.println("No hay ningun curso registrado para borrar");
                    }
                    else{
                        System.out.println("Ingrese el grado del curso a eliminar");
                        grado = scanf.readLine();
                        System.out.println("Ingrese el paralelo o letra del curso a eliminar");
                        letra = scanf.readLine();
                        c = new Curso(grado,letra);

                        if(colegio.removerCurso(c)){
                            System.out.println("Curso removido con exito");
                        }
                        else{
                            System.out.println("Curso no se encuentra registrado");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Regresando a menu principal...");
                    break;
                default:
                    System.out.println("Ingrese un numero valido");
                    break;
            }
        }while(opcion!=4);
    }


    //menu de estudiantes
    public void menuEstudiantes(Curso c)throws IOException{
        int opcion;
        String nombre,apellidoP,apellidoM,rut,input;
        Estudiante e;
        do{
            System.out.println("\n\nMenu de estudiantes");
            System.out.println("(1) Agregar estudiante");
            System.out.println("(2) Mostrar estudiante");
            System.out.println("(3) Expulsar estudiante");
            System.out.println("(4) Regresar menu principal");
            System.out.print("Elija su opción");
            input = scanf.readLine();
            if(isNumeric(input)){
                opcion = Integer.parseInt(input);
            }
            else{
                System.out.println("\n\nValor no valido");
                opcion = 5;
            }
            switch (opcion){
                case 1:
                    //agregar
                    System.out.println("Ingrese el primer nombre del estudiante:");
                    nombre = scanf.readLine();
                    System.out.println("Ingrese el primer apellido (apellido paterno) del estudiante:");
                    apellidoP = scanf.readLine();
                    System.out.println("Ingrese el segundo apellido (apellido materno) del estudiante:");
                    apellidoM = scanf.readLine();
                    System.out.println("Ingrese el rut del estudiante;");
                    rut = scanf.readLine();
                    e = new Estudiante(nombre,apellidoP,apellidoM,rut);
                    if(!colegio.verificarEstudiante(rut) && c.agregarEstudiante(rut,e)){
                        c.agregarEstudiante(e);
                        System.out.println("Agregado con exito");
                    }
                    else{
                        System.out.println("Estudiante ya se encuentra registrado");
                    }
                    break;
                case 2:
                    //buscar
                    if (!c.estaCursoVacio()){
                        System.out.println("Ingrese el rut del estudiante a buscar:");
                        rut = scanf.readLine();
                        c.mostrarEstudiante(rut);
                    }
                    else{
                        System.out.println("El curso actualmente no tiene estudiantes para buscar");
                    }
                    break;
                case 3:
                    //eliminar
                    if (!c.estaCursoVacio()){
                        System.out.println("Ingrese el rut del estudiante a eliminar");
                        rut = scanf.readLine();
                        if((c.removerEstudiante(rut))!=null){
                            e = c.getEstudiante(rut);
                            c.removerEstudiante(e);
                            System.out.println("El estudiante a sido expulsado con exito");
                        }
                        else{
                            System.out.println("El estudiante no se encuentra registrado en el curso");
                        }
                    }
                    else{
                        System.out.println("El curso actualmente no tiene estudiantes para expulsar");
                    }
                    break;
                case 4:
                    System.out.println("Regresando a menu principal...");
                    break;
                default:
                    System.out.println("Ingrese un numero valido");
                    break;
            }
        }while(opcion!=4);
    }

    public void asistencia(Curso c)throws IOException{
        int opcion;
        String fecha,hora,input;
        Asistencia asist;
        do{
            System.out.println("\n\n=============================================");
            System.out.println("Curso : "+c.getGrado()+"-"+c.getLetra());
            System.out.println("Cantidad de estudiantes : "+c.sizeCurso());
            System.out.println("=============================================\n");
            System.out.println("(1) Realizar asistencia");
            System.out.println("(2) Buscar asistencia");
            System.out.println("(3) Eliminar registro de asistencia");
            System.out.println("(4) Regresar al menu principal");
            System.out.print("Elija su opción");
            input = scanf.readLine();

            if(isNumeric(input)){
                opcion = Integer.parseInt(input);
            }
            else{
                System.out.println("\n\nValor no valido");
                opcion = 5;
            }
            switch (opcion){
                case 1:
                    //hacer asistencia
                    System.out.println("Ingrese fecha de paso de la asistencia formato DD/MM/AAAA :");
                    fecha = scanf.readLine();
                    if ((fecha.length() != 10) && ((fecha.charAt(2))!='/'&&(fecha.charAt(5))!='/')){
                        System.out.println("Formato no valido, intente otra vez");
                        break;
                    }
                    System.out.println("Ingrese hora de paso de la asistencia formato 24hrs (ej: 16:30):");
                    hora = scanf.readLine();
                    if (hora.charAt(2)!=':') {
                        System.out.println("Formato no valido, intente otra vez");
                        break;
                    }
                    asist = new Asistencia(fecha,hora,c);
                    if(colegio.verificarAsistencia(asist)!=null){
                        System.out.println("Asistencia ya tomada");
                        break;
                    }
                    if(asist.pasaAsistencia(c,asist)){
                        colegio.agregarAsistencia(asist);
                        System.out.println("Asistencia hecha con exito");
                    }

                    else{
                        System.out.println("\n\nCancelando pase de asistencia...");
                    }
                    break;
                case 2:
                    if(colegio.asistenciaEstaVacio()){
                        System.out.println("No hay ninguna asistencia registrada en el sistema");
                    }
                    else{
                        System.out.println("Ingrese fecha de la asistencia formato DD/MM/AAAA para buscar:");
                        fecha = scanf.readLine();
                        if ((fecha.length() != 10) && ((fecha.charAt(2))!='/'&&(fecha.charAt(5))!='/')){
                            System.out.println("Formato no valido, intente otra vez");
                            break;
                        }
                        System.out.println("Ingrese hora de la asistencia formato 24hrs (ej: 16:30) para buscar:");
                        hora = scanf.readLine();
                        if (hora.charAt(2)!=':') {
                            System.out.println("Formato no valido, intente otra vez");
                            break;
                        }
                        asist = new Asistencia(fecha,hora,c);
                        asist = colegio.verificarAsistencia(asist);
                        if (asist == null){
                            System.out.println("Asistencia no registrada en el sistema");
                            break;
                        }
                        else{
                            colegio.mostrarAsistencia(asist);
                        }
                    }
                    break;
                case 3:
                    //eliminar registro de un loquito
                    if(colegio.asistenciaEstaVacio()){
                        System.out.println("No hay asistencia registrada en este curso");
                        break;
                    }
                    System.out.println("Ingrese fecha de la asistencia formato DD/MM/AAAA para eliminar:");
                    fecha = scanf.readLine();
                    if ((fecha.length() != 10) && ((fecha.charAt(2))!='/'&&(fecha.charAt(5))!='/')){
                        System.out.println("Formato no valido, intente otra vez");
                        break;
                    }
                    System.out.println("Ingrese hora de la asistencia formato 24hrs (ej: 16:30) para eliminar:");
                    hora = scanf.readLine();
                    if (hora.charAt(2)!=':') {
                        System.out.println("Formato no valido, intente otra vez");
                        break;
                    }
                    asist = new Asistencia(fecha,hora,c);
                    asist = colegio.verificarAsistencia(asist);
                    if (asist==null){
                        System.out.println("Asistencia no registrada en el sistema");
                    }
                    else{
                        colegio.removerAsistencia(asist);
                        System.out.println("Registro de asistencia eliminada con exito");
                    }
                    break;
                case 4:
                    //salir
                    System.out.println("Regresando a menu principal...");
                    break;
                default:
                    System.out.println("Ingrese un numero valido");
                    break;
            }
        }while(opcion!=4);
    }
}