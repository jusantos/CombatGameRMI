package br.com.ifce.ppd.controller;

import br.com.ifce.ppd.gui.ClientGui;

import java.awt.event.ActionEvent;

public class Main {
    public void performAction(ActionEvent event) {
        /*
            Verificar as ações
               - Conectar (Criar uma thread Client para o chat)
               - Iniciar partida
               - Sair do Chat
               - Enviar MSG
               - Desistir da partida
         */

        if (event.getActionCommand().equals(null)) {

        }
    }

    public static void main(String[] args) {
        new ClientGui();
    }

}
