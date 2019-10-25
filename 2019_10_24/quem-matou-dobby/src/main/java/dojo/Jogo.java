package dojo;

public class Jogo {
    String magia;
    String assassino;
    String local;

    public Jogo(String assassino, String local, String magia){
        this.magia = magia;
        this.assassino = assassino;
        this.local = local;
    }

    public int jogar(String assassino, String local, String magia) {
        if (!(this.assassino.equals(assassino))){
            return 1;
        }
        if(!(this.local.equals(local))){
            return 2;
        }
        if (!(this.magia.equals(magia)))
            return 3;

        return 0;
    }


}
