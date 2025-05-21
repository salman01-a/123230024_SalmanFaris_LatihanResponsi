/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author salmanfaris
 */
public class ModelTable extends AbstractTableModel{
    List<ModelDosen> daftarDosen;
    private String kolom[]= {"ID","Nama","NIDN"};
    public ModelTable(List<ModelDosen> daftarDosen){
        this.daftarDosen = daftarDosen;
    }
    
    @Override
    public int getRowCount() {
        return daftarDosen.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> daftarDosen.get(rowIndex).getId();
            case 1 -> daftarDosen.get(rowIndex).getNama();
            case 2 -> daftarDosen.get(rowIndex).getNidn();
            default -> null;
        };
    }     
     @Override
    public String getColumnName(int columnIndex){
    return kolom[columnIndex];
    }
    
}
