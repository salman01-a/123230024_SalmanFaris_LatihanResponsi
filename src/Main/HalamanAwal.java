/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author salmanfaris
 */
public class HalamanAwal extends JFrame{
    JLabel header = new JLabel("Selamat Datang Di Program CRUD Dosen dan Mahasiswa ");
    JButton tombolDosen = new JButton("Dosen");
    JButton tombolMahasiswa = new JButton("Mahasiswa");
    
    public HalamanAwal(){
        setTitle("Selamat Datang!!!");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 540);
        
        
        add(header);
        add(tombolDosen);
        add(tombolMahasiswa);
        
        header.setBounds(100, 50, 500, 40); // Posisikan header di tengah atas

        tombolDosen.setBounds(176, 150, 200, 40); // Posisikan tombol dosen di tengah
tombolMahasiswa.setBounds(176, 220, 200, 40);
        
        
        tombolDosen.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               new View.Dosen.ViewData();
            }
        
        });
          tombolMahasiswa.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               new View.Mahasiswa.ViewData();
            }
        });
    }
    
}
    
