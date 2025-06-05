package exercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author u70874542189
 */
public class Aluno extends Pessoa {

    private int ra;

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;

    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Ra: " + getRa());
    }

}
