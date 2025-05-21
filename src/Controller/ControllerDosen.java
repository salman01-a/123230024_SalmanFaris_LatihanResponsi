/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Dosen.*;
import View.Dosen.*;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author salmanfaris
 */
public class ControllerDosen {
    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;
    
    InterfaceDAODosen daoDosen;
    List<ModelDosen> daftarDosen;
    
    public ControllerDosen(ViewData halamanTable){
    this.halamanTable = halamanTable;
    this.daoDosen = new DAODosen();
    }
    
     public ControllerDosen(InputData halamaInputData){
    this.halamanInput = halamaInputData;
    this.daoDosen = new DAODosen();
    }
    
    
       public ControllerDosen(EditData halamanEdit){
    this.halamanEdit = halamanEdit;
    this.daoDosen = new DAODosen();
    }
       
    public void showAllDosen(){
    daftarDosen = daoDosen.getAll();
    ModelTable table = new ModelTable(daftarDosen);
    halamanTable.getTableDosen().setModel(table);
    }   
    
    public void insertDosen() {
        try {
            // Membuat "mahasiswa baru" yang isinya masih kosong
            ModelDosen DosenBaru = new ModelDosen();
            
            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
            */
            String nama = halamanInput.getInputNama();
            String nidn = halamanInput.getInputNIDN();

            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            // Mengisi nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            DosenBaru.setNama(nama);
            DosenBaru.setNidn(nidn);
            
            // Memasukkan "mahasiswa baru" ke dalam database.
            daoDosen.insert(DosenBaru);
            
            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");
            
            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editDosen(int id) {
        try {
            /*
              Membuat instance "mahasiswa yang mau diedit" buat 
              menyimpan informasi mahasiswa yang mau diedit.
            */
            ModelDosen DosenYangMauDiedit = new ModelDosen();
                        
            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
            */
            String nama = halamanEdit.getInputNama();
            String nidn = halamanEdit.getInputNIDN();

            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            // Mengisi id, nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            DosenYangMauDiedit.setId(id);
            DosenYangMauDiedit.setNama(nama);
            DosenYangMauDiedit.setNidn(nidn);
            
            // Memasukkan "mahasiswa baru" ke dalam database.
            daoDosen.update(DosenYangMauDiedit);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Data Dosen berhasil diubah.");

            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteDosen(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            /* 
              Memanggil method delete() untuk menghaous data dari DB
              berdasarkan id yang dipilih.
            */
            daoDosen.delete(id);
            
            // Menampilkan pop-up jika berhasil menghapus.
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            // Memanggil method "showAllMahasiswa()" untuk merefresh table.
            showAllDosen();
        }
    }
}
