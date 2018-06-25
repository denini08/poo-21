package poo.jogo.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.Clock;
import java.util.ArrayList;
import javax.swing.JTextField;

import poo.jogo.entidades.Banca;
import poo.jogo.entidades.Jogador;
import poo.jogo.entidades.interf.BancaInterface;

/**
 *
 * @author thoma
 */
public class guiInicial extends javax.swing.JFrame {

    /**
     * Creates new form guiInicial
     */
    public guiInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        quantidadeJogadores = new javax.swing.JComboBox<>();
        textJogador2 = new javax.swing.JTextField();
        textJogador3 = new javax.swing.JTextField();
        textJogador1 = new javax.swing.JTextField();
        textJogador4 = new javax.swing.JTextField();
        textJogador5 = new javax.swing.JTextField();
        textJogador6 = new javax.swing.JTextField();
        textJogador7 = new javax.swing.JTextField();
        jButtonJogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lTitulo.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lTitulo.setText("BlackJack - UPE Caruaru");

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel1.setText("Informe a quantidade de jogadores");

        quantidadeJogadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        quantidadeJogadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeJogadoresActionPerformed(evt);
            }
        });

        textJogador2.setText("Jogador 2");
        textJogador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador2MouseClicked(evt);
            }
        });

        textJogador3.setText("Jogador 3");
        textJogador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador3MouseClicked(evt);
            }
        });
        textJogador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJogador3ActionPerformed(evt);
            }
        });

        textJogador1.setText("Jogador 1");
        textJogador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador1MouseClicked(evt);
            }
        });

        textJogador4.setText("Jogador 4");
        textJogador4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador4MouseClicked(evt);
            }
        });

        textJogador5.setText("Jogador 5");
        textJogador5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador5MouseClicked(evt);
            }
        });

        textJogador6.setText("Jogador 6");
        textJogador6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador6MouseClicked(evt);
            }
        });

        textJogador7.setText("Jogador 7");
        textJogador7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textJogador7MouseClicked(evt);
            }
        });

        jButtonJogar.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jButtonJogar.setText("JOGAR!!!");
        jButtonJogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jButtonJogarMouseClicked(evt);
				} catch (Exception e) {
					//POPUP NOME IGUAL - RENICIA O JOGO
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantidadeJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textJogador3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textJogador4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textJogador5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textJogador6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textJogador7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonJogar)))))
                        .addGap(33, 33, 33)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(quantidadeJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(textJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonJogar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textJogador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textJogador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJogador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJogador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJogador7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void textJogador3ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void textJogador1MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador1.setText("");
    }                                         

    private void textJogador2MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador2.setText("");
    }                                         

    private void textJogador3MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador3.setText("");
    }                                         

    private void textJogador4MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador4.setText("");
    }                                         

    private void textJogador5MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador5.setText("");
    }                                         

    private void textJogador6MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador6.setText("");
    }                                         

    private void textJogador7MouseClicked(java.awt.event.MouseEvent evt) {                                          
        this.textJogador7.setText("");
    }                                         

    private void jButtonJogarMouseClicked(java.awt.event.MouseEvent evt) throws Exception { //CHAMA TUDOOOOOOOO
    	BancaInterface banca = null;
		banca = new Banca("BANCA", 5000);
    	JTextField lista[] = {textJogador1,textJogador2,textJogador3,textJogador4,textJogador5,textJogador6,textJogador7};
        int cont = this.quantidadeJogadores.getSelectedIndex() + 1;
        String texto = "textJogador";
        for (int i = 0; i < cont; i++){
            System.out.println(lista[i].getText());
            banca.obterJogadores(new Jogador(lista[i].getText(), 1000));
            
        }
        
        banca.iniciar();
    }                                         

    private void quantidadeJogadoresActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        JTextField lista[] = {textJogador1,textJogador2,textJogador3,textJogador4,textJogador5,textJogador6,textJogador7};
        int i = 0;
        for (i = 0; i <= this.quantidadeJogadores.getSelectedIndex(); i++){
            lista[i].setVisible(true);
        }
        for (int j = i; j < 7; j++){
            lista[j].setVisible(false);
        }
    }                                                   

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        JTextField lista[] = {textJogador1,textJogador2,textJogador3,textJogador4,textJogador5,textJogador6,textJogador7};
        for (int j = 1; j < 7; j++){
            lista[j].setVisible(false);
        }
    }                                 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guiInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiInicial().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonJogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JComboBox<String> quantidadeJogadores;
    private javax.swing.JTextField textJogador1;
    private javax.swing.JTextField textJogador2;
    private javax.swing.JTextField textJogador3;
    private javax.swing.JTextField textJogador4;
    private javax.swing.JTextField textJogador5;
    private javax.swing.JTextField textJogador6;
    private javax.swing.JTextField textJogador7;
    // End of variables declaration                   
    private  JTextField lista[] = {textJogador1,textJogador2,textJogador3,textJogador4,textJogador5,textJogador6,textJogador7};
}
