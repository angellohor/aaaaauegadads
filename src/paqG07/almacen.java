package paqG07;

public class almacen {
    contenedor[][] p1;
    int []fila;
    int columna;

    public almacen() {
        p1 = new contenedor[10][12];
        for (int i = 0; i < 10; i++) {
            for (int a = 0; a < 12; a++) {
                p1[i][a] = new contenedor();
            }
        }
            fila = new int[10];
            columna = 0;
            for (int i = 0; i < 10; i++) {
                fila[i] = 0;
                for (int a = 0; a < 12; a++) {
                    p1[i][a].setNumero_identificación(0);
                }
            }
        }

    public String tostrings(){
        String j="contenedores libres:\n";
        for (int i = 0; i < 10; i++) {
            for (int a = 0; a < 12; a++) {
                if (p1[i][a].getNumero_identificación() == 0) {
                    j = j + "\tL";
                } else j = j + "\tO";
            }
            j += "\n";
        }
        return j;
    }

    public void apilacontenedor(contenedor a) {
        if (a.getPrioridad() == 1) {
            columna = 0;
            if (fila[columna]!=10) {
               this.copia(a);
            }else System.out.println("No se puede introducir otro contenedor de prioridad 1");
            fila[columna]++;

        }
        if (a.getPrioridad() == 2) {
            columna = 1;
            if (fila[columna]!=10) {
                this.copia(a);
            }else System.out.println("No se puede introducir otro contenedor de prioridad 2");
            fila[columna]++;

        }
        if (a.getPrioridad() == 3) {
            columna = 2;
            while (fila[columna] == 10) {
            columna++;
            }
            if (fila[columna]!=10) {
                this.copia(a);
            }else System.out.println("No se puede introducir otro contenedor de prioridad 3");
            fila[columna]++;

        }
        }
        public contenedor desapilacontenedor(int columna){
            contenedor a = new contenedor();
        if(fila[columna]>0) {
            fila[columna]--;
            a.copiac(p1[fila[columna]][columna]);
            p1[fila[columna]][columna].setNumero_identificación(0);
            p1[fila[columna]][columna].setPaís_procedencia("");
            return a;


        }else return null;

    }





    public String muestracontainer(int id) {

        int fil=-1;
        int col=0;
        for(int i=0;i<10;i++){
            for(int a=0; a<12;a++){
                if(id==(p1[i][a].getNumero_identificación())){
                    fil=i;
                    col=a;

                }
            }

        }
        if(fil==-1){
            return null;
        }else {
            return p1[fil][col].toString();
        }

    }
    public int cuantosa(String pais){
        int a=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<12;j++){
                if(pais.equals(p1[i][j].getPaís_procedencia())){
                    a++;
                }
            }
        }
        return a;
    }

    public void copia(contenedor a){
        p1[fila[columna]][columna].setDescripción(a.getDescripción());
        p1[fila[columna]][columna].setAduanas(a.isAduanas());
        p1[fila[columna]][columna].setEmpresa_receptora(a.getEmpresa_receptora());
        p1[fila[columna]][columna].setEstado(a.getEstado());
        p1[fila[columna]][columna].setEmpresa_remitente(a.getEmpresa_remitente());
        p1[fila[columna]][columna].setPeso(a.getPeso());
        p1[fila[columna]][columna].setPrioridad(a.getPrioridad());
        p1[fila[columna]][columna].setPaís_procedencia(a.getPaís_procedencia());
        p1[fila[columna]][columna].setNumero_identificación(a.getNumero_identificación());
    }

    public boolean espacioa(){
        if (p1[9][11].getNumero_identificación()==0 && p1[0][11].getNumero_identificación()==0 && p1[2][11].getNumero_identificación()==0 ){
            return false;
        }else return true;
    }

    public contenedor getcontainer(int id) {

        int fil=-1;
        int col=0;
        for(int i=0;i<10;i++){
            for(int a=0; a<12;a++){
                if(id==(p1[i][a].getNumero_identificación())){
                    fil=i;
                    col=a;

                }
            }

        }
        if(fil==-1){
            return null;
        }else {
            return p1[fil][col];
        }

    }
}